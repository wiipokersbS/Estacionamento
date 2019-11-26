package com.example.estacionamento.Estacionamento;

public class TabelaHorario {

    String horarioFuncionamento;
    int id;

    public TabelaHorario() {
    }

    public TabelaHorario(String horarioFuncionamento, int id) {
        this.horarioFuncionamento = horarioFuncionamento;
        this.id = id;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
