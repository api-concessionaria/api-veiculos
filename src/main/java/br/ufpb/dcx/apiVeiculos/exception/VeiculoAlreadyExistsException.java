package br.ufpb.dcx.apiVeiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) // 409
public class VeiculoAlreadyExistsException extends RuntimeException {
    public VeiculoAlreadyExistsException(String message) {
        super(message);
    }
}
