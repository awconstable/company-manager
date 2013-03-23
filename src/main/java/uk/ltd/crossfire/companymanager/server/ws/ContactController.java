package uk.ltd.crossfire.companymanager.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.ltd.crossfire.companymanager.server.service.ContactService;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;

import java.util.List;

@RequestMapping(value = "/contacts")
@Controller
public class ContactController {

    private final Logger log = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Contact> getContacts() {

        List<Contact> contacts = contactService.getContacts();

        if(contacts != null){
            log.debug("Contacts : {}", contacts);
        }

        return contacts;
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Contact getContact(@PathVariable int id) {

        Contact contact = contactService.getContact(id);

        if(contact != null){
            log.debug("Contact : {}", contact);
        }

        return contact;
    }

}
