package com.ltp.contacts.repository;

import com.ltp.contacts.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ContactRepository {
    
    private List<Contact> contacts = Arrays.asList(
            new Contact("123", "John Doe", "123123"),
            new Contact("456", "Jane Doe", "456456"),
            new Contact("789", "Bob Ross", "789789")
    );

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
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
