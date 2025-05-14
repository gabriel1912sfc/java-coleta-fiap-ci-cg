package br.com.fiap.coleta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ColetaNotFoundException extends RuntimeException {
    public ColetaNotFoundException(String message) {
        super(message);
    }
}
