package com.example.estacionamento.Array;

import com.google.gson.annotations.SerializedName;

public class Estacionamento {

    @SerializedName("nomeFantasia")
    private String nomeFantasia;
    @SerializedName("razaoSocial")
    private String razaoSocial;
    @SerializedName("cnpj")
    private String cnpj;
    @SerializedName("cep")
    private String cep;
    @SerializedName("numero")
    private int numero;
    @SerializedName("bairro")
    private String bairro;
    @SerializedName("estado")
    private String estado;
    @SerializedName("cidade")
    private String cidade;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
