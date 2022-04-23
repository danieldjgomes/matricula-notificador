package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.servicos;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;

public interface EnviarNotificacaoUsuariosService extends Service{

    public void enviar(NotificarCadastrado notificarCadastrado);

}
