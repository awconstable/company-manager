package uk.ltd.crossfire.companymanager.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ltd.crossfire.companymanager.server.service.InvoiceService;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;

import java.util.List;

@RequestMapping(value = "/invoices")
@Controller
public class InvoiceController {

    private final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Invoice> getInvoices() {

        List<Invoice> invoices = invoiceService.getInvoices();

        if(invoices != null){
            log.debug("Invoices : {}", invoices);
        }

        return invoices;
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Invoice getInvoice(@PathVariable int id) {

        Invoice invoice = invoiceService.getInvoice(id);

        if(invoice != null){
            log.debug("Invoice : {}", invoice);
        }

        return invoice;
    }

}
