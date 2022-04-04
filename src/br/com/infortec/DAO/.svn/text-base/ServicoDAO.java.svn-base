/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Servico;
import br.com.infortec.comunicacao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Infortec
 */
public class ServicoDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ServicoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Servico> listarTodosServicos() {


        ArrayList<Servico> lista = new ArrayList<Servico>();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        String sql = "SELECT * FROM servico;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {


                int codServico = rsConsultar.getInt("idServico");
                String descricao = rsConsultar.getString("Descricao_servico");
                double preco = rsConsultar.getDouble("precoServico");

                Servico servico = new Servico(codServico, descricao, preco);
//                Produto produto = new Produto(codProduto, nome, descricao, fornecedorDAO, fornecedorDAO, fornecedorDAO, localizacao, fornecedor, categoriaProduto);

                lista.add(servico);
                n++;
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException e) {
            System.err.println("Erro SQL: ++++++\n" + e);
        } finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirServico(Servico servico) {

        PreparedStatement inserir = null;
        int id = 0;
        ServicoDAO servicoDAO = new ServicoDAO();
        String sql = "INSERT INTO servico (Descricao_servico, precoServico) VALUES (?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, servico.getDescricao());
            inserir.setDouble(2, servico.getPreco());
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
            System.out.println("erro no SQL Alcides+++");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Servico consultarServico(int codServico) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Servico servico = null;

        String sql = "SELECT * FROM servico WHERE idServico = " + codServico + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                codServico = rsConsultar.getInt("idServico");
                String descricao = rsConsultar.getString("Descricao_servico");
                double preco = rsConsultar.getDouble("precoServico");

                servico = new Servico(codServico, descricao, preco);
            }
            rsConsultar.close();
            consultar.close();
            //     JOptionPane.showMessageDialog(null, "produto Encontrado");
        } catch (SQLException errConsultar) {
            System.err.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Servico.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return servico;
    }

    public int excluirServico(int codServico) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from servico= WHERE idServico = " + codServico + ";";
        try {
            this.connection = conexao.abrirConexao();
            excluir = this.connection.prepareStatement(sql);

            excluir.execute();
            excluir.close();
            JOptionPane.showMessageDialog(null, "Servico Excluido com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            retorno = -2;
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return codServico;
    }

    public int alterarServico(Servico servico) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE servico SET Descricao_servico =?,precoServico=?  WHERE idServico=" + servico.getIdServico() + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setString(1, servico.getDescricao());
            alterar.setDouble(2, servico.getPreco());
            alterar.execute();
            alterar.close();
            JOptionPane.showMessageDialog(null, "servico Alterado com suecesso!");
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return servico.getIdServico();
    }
}
