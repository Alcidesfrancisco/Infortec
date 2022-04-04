/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

import java.sql.Date;

/**
 *
 * @author Israelly
 */
public class OrdemServico {
    
    int cod;
    String dadosAparelho;
    Date entrada;
    Date prevSaida;
    Date entrega;
    String defeito;
    double preco;
    String formaPgto;
    Cliente cliente;
    Servico servico;
    Funcionario funcionario;

    public OrdemServico() {
    }

    public OrdemServico(String dadosAparelho, Date entrada, Date prevSaida, Date entrega, String defeito, double preco, String formaPgto, Cliente cliente, Servico servico, Funcionario funcionario) {
        this.dadosAparelho = dadosAparelho;
        this.entrada = entrada;
        this.prevSaida = prevSaida;
        this.entrega = entrega;
        this.defeito = defeito;
        this.preco = preco;
        this.formaPgto = formaPgto;
        this.cliente = cliente;
        this.servico = servico;
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDadosAparelho() {
        return dadosAparelho;
    }

    public void setDadosAparelho(String dadosAparelho) {
        this.dadosAparelho = dadosAparelho;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getPrevSaida() {
        return prevSaida;
    }

    public void setPrevSaida(Date prevSaida) {
        this.prevSaida = prevSaida;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemServico(int cod, String dadosAparelho, Date entrada, Date prevSaida, Date entrega, String defeito, double preco, String formaPgto, Cliente cliente, Servico servico, Funcionario funcionario) {
        this.cod = cod;
        this.dadosAparelho = dadosAparelho;
        this.entrada = entrada;
        this.prevSaida = prevSaida;
        this.entrega = entrega;
        this.defeito = defeito;
        this.preco = preco;
        this.formaPgto = formaPgto;
        this.cliente = cliente;
        this.servico = servico;
        this.funcionario = funcionario;
    }

    
}
