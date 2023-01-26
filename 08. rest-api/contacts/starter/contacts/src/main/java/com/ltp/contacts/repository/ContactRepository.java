package com.ltp.contacts.repository;

import com.ltp.contacts.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) {
        contacts.set(index, contact);
    }

    // Implementation 1 by accessing the ArrayList manually
    public void updateContactWithoutId(int index, Contact contact) {
        Contact currentContact = contacts.get(index);
        currentContact.setName(contact.getName());
        currentContact.setPhoneNumber(contact.getPhoneNumber());
        contacts.set(index, currentContact);
    }

    // Implementation 2 by using Java stream API
    public void updateContactWithoutId(String id, Contact contact) {
        contacts.stream().
                filter(current -> Objects.equals(current.getId(), id))
                .peek(current -> {current.setName(contact.getName()); current.setPhoneNumber(contact.getPhoneNumber());})
                .forEach(current -> contacts.set(contacts.indexOf(current), current));
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
