package uk.ltd.crossfire.companymanager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.crossfire.companymanager.server.dao.ContactDao;
import uk.ltd.crossfire.companymanager.server.dao.VatRateDao;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;
import uk.ltd.crossfire.companymanager.shared.entities.VatRate;

import java.util.List;

@Service
public class VatRateServiceImpl implements VatRateService {

    @Autowired
    private VatRateDao vatRateDao;

    @Override
    public List<VatRate> getVatRates() {
        return vatRateDao.getVatRates();
    }

}
