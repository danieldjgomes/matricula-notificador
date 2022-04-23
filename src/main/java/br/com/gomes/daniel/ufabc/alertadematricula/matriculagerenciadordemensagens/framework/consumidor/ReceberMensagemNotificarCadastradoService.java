package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.consumidor;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.Mensagem;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.mensagens.ReceberMensagemNotificarCadastrado;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.servicos.EnviarNotificacaoUsuariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceberMensagemNotificarCadastradoService {

    @Autowired
    private EnviarNotificacaoUsuariosService enviarNotificacaoUsuarios;

    @RabbitListener(queues = "${mensageria.rabbit.filas.notificarCadastrados}")
    public void receber(NotificarCadastrado notificarCadastrado) {
        log.info("Enviado para " + notificarCadastrado.getDestinatario());
        enviarNotificacaoUsuarios.enviar(notificarCadastrado);
    }

}
