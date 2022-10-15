package com.fatec.fomeless.entities;

import com.fatec.fomeless.tests.EmailFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {

    private static String validEmail;
    private static Email emailMock;
    private static Long id;

    @BeforeEach
    void setUp() {
        id = 1L;
        validEmail = "john@gmail.com";
    }

    @Test
    public void constructorShouldCreateObjectWhenEmailMatchesRegex() {
        Assertions.assertDoesNotThrow(() -> {
            emailMock = EmailFactory.createValidEmail();

            Assertions.assertEquals(id, emailMock.getId());
            Assertions.assertEquals(validEmail, emailMock.getEmailAddress());
        });

    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenEmailDoesNotMatchRegex(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            emailMock = EmailFactory.createInvalidEmail();
            emailMock.regexValidation(emailMock.getEmailAddress());
        });
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenEmailHasEmptySpaces(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            emailMock = EmailFactory.createEmail("john    @gmail.com");
            emailMock.emptyOrBlankSpaces(emailMock.getEmailAddress());
        });
    }
}
