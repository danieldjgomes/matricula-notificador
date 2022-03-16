package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.domain.dominio;

public class Alerta {

    String idDisciplina;
    Email email;
    Status status;


    public Alerta() {
    }

    public Alerta(String idDisciplina, Email email, Status status) {
        this.idDisciplina = idDisciplina;
        this.email = email;
        this.status = status;
    }
    public Email getEmail() {
        return email;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
