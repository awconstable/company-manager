var line_number = 0;

/* start on document load */
$(document).ready(function() {

    var id = $(document).getUrlParam("id");

	var datepickerEle = $("#date_issued");
    datepickerEle.datepicker();
    datepickerEle.datepicker('option', 'dateFormat', 'yy-mm-dd');

	getContactList();
	getVatList();

	$("#contact").change(function() {
		getContact();
	});
	
	$("#shipping_value").change(function(){
		calculateDocument();
	});
	
	$("#vat_rate").change(function(){
		calculateDocument();
	});

    if(id){
        console.log(id);
        getInvoice(id);
    } else {
        updateInvoiceHeader("TBA", new Date());
        create_line();
    }

});

function getInvoice(id) {

    $.getJSON("service/invoices/" + id, function (invoice){
        console.log(invoice.docNumber);

        updateContact(
            invoice.companyName,
            invoice.address1,
            invoice.address2,
            invoice.address3,
            invoice.city,
            invoice.postcode,
            invoice.country,
            invoice.email);

        console.log("contact id : " + invoice.contactId);

        //FIXME: Need to select the contact. Not working for some reason. Race condition?
        //$("#contact").selectOptions(invoice.accountRef);

        updateInvoiceHeader(invoice.docNumber, invoice.dateIssued, invoice.clientRef);

        //TODO: update vat rate select box

        updateInvoiceTotals(invoice.shippingValue, invoice.netValue, invoice.vatValue, invoice.totalValue);
    });

}

function updateInvoiceHeader(invoiceNumber, dateIssued, customerRef){

    $("#invoice_number").val(invoiceNumber);
    $("#date_issued").val($.format.date(dateIssued, "yyyy-MM-dd"));
    $("#customer_ref").val(customerRef);

}

function updateInvoiceTotals(shippingValue, netValue, vatValue, totalValue){

    $("#shipping_value").val(shippingValue.toFixed(2));
    $("#net_value").val(netValue.toFixed(2));
    $("#vat_value").val(vatValue.toFixed(2));
    $("#total_value").val(totalValue.toFixed(2));

}

function getContactList() {

    var contactEle =  $('#contact');

    contactEle.attr("disabled", true);

	$.getJSON("service/contacts", function(data) {

		$.each(data, function(i, contact) {
			$("#contact").addOption(contact.id, contact.accountRef);
		});
		$("#contact").selectOptions('none', true);

	});
    contactEle.removeAttr("disabled");
}

function updateContact(companyName, address1, address2, address3, city, postcode, country, email){
    $("#company_name").val(companyName);
    $("#address_1").val(address1);
    $("#address_2").val(address2);
    $("#address_3").val(address3);
    $("#city").val(city);
    $("#postcode").val(postcode);
    $("#country").val(country);
    $("#email").val(email);
}

function getContact() {
    var id = $("#contact").val();

    if (id == 'none') {
        updateContact();
    } else {
        $.getJSON("service/contacts/" + id, function (contact) {

            updateContact(
                contact.companyName,
                contact.address1,
                contact.address2,
                contact.address3,
                contact.city,
                contact.postcode,
                contact.country,
                contact.email);
        });
    }
}

function getVatList() {

    var vatRateEle = $('#vat_rate');

    vatRateEle.attr("disabled", true);

	$.getJSON("service/vat", function(data) {
		$.each(data, function(i, vatRate) {
            vatRateEle.addOption(vatRate.rate, vatRate.rate);
			if (vatRate.defaultRate == 1) {
				default_rate = vatRate.rate;
			}
		});
        vatRateEle.selectOptions(default_rate, true);

	});
    vatRateEle.removeAttr("disabled");
}

function getProduct(line_number) {
    var id = $("#select_product_" + line_number).val();

	if (id != 'none') {
		$.getJSON("service/products/" + id, function(product) {
				$("#prod_description_line_" + line_number).val(
                    product.description);
				$("#prod_retail_cost_line_" + line_number).val(
                    product.retailCost);
			calculateDocument();
		});
	} else {
		resetRow(line_number);
	}

}

function getProductList(line) {

    var productLineEle =  $("#select_product_" + line);

    productLineEle.attr("disabled", true);

	$.getJSON("service/products", function(data) {
		$.each(data, function(i, product) {
            productLineEle.addOption(product.id,
                product.productRef);
		});
        productLineEle.selectOptions('none', true);

	});
    productLineEle.removeAttr("disabled");
}

function submit_form() {
	if (validate()) {
		alert("Send a post request");
	}
}

function resetRow(line_number) {
	$('#prod_description_line_' + line_number).val("");
	$('#prod_retail_cost_line_' + line_number).val(0.00);
	$('#prod_discount_cost_line_' + line_number).val(0.00);
	$('#quantity_line_' + line_number).val(1);
	$('#discount_line_' + line_number).val(0);
	$('#line_total_line_' + line_number).val(0.00);
	calculateDocument();
}

function calculateDocument() {
	var net_invoice_value = 0;
	var vat_rate = $('#vat_rate').val();

    var floatRetailCost;
    var floatQuantity;
    var floatDiscount;
    var floatDiscountCost;
    var line_total;
    for (i = 1; i < (line_number + 1); i++) {
        floatRetailCost = parseFloat($('#prod_retail_cost_line_' + i).val());
        floatQuantity = parseFloat($('#quantity_line_' + i).val());
        floatDiscount = parseFloat($('#discount_line_' + i).val());
        floatDiscount = (100 - floatDiscount) / 100;
        floatDiscountCost = floatRetailCost * floatDiscount;
        line_total = floatDiscountCost * floatQuantity;

        $('#prod_discount_cost_line_' + i)
            .val(floatDiscountCost.toFixed(2));
        $('#line_total_line_' + i).val(line_total.toFixed(2));

        net_invoice_value += line_total;
    }
		net_invoice_value += parseFloat($('#shipping_value').val());

        var netValueEle = $('#net_value');
        netValueEle.val(net_invoice_value.toFixed(2));
        var vat = net_invoice_value * (vat_rate / 100);
        var vatValueEle = $('#vat_value');
        vatValueEle.val(vat.toFixed(2));
		var total = parseFloat(netValueEle.val()) + parseFloat(vatValueEle.val());
		$('#total_value').val(total.toFixed(2));
}

function order_lines(line) {

	// find next line. Rename to deleted line. repeat for all remaining lines.
	for ( var i = parseInt(line); i < (line_number + 1); i++) {
		next_line = i + 1;

		document.getElementById('invoice_line_' + next_line).id = 'invoice_line_' + i;
		document.getElementById('line_' + next_line).id = 'line_' + i;
		document.getElementById('line_' + i).value = i;
		document.getElementById('select_product_' + next_line).id = 'select_product_' + i;
		document.getElementById('prod_description_line_' + next_line).id = 'prod_description_line_' + i;
		document.getElementById('prod_retail_cost_line_' + next_line).id = 'prod_retail_cost_line_' + i;
		document.getElementById('prod_discount_cost_line_' + next_line).id = 'prod_discount_cost_line_' + i;
		document.getElementById('quantity_line_' + next_line).id = 'quantity_line_' + i;
		document.getElementById('discount_line_' + next_line).id = 'discount_line_' + i;
		document.getElementById('line_total_line_' + next_line).id = 'line_total_line_' + i;
		document.getElementById('del_link_' + next_line).id = 'del_link_' + i;
	}
}

function delete_line(line) {
	if(line_number != 1 && line > 0){
		var elem_to_delete = document.getElementById('invoice_line_' + line);
		elem_to_delete.parentNode.removeChild(elem_to_delete);
		line_number--;
		document.getElementById('numb_layout_lines').value = line_number;
		order_lines(line);
		calculateDocument();
	}
}

function getLineNumber(line_item_id){
    var regex = /^\D*(\d+)/;
    var result_array = regex.exec(line_item_id);
	if(result_array.length > 1){
		return result_array[1];
	} else {
		return 0;
	}
}

function create_line() {

	var tempstring = "";
	var elem = document.createElement('div');
	line_number++;

	$("#numb_layout_lines").val(line_number);
	var new_elem_name = 'invoice_line_' + line_number;
	elem.setAttribute('id', new_elem_name);
	tempstring += "<table><tr>";
	tempstring += "<td class='document_line_col'><input name='line_"
			+ line_number + "' id='line_" + line_number
			+ "' type='text' value='" + line_number
			+ "' size='1' readonly></td>\n";
	tempstring += "<td class='document_product_code_col'><select name='select_product_"
			+ line_number + "' id='select_product_" + line_number + "'>";
	tempstring += "<option value='none'>Please select</option>";
	tempstring += "</select></td>\n";
	tempstring += "<td class='document_description_col'><input name='prod_description_line_"
			+ line_number
			+ "' id='prod_description_line_"
			+ line_number
			+ "' size='50' type='text'></td>\n";
		tempstring += "<td class='document_unit_cost_col'><input name='prod_retail_cost_line_"
				+ line_number
				+ "' id='prod_retail_cost_line_"
				+ line_number
				+ "' type='text' value='0' size='8'><input name='prod_discount_cost_line_"
				+ line_number
				+ "' id='prod_discount_cost_line_"
				+ line_number
				+ "' type='hidden' value='0'></td>\n";
	tempstring += "<td class='document_quantity_col'><input name='quantity_line_"
			+ line_number
			+ "' id='quantity_line_"
			+ line_number
			+ "' type='text' value='1' size='4'></td>\n";
		tempstring += "<td class='document_discount_col'><input name='discount_line_"
				+ line_number
				+ "' id='discount_line_"
				+ line_number
				+ "' type='text' value='0' size='1'></td>\n";
		tempstring += "<td class='document_line_total_col'><input name='line_total_line_"
				+ line_number
				+ "' id='line_total_line_"
				+ line_number
				+ "' type='text' size='8' readonly></td>\n";
	tempstring += "<td class='document_action_col'><button id='del_button_"
			+ line_number
			+ "' type='button' onclick='delete_line(getLineNumber(this.id));return false;'>Del</button></td>\n";
	tempstring += "</tr></table>";
	elem.innerHTML = tempstring;

	$("#line_placeholder").append(elem);
	$("#select_product_" + line_number).change(function() {
		getProduct(line_number);
	});
	$("#prod_retail_cost_line_" + line_number).change(function() {
		calculateDocument();
	});
	$("#discount_line_" + line_number).change(function() {
		calculateDocument();
	});
	$("#quantity_line_" + line_number).change(function() {
		calculateDocument();
	});
	getProductList(line_number);
}

function validate() {

	/*
	 * var validChars = "0123456789";
	 * 
	 * for( var i=0; i < document.getElementById('invoice_number').value.length;
	 * i++ ) { if
	 * (validChars.indexOf(document.getElementById('invoice_number').value.charAt(i)) ==
	 * -1 ) { alert( "Only numbers are valid for Invoice Number." );
	 * document.getElementById('invoice_number').focus(); return false; } }
	 */

	if ($('#client_ref').val() == "") {
		if (!confirm("Are you sure you would like to leave the customer reference blank?")) {
			return false;
		}
	}

	if ($('#contact').val() == "none") {
		alert("Please select a recipient.");
		return false;
	}
	return true;
}
