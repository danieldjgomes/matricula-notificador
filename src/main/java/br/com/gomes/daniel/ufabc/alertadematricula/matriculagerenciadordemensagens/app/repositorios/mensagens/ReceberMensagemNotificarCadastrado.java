package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.mensagens;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.AlteracaoVaga;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.Mensagem;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;

public interface ReceberMensagemNotificarCadastrado extends ReceberMensagem<Mensagem<NotificarCadastrado>> {

    public void receber(NotificarCadastrado alteracaoVaga);
}
