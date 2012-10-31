package uk.ltd.crossfire.companymanager.server.ws;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.ltd.crossfire.companymanager.shared.entities.CompanyConfig;
import uk.ltd.crossfire.companymanager.server.service.CompanyConfigService;

@Controller
public class CompanyConfigController {

	private final Logger log = LoggerFactory.getLogger(CompanyConfigController.class);

	@Autowired
	CompanyConfigService configService;

	@RequestMapping(value = "/config/")
	public @ResponseBody List<CompanyConfig> getAllOptions() {
		List<CompanyConfig> options = configService.getOptions();

		if(options != null){
			log.debug("Options : {}", options);
		}

		return options;
	}

	@RequestMapping(value = "/hello")
	public ModelAndView sayHello() {

		List<String> paragraphs = new ArrayList<String>();

		paragraphs.add("hello from the controller 1");
		paragraphs.add("hello from the controller 2");
		paragraphs.add("hello from the controller 3");
		paragraphs.add("hello from the controller 4");
		paragraphs.add("hello from the controller 5");

		return new ModelAndView("pdfContent", "content", paragraphs);
	}
}
