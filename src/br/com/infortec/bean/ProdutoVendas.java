/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Israelly
 */
public class ProdutoVendas {
    
    Produto produto;
    ItensVendas itensVendas;

    public ProdutoVendas() {
    }

    public ProdutoVendas(Produto produto, ItensVendas itensVendas) {
        this.produto = produto;
        this.itensVendas = itensVendas;
    }

    public ItensVendas getItensVendas() {
        return itensVendas;
    }

    public void setItensVendas(ItensVendas itensVendas) {
        this.itensVendas = itensVendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   

    
}
