package com.example.goldpet.model.vo;

public class Perguntas {

    private Integer codPerg;
    private String pergunta, descricao, tema;
    private Respostas respostas;
    private Pessoa pessoa;

    public Perguntas() {}

    public Perguntas(Integer codPerg, String pergunta, String descricao, String tema, Respostas respostas, Pessoa pessoa) {
        super();
        this.codPerg = codPerg;
        this.pergunta = pergunta;
        this.descricao = descricao;
        this.tema = tema;
        this.respostas = respostas;
        this.pessoa = pessoa;
    }

    public Integer getCodPerg() {
        return codPerg;
    }

    public void setCodPerg(Integer codPerg) {
        this.codPerg = codPerg;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Respostas getRespostas() {
        return respostas;
    }

    public void setRespostas(Respostas respostas) {
        this.respostas = respostas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
