package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.excessoes;

public class InfraestruturaException extends RuntimeException {

    public InfraestruturaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
