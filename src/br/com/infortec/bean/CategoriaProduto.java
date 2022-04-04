/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Infortec
 */

public class CategoriaProduto {
    
    private int codCategoria;
    private String nomeCategoria;
    private String descricaoCategoria;

    public CategoriaProduto(){}
    
    public CategoriaProduto(int codCategoria, String nomeCategoria, String descricaoCategoria) {
        this.codCategoria = codCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }
    public CategoriaProduto(String nome, String descricaoCategoria) {
        this.nomeCategoria = nome;
        this.descricaoCategoria = descricaoCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getdescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setdescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public String getnomeCategoria() {
        return nomeCategoria;
    }

    public void setnomeCategoria(String nome) {
        this.nomeCategoria = nome;
    }
    
    
    
    
}
