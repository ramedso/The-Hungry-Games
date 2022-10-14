package com.fatec.fomeless.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_document")
public class Document implements FieldsValidation, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static final String CONST_CPF_REGEX = "(^(\\d{3}\\.?){3}-?\\d{2}$)";
    private static final String CONST_CNPJ_REGEX = "\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2}";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String docNumber;
    private boolean legalPerson;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Document(Long id, String docNumber, boolean legalPerson) {
        emptyOrBlankSpaces(docNumber);
        regexValidation(docNumber);
        this.id = id;
        this.docNumber = docNumber.trim();
        this.legalPerson = legalPerson;
    }

    @Override
    public void regexValidation(String docNumber) {
        if (!docNumber.matches(CONST_CNPJ_REGEX) || !docNumber.matches(CONST_CPF_REGEX)) {
            throw new IllegalArgumentException("Invalid CPF/CNPJ: " + docNumber);
        }
    }

    @Override
    public void emptyOrBlankSpaces(String docNumber) {
        if (docNumber.isEmpty() || docNumber.isBlank()) {
            throw new IllegalArgumentException("There are blank spaces");
        }
    }
}
