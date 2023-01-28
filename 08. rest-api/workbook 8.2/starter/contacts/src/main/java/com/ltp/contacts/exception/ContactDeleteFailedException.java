package com.ltp.contacts.exception;

public class ContactDeleteFailedException extends RuntimeException {
    public ContactDeleteFailedException(String id) {
        super("Updated failed on id '" + id + "' since it cannot be found.");
    }
}
