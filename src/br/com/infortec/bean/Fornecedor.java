/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

import br.com.infortec.bean.Endereco;

/**
 *
 * @author Infortec
 */
public class Fornecedor extends Endereco {

    private int codFornecedor;
    private String nome;
    private String cnpj;
    private String email;
    private String fax;
    private String foneFornecedor;
    private String cpf;
    private String tipo;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String cnpj, String email, String fax, String foneFornecedor, String cpf, String logradouro, String complemento, String bairro, String cep, String cidade, String uf, String numero, String pais, String tipo) {
        super(logradouro, complemento, bairro, cep, cidade, uf, numero, pais);
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.fax = fax;
        this.foneFornecedor = foneFornecedor;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public Fornecedor(int codFornecedor, String nome, String cnpj, String email, String fax, String foneFornecedor, String cpf, String tipo, String logradouro, String complemento, String bairro, String cep, String cidade, String uf, String numero, String pais) {
        super(logradouro, complemento, bairro, cep, cidade, uf, numero, pais);
        this.codFornecedor = codFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.fax = fax;
        this.foneFornecedor = foneFornecedor;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFoneFornecedor() {
        return foneFornecedor;
    }

    public void setFoneFornecedor(String foneFornecedor) {
        this.foneFornecedor = foneFornecedor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
