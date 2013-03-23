package uk.ltd.crossfire.companymanager.server.dao;

import uk.ltd.crossfire.companymanager.shared.entities.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> getContacts();

    Contact getContact(int id);

}
