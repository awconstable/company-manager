package uk.ltd.crossfire.companymanager.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ltd.crossfire.companymanager.server.dao.ContactDao;
import uk.ltd.crossfire.companymanager.shared.entities.Contact;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> getContacts() {
        return contactDao.getContacts();
    }

    @Override
    public Contact getContact(int id) {
        return contactDao.getContact(id);
    }
}
