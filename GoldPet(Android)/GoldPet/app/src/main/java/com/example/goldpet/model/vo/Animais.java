package com.example.goldpet.model.vo;

public class Animais {
    private String nome;
    private Integer codAnimal;
    private String especie;
    private String raca;
    private String porte;
    private Integer idade;
    private String status;
    private String sexo;
    private Laudo laudo;
    private String imgAnimal;
    private Pessoa pessoa;
    private Agenda agenda;

    public Animais() {
        super();
    }

    public Animais(String nome, Integer codAnimal, String especie, String raca, String porte, Integer idade,
                   String status, String sexo, Laudo laudo, String imgAnimal, Pessoa pessoa, Agenda agenda) {
        super();
        this.nome = nome;
        this.codAnimal = codAnimal;
        this.especie = especie;
        this.raca = raca;
        this.porte = porte;
        this.idade = idade;
        this.status = status;
        this.sexo = sexo;
        this.laudo = laudo;
        this.imgAnimal = imgAnimal;
        this.pessoa = pessoa;
        this.agenda = agenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(Integer codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    public String getImgAnimal() {
        return imgAnimal;
    }

    public void setImgAnimal(String imgAnimal) {
        this.imgAnimal = imgAnimal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
