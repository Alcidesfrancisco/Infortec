/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Banco;
import br.com.infortec.bean.Cheque;
import br.com.infortec.bean.Cliente;
import java.sql.Date;
import br.com.infortec.comunicacao.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Infortec
 */
public class ChequeDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ChequeDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Cheque> listarTodosCheques() {



        BancoDAO bancoDAO = new BancoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cheque> lista = new ArrayList<Cheque>();
        String sql = "SELECT * FROM cheque;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codCheque = rsConsultar.getInt("cod_cheque");
                int numCheque = rsConsultar.getInt("num_cheque");
                Date data = rsConsultar.getDate("data_cheque");
                double valor = rsConsultar.getInt("valor_cheque");
                String situacao = rsConsultar.getString("situacao_cheque");
                String historico = rsConsultar.getString("situacao_cheque");
                int idCliente = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCliente);
                int idBanco = rsConsultar.getInt("banco_cod_banco");
                Banco banco = bancoDAO.consultarBanco(idBanco);

                Cheque cheque = new Cheque(codCheque, data, valor, situacao, historico, banco, cliente);

                lista.add(cheque);
                n++;
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException e) {
            System.err.println("Erro aqui: \n" + e);
        } finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirEstoque(Cheque cheque) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO cheque (num_cheque,data_cheque,valor_cheque,situacao_cheque,historico_cheque,cliente_cod_cliente,banco_cod_banco) VALUES (?,?,?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            inserir.setInt(1, cheque.getNum());
            inserir.setDate(2, cheque.getData());
            inserir.setDouble(3, cheque.getVlr());
            inserir.setString(4, cheque.getSituacao());
            inserir.setInt(5, cheque.getCliente().getCodCliente());
            inserir.setInt(6, cheque.getBanco().getCodBanco());


            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert foi " + id);

            inserir.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL ");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Cheque consultarCheque(int codCheque) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        BancoDAO bancoDAO = new BancoDAO();
        Cheque cheque =null;
        String sql = "SELECT * FROM cheque WHERE cod_cheque = " + codCheque + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {

                codCheque = rsConsultar.getInt("cod_cheque");
                int numCheque = rsConsultar.getInt("num_cheque");
                Date data = rsConsultar.getDate("data_cheque");
                double valor = rsConsultar.getDouble("valor_cheque");
                String situacao = rsConsultar.getString("situacao_cheque");
                String historico = rsConsultar.getString("historico_cheque");
                int codCliente = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(codCliente);
                int codBanco = rsConsultar.getInt("banco_cod_banco");
                Banco banco = bancoDAO.consultarBanco(codBanco);

                cheque = new Cheque(codBanco, numCheque, data, valor, situacao, historico, banco, cliente);

                rsConsultar.close();
                consultar.close();
            }
        } catch (SQLException errConsultar) {
            System.err.println("Erro de SQL:" + errConsultar);

        } finally {
            this.connection = conexao.fecharConexao();
        }
        return cheque;
    }

    public int excluirCheque(int codCheque) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from cheque WHERE cod_cheque = " + codCheque + ";";
        try {
            this.connection = conexao.abrirConexao();
            excluir = this.connection.prepareStatement(sql);

            excluir.execute();
            excluir.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            retorno = -2;
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return codCheque;
    }

    public int alterarEstoque(Cheque cheque) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE cheque SET num_cheque=?, data_cheque=? data_cheque=?, historico_cheque=?,cliente_cod_cliente=?,banco_cod_banco WHERE cod_cheque=" + cheque.getCod() + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setInt(1, cheque.getNum());
            alterar.setDate(2, cheque.getData());
            alterar.setDouble(3, cheque.getVlr());
            alterar.setString(4, cheque.getSituacao());
            alterar.setString(5, cheque.getHistorico());
            alterar.setInt(6, cheque.getCliente().getCodCliente());
            alterar.setInt(7, cheque.getBanco().getCodBanco());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return cheque.getCod();
    }
}
