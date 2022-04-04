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
public class Cheque {
    
    int cod;
    int num;
    Date data;
    double vlr;
    String situacao;
    String historico;
    Banco banco;
    Cliente cliente;

    public Cheque() {
    }

    public Cheque(int num, Date data, double vlr, String situacao, String historico, Banco banco, Cliente cliente) {
        this.num = num;
        this.data = data;
        this.vlr = vlr;
        this.situacao = situacao;
        this.historico = historico;
        this.banco = banco;
        this.cliente = cliente;
    }

    public Cheque(int cod, int num, Date data, double vlr, String situacao, String historico, Banco banco, Cliente cliente) {
        this.cod = cod;
        this.num = num;
        this.data = data;
        this.vlr = vlr;
        this.situacao = situacao;
        this.historico = historico;
        this.banco = banco;
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getVlr() {
        return vlr;
    }

    public void setVlr(double vlr) {
        this.vlr = vlr;
    }
    
    
    
}
