package com.example.goldpet.model.vo;

public class Funcionario {
    private Integer codeFunc;
    private String cargo, status;

    public Funcionario() {
        super();
    }

    public Funcionario(Integer codeFunc, String cargo, String status) {
        super();
        this.codeFunc = codeFunc;
        this.cargo = cargo;
        this.status = status;
    }

    public Integer getCodeFunc() {
        return codeFunc;
    }

    public void setCodeFunc(Integer codeFunc) {
        this.codeFunc = codeFunc;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
