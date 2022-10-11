package com.fatec.fomeless.entities;

public class Document {

    private String number;

    public Document(String number) {
        if (validateCpf(number)) {
            this.number = number;
        }
    }

    private boolean validateCpf(String number) {
        var regex = "(^(\\d{3}\\.?){3}-?\\d{2}$)";

        if (number.matches(regex)) {
            return true;
        }

        throw new IllegalArgumentException("Invalid number: " + number);
    }

    public static void main(String[] args) {
        Document doc = new Document("12345698711");
        System.out.println(doc.number);
    }

}
