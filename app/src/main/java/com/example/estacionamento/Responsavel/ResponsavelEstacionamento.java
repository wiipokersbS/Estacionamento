package com.example.estacionamento.Responsavel;

public class ResponsavelEstacionamento {
    String Nome;
    String Telefone;
    int id;

    public ResponsavelEstacionamento() {
    }

    public ResponsavelEstacionamento(String nome, String telefone, int id) {
        Nome = nome;
        Telefone = telefone;
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
