package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.framework.repositoriosImpl.servicos.Email;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.dominio.DAO.ArquivoNaoEncontradoException;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Slf4j
@Service
public class EmailBuilder {

    private static final String senderEmail = System.getProperty("emailSend");
    private static final String senderPassword = System.getProperty("senhaSend");
    private static final String hostname = System.getProperty("smtp");

    private static final String TITULO_REMETENTE = "UFABC Track";
    private static final String ASSUNTO_EMAIL = "UFABC Track: Disciplina Liberada!";

    public static void enviarViaHtml(NotificarCadastrado notificarCadastrado) throws MessagingException, UnsupportedEncodingException {
        Session session = createSession();
        MimeMessage message = new MimeMessage(session);
        prepareEmailMessage(message, notificarCadastrado.getDestinatario(), getHtml(notificarCadastrado));
        Transport.send(message);
    }

    private static void prepareEmailMessage(MimeMessage message, String to, String html)
            throws MessagingException, UnsupportedEncodingException {
        message.setContent(html, "text/html; charset=utf-8");
        message.setFrom(new InternetAddress(senderEmail, TITULO_REMETENTE));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(ASSUNTO_EMAIL);
    }

    private static Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", hostname);
        props.put("mail.smtp.port", "587");

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
    }

    private static String getHtml(NotificarCadastrado notificarCadastrado) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/email/index.html");
        } catch (FileNotFoundException e) {
            throw new ArquivoNaoEncontradoException("O modelo HTML do e-mail não foi encontrado");
        }
        String htmlPagina = IOUtils.toString(fis);
        htmlPagina = htmlPagina
                .replace("*[UrlCancelamento]*", notificarCadastrado.getDisciplina().getIdentificadorUFABC())
                .replace("*[NomeDisciplina]*", notificarCadastrado.getDisciplina().getNome());
        return htmlPagina;
    }

}
