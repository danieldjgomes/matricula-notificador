package br.com.gomes.daniel.ufabc.alertadematricula.matriculagerenciadordemensagens.app.dominio;

public class Mensagem<M> {

    M conteudo;
    String fila;

    public Mensagem(M conteudo, String fila) {
        this.conteudo = conteudo;
        this.fila = fila;
    }

    public M getConteudo(){
        return this.conteudo;
    }

    public Mensagem() {
    }

    public String getFila() {
        return fila;
    }
}
