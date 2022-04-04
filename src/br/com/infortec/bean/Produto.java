/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Infortec
 */
public class Produto {
    int codProduto;
    String nome;
    String descricao;
    Double valorCompra;
    Double valorVenda;
    Double estoque;
    String localizacao;
    Fornecedor fornecedor;
    CategoriaProduto categoria;
    double margemLucro;
    double lucroliquido;

    public Produto() {
    }

    public Produto(String nome, String descricao, Double valorCompra, Double valorVenda, Double estoque, String localizacao, Fornecedor fornecedor, CategoriaProduto categoria, double margemLucro) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.estoque = estoque;
        this.localizacao = localizacao;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.margemLucro = margemLucro;
    }

    public Produto(int codProduto, String nome, String descricao, Double valorCompra, Double valorVenda, Double estoque, String localizacao, Fornecedor fornecedor, CategoriaProduto categoria, double margemLucro) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.estoque = estoque;
        this.localizacao = localizacao;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.margemLucro = margemLucro;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
}
