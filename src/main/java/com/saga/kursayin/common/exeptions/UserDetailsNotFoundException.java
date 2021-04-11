package com.saga.kursayin.common.exeptions;

public class UserDetailsNotFoundException extends RuntimeException {

    public UserDetailsNotFoundException(Long id) {
        super(String.format("User details with id %s not found",id));
    }
}
