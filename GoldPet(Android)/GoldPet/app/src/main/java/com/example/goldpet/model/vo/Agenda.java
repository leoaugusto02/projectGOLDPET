package com.example.goldpet.model.vo;

import java.util.Date;

public class Agenda {

    private Integer codeAgenda, codePerson, codeAnimal;
    private String adotado, transportado, confirmar;
    private Date data_adocao, horario_adocao, horario_marcado;
    private Pessoa codPessoa;
    private Perguntas codPergunta;

    public Agenda() {}

    public Agenda(Integer codeAgenda, Integer codePerson, Integer codeAnimal, String adotado, String transportado,
                  String confirmar, Date data_adocao, Date horario_adocao, Date horario_marcado, Pessoa codPessoa,
                  Perguntas codPergunta) {
        super();
        this.codeAgenda = codeAgenda;
        this.codePerson = codePerson;
        this.codeAnimal = codeAnimal;
        this.adotado = adotado;
        this.transportado = transportado;
        this.confirmar = confirmar;
        this.data_adocao = data_adocao;
        this.horario_adocao = horario_adocao;
        this.horario_marcado = horario_marcado;
        this.codPessoa = codPessoa;
        this.codPergunta = codPergunta;
    }

    public Integer getCodeAgenda() {
        return codeAgenda;
    }
    public void setCodeAgenda(Integer codeAgenda) {
        this.codeAgenda = codeAgenda;
    }
    public Integer getCodePerson() {
        return codePerson;
    }
    public void setCodePerson(Integer codePerson) {
        this.codePerson = codePerson;
    }
    public Integer getCodeAnimal() {
        return codeAnimal;
    }
    public void setCodeAnimal(Integer codeAnimal) {
        this.codeAnimal = codeAnimal;
    }
    public String getAdotado() {
        return adotado;
    }
    public void setAdotado(String adotado) {
        this.adotado = adotado;
    }
    public String getTransportado() {
        return transportado;
    }
    public void setTransportado(String transportado) {
        this.transportado = transportado;
    }
    public Date getData_adocao() {
        return data_adocao;
    }
    public void setData_adocao(Date data_adocao) {
        this.data_adocao = data_adocao;
    }
    public Date getHorario_adocao() {
        return horario_adocao;
    }
    public void setHorario_adocao(Date horario_adocao) {
        this.horario_adocao = horario_adocao;
    }
    public Pessoa getCodPessoa() {
        return codPessoa;
    }
    public void setCodPessoa(Pessoa codPessoa) {
        this.codPessoa = codPessoa;
    }
    public Perguntas getCodPergunta() {
        return codPergunta;
    }
    public void setCodPergunta(Perguntas codPergunta) {
        this.codPergunta = codPergunta;
    }

    public String getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    public Date getHorario_marcado() {
        return horario_marcado;
    }

    public void setHorario_marcado(Date horario_marcado) {
        this.horario_marcado = horario_marcado;
    }
}
