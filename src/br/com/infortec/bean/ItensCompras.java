/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Israelly
 */
public class ItensCompras {
    
    int cod;
    Produto produto;
    double qtde;
    double vlrUnit;
    double vlrTotal;
    Compras compras;

    public ItensCompras() {
    }

    public ItensCompras(Produto produto, double qtde, double vlrUnit, double vlrTotal, Compras compras) {
        this.produto = produto;
        this.qtde = qtde;
        this.vlrUnit = vlrUnit;
        this.vlrTotal = vlrTotal;
        this.compras = compras;
    }

    public ItensCompras(int cod, Produto produto, double qtde, double vlrUnit, double vlrTotal, Compras compras) {
        this.cod = cod;
        this.produto = produto;
        this.qtde = qtde;
        this.vlrUnit = vlrUnit;
        this.vlrTotal = vlrTotal;
        this.compras = compras;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public double getVlrUnit() {
        return vlrUnit;
    }

    public void setVlrUnit(double vlrUnit) {
        this.vlrUnit = vlrUnit;
    }
}
