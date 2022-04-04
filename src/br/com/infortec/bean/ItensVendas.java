/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Israelly
 */
public class ItensVendas {
    
    int cod;
    double qtde;
    double valorUni;
    double vlrTotal;
    Vendas vendas;
    Produto produto;

    public ItensVendas() {
    }

    public ItensVendas(int cod, double rqtde, double valorUni, double vlrTotal, Vendas vendas, Produto produto) {
        this.cod = cod;
        this.qtde = rqtde;
        this.valorUni = valorUni;
        this.vlrTotal = vlrTotal;
        this.vendas = vendas;
        this.produto = produto;
    }

    public ItensVendas(double rqtde, double valorUni, double vlrTotal, Vendas vendas, Produto produto) {
        this.qtde = rqtde;
        this.valorUni = valorUni;
        this.vlrTotal = vlrTotal;
        this.vendas = vendas;
        this.produto = produto;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getRqtde() {
        return qtde;
    }

    public void setRqtde(double rqtde) {
        this.qtde = rqtde;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

}
