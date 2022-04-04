/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

import java.sql.Date;


/**
 *
 * @author Infortec
 */
public class Estoque {
    Produto produto;
    String tipo;
    String data;
    double quantidade;
    Unidade unidade;
    double TotalItens;

    public Estoque() {
    }

    public Estoque(Produto produto, double TotalItens) {
        this.produto = produto;
        this.TotalItens = TotalItens;
    }

    public Estoque(Produto produto, String tipo, String data, double quantidade, Unidade unidade, double TotalItens) {
        this.produto = produto;
        this.tipo = tipo;
        this.data = data;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.TotalItens = TotalItens;
    }

    public Estoque(String tipo, String data, double quantidade, Unidade unidade, double TotalItens) {
        this.tipo = tipo;
        this.data = data;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.TotalItens = TotalItens;
    }

    public double getTotalItens() {
        return TotalItens;
    }

    public void setTotalItens(double TotalItens) {
        this.TotalItens = TotalItens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

}
