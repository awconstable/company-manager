package uk.ltd.crossfire.companymanager.server.service;

import uk.ltd.crossfire.companymanager.shared.entities.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContacts();

    public Contact getContact(int id);

}
