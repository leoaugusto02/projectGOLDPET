package com.example.goldpet.model.vo;

import java.util.Date;

public class Pessoa {

    private Integer codePerson;
    private String apelido, p_nome, s_nome, tipo, senha, email, cep, cpf, rg, genero, referencia, imgPerfil, tel1, tel2;
    private Date nascimento;
    private Guardiao guardiao;
    private Funcionario funcionario;

    public Pessoa(){super();}

    public Pessoa(Integer codePerson, String apelido, String p_nome, String s_nome, String tipo, String senha,
                  String email, String cep, String cpf, String rg, String genero, String referencia, String imgPerfil,
                  String tel1, String tel2, Date nascimento, Guardiao guardiao, Funcionario funcionario) {
        super();
        this.codePerson = codePerson;
        this.apelido = apelido;
        this.p_nome = p_nome;
        this.s_nome = s_nome;
        this.tipo = tipo;
        this.senha = senha;
        this.email = email;
        this.cep = cep;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.referencia = referencia;
        this.imgPerfil = imgPerfil;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.nascimento = nascimento;
        this.guardiao = guardiao;
        this.funcionario = funcionario;
    }

    public Integer getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(Integer codePerson) {
        this.codePerson = codePerson;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getP_nome() {
        return p_nome;
    }

    public void setP_nome(String p_nome) {
        this.p_nome = p_nome;
    }

    public String getS_nome() {
        return s_nome;
    }

    public void setS_nome(String s_nome) {
        this.s_nome = s_nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Guardiao getGuardiao() {
        return guardiao;
    }

    public void setGuardiao(Guardiao guardiao) {
        this.guardiao = guardiao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
