package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.domain.dominio.excessoes;

public class EmailInvalidoException extends DadosInvalidosException {
    public EmailInvalidoException() {
        super("Um email invalido foi inserido.");
    }
}
