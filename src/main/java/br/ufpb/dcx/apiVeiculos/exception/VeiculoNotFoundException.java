package br.ufpb.dcx.apiVeiculos.exception;

public class VeiculoNotFoundException extends RuntimeException {
    public VeiculoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
