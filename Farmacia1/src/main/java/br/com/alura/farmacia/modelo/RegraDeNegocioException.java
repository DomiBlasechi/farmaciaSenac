package br.com.alura.farmacia.modelo;

public class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException (String mensagem) {
        super(mensagem);
    }
}
