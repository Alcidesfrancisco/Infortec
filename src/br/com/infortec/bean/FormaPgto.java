/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Infortec
 */
public class FormaPgto {
    
    int codFormaPgto;
    String nome;
    String descricao;
    int numParcelas;
    double taxa;

    public FormaPgto() {
    }

    public FormaPgto(String nome, String descricao, int numParcelas, double taxa) {
        this.nome = nome;
        this.descricao = descricao;
        this.numParcelas = numParcelas;
        this.taxa = taxa;
    }

    public FormaPgto(int codFormaPgto, String nome, String descricao, int numParcelas, double taxa) {
        this.codFormaPgto = codFormaPgto;
        this.nome = nome;
        this.descricao = descricao;
        this.numParcelas = numParcelas;
        this.taxa = taxa;
    }

    public int getCodFormaPgto() {
        return codFormaPgto;
    }

    public void setCodFormaPgto(int codFormaPgto) {
        this.codFormaPgto = codFormaPgto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
      
}
