package com.fatec.fomeless.entities;

import com.fatec.fomeless.tests.DocumentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocumentTest {

    private static String validCPF;
    private static String validCNPJ;
    private static Document docMock;
    private static boolean legalPerson;
    private static Long id;

    @BeforeEach
    void setUp() {
        id = 1L;
        validCPF = "123.456.789-98";
        validCNPJ = "23.075.868/0001-56";
        legalPerson = true;
    }

    @Test
    public void constructorShouldCreateObjectWhenCPFMatchesRegex() {
        Assertions.assertDoesNotThrow(() -> {
            docMock = DocumentFactory.createValidCPF();

            Assertions.assertEquals(id, docMock.getId());
            Assertions.assertEquals(validCPF, docMock.getDocNumber());
            Assertions.assertNotEquals(legalPerson, docMock.isLegalPerson());
        });
    }

    @Test
    public void constructorShouldCreateObjectWhenCNPJMatchesRegex() {
        Assertions.assertDoesNotThrow(() -> {
            docMock = DocumentFactory.createValidCNPJ();

            Assertions.assertEquals(id, docMock.getId());
            Assertions.assertEquals(validCNPJ, docMock.getDocNumber());
            Assertions.assertEquals(legalPerson, docMock.isLegalPerson());
        });

    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenCPFDoesNotMatchRegex() {
        Assertions.assertThrows(IllegalArgumentException.class, DocumentFactory::createInvalidCPF);
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenCNPJDoesNotMatchRegex() {
        Assertions.assertThrows(IllegalArgumentException.class, DocumentFactory::createInvalidCNPJ);
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenCPFOrCNPJIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, DocumentFactory::createEmptyDocument);
    }
}
