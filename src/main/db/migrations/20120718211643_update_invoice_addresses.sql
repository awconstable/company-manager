
update invoices inv, contacts con set inv.account_ref = con.account_ref, inv.company_name = con.company_name, inv.address_1 = con.address_1, inv.address_2 = con.address_2, inv.city = con.city, inv.postcode = con.postcode, inv.country = con.country, inv.vat_number = con.vat_number 
where con.id = inv.contact_id;

commit;
