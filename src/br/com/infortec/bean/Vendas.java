/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Israelly
 */
public class Vendas {

    int cod;
    double vlrTotal;
    double vlrDesc;
    double vlrPg;
    Cliente cliente;
    Funcionario funcionario;

    public Vendas() {
    }

    public Vendas(Cliente cliente, Funcionario funcionario) {
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Vendas(double vlrTotal, double vlrDesc, double vlrPg, Cliente cliente, Funcionario funcionario) {
        this.vlrTotal = vlrTotal;
        this.vlrDesc = vlrDesc;
        this.vlrPg = vlrPg;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Vendas(int cod, double vlrTotal, double vlrDesc, double vlrPg, Cliente cliente, Funcionario funcionario) {
        this.cod = cod;
        this.vlrTotal = vlrTotal;
        this.vlrDesc = vlrDesc;
        this.vlrPg = vlrPg;
        this.cliente = cliente;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getVlrDesc() {
        return vlrDesc;
    }

    public void setVlrDesc(double vlrDesc) {
        this.vlrDesc = vlrDesc;
    }

    public double getVlrPg() {
        return vlrPg;
    }

    public void setVlrPg(double vlrPg) {
        this.vlrPg = vlrPg;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }
}
