/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.bean;

/**
 *
 * @author Israelly
 */
public class ChequePagamento {
    
    Cheque cheque;
    Pagamento pagamento;

    public ChequePagamento() {
    }

    public ChequePagamento(Cheque cheque, Pagamento pagamento) {
        this.cheque = cheque;
        this.pagamento = pagamento;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
    
}
