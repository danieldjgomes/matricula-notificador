package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.dominio.DAO;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.excessoes.InfraestruturaException;

public class ArquivoNaoEncontradoException extends InfraestruturaException {

    public ArquivoNaoEncontradoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
