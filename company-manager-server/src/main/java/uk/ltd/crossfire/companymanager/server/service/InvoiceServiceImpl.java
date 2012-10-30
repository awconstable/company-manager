package uk.ltd.crossfire.companymanager.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.ltd.crossfire.companymanager.common.domain.Invoice;
import uk.ltd.crossfire.companymanager.server.persistence.InvoiceMapper;
import uk.ltd.crossfire.companymanager.server.requests.InvoiceMapperRequest;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper dao;

	@Override
	public Invoice getInvoice(int id) {
		return dao.getInvoice(id);
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
