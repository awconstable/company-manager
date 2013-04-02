package uk.ltd.crossfire.companymanager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.crossfire.companymanager.server.dao.InvoiceDao;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;
import uk.ltd.crossfire.companymanager.shared.entities.Invoice;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao dao;

	@Override
	public Invoice getInvoice(int id) {
		return dao.getInvoice(id);
	}

    @Override
    public List<Invoice> getInvoices() {
        return dao.getInvoices();
    }

    @Override
	public List<Invoice> getInvoices(int start, int length) {
		return dao.getInvoices(new InvoiceMapperRequest(start, length));
    }

	@Override
	public Integer getInvoiceCount() {
		return dao.getInvoiceCount();
	}

}
