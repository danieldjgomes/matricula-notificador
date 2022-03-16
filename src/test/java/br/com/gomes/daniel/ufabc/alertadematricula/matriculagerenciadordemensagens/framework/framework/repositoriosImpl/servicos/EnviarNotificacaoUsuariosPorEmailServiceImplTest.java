package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.framework.repositoriosImpl.servicos;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio.NotificarCadastrado;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.repositorios.servicos.EnviarNotificacaoUsuariosService;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.domain.dominio.Disciplina;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.framework.framework.repositoriosImpl.servicos.Email.EmailBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class EnviarNotificacaoUsuariosPorEmailServiceImplTest {



    @Test
    void enviarTest() {
        String email = "daniel.djgomes@outlook.com";
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Bioquímica: Estrutura, Propriedade e Funções de Biomoléculas B1-Matutino (Santo André)");
        NotificarCadastrado notificarCadastrado = new NotificarCadastrado(email,disciplina);
        EnviarNotificacaoUsuariosPorEmailServiceImpl enviarNotificacaoUsuariosPorEmailService = new EnviarNotificacaoUsuariosPorEmailServiceImpl();
        enviarNotificacaoUsuariosPorEmailService.enviar(notificarCadastrado);
    }
}