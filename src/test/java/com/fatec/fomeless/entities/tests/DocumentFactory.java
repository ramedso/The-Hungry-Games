package com.fatec.fomeless.entities.tests;

import com.fatec.fomeless.entities.Document;

public class DocumentFactory {

    public static void createEmptyDocument(){
        new Document(1L, "", true);
    }

    public static Document createValidCPF() {
        return new Document(1L, "123.456.789-98", false);
    }

    public static Document createValidCNPJ() {
        return new Document(1L, "23.075.868/0001-56", true);
    }

    public static void createInvalidCPF() {
        new Document(1L, "222.222.222-2", true);
    }

    public static void createInvalidCNPJ() {
        new Document(1L, "23.075.8/0001-56", false);
    }
}
