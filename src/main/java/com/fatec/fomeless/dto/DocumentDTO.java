package com.fatec.fomeless.dto;

import com.fatec.fomeless.entities.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DocumentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String docNumber;
    private boolean legalPerson;

    public DocumentDTO(Document document) {
        id = document.getId();
        docNumber = document.getDocNumber();
        legalPerson = document.isLegalPerson();
    }
}
