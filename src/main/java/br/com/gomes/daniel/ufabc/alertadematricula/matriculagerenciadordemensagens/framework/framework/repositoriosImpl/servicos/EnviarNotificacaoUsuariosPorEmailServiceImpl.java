package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.framework.repositoriosImpl.servicos;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.servicos.EnviarNotificacaoUsuariosService;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.framework.repositoriosImpl.servicos.Email.EmailBuilder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class EnviarNotificacaoUsuariosPorEmailServiceImpl implements EnviarNotificacaoUsuariosService {

    @Override
    public void enviar(NotificarCadastrado notificarCadastrado) {
        try {
            EmailBuilder.enviarViaHtml(notificarCadastrado);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
