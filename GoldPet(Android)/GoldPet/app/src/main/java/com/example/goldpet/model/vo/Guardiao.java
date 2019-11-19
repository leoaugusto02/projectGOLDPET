package com.example.goldpet.model.vo;

public class Guardiao {
    private Integer codeGuard, animasResgatados, progresso;
    private String rank, status;

    public Guardiao() {
        super();
    }

    public Guardiao(Integer codeGuard, Integer animasResgatados, Integer progresso, String rank, String status) {
        super();
        this.codeGuard = codeGuard;
        this.animasResgatados = animasResgatados;
        this.progresso = progresso;
        this.rank = rank;
        this.status = status;
    }

    public Integer getCodeGuard() {
        return codeGuard;
    }

    public void setCodeGuard(Integer codeGuard) {
        this.codeGuard = codeGuard;
    }

    public Integer getAnimasResgatados() {
        return animasResgatados;
    }

    public void setAnimasResgatados(Integer animasResgatados) {
        this.animasResgatados = animasResgatados;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
