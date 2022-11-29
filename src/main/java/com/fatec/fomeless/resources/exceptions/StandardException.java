package com.fatec.fomeless.resources.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class StandardException {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
