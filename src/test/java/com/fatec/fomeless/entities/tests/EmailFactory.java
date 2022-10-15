package com.fatec.fomeless.entities.tests;

import com.fatec.fomeless.entities.Email;

public class EmailFactory {

    public static Email createValidEmail() {
        return new Email(1L, "john@gmail.com");
    }

    public static Email createInvalidEmail() {
        return new Email(1L, "john$$@gmail.com");
    }

    public static Email createEmail(String email) {
        return new Email(1L, email);
    }
}
