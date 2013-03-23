package uk.ltd.crossfire.companymanager.server.dao;

import uk.ltd.crossfire.companymanager.shared.entities.VatRate;

import java.util.List;

public interface VatRateDao {

    List<VatRate> getVatRates();

}
