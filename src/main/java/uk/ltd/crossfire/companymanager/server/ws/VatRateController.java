package uk.ltd.crossfire.companymanager.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ltd.crossfire.companymanager.server.service.VatRateService;
import uk.ltd.crossfire.companymanager.shared.entities.VatRate;

import java.util.List;

@RequestMapping(value = "/vat")
@Controller
public class VatRateController {

    private final Logger log = LoggerFactory.getLogger(VatRateController.class);

    @Autowired
    VatRateService vatRateService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<VatRate> getVatRates() {

        List<VatRate> vatRates = vatRateService.getVatRates();

        if(vatRates != null){
            log.debug("VAT Rate : {}", vatRates);
        }

        return vatRates;
    }

}
