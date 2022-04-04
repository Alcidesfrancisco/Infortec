/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Unidade;
import br.com.infortec.comunicacao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Infortec
 */
public class UnidadeDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public UnidadeDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Unidade> listarTodasUnidades() {

        ArrayList<Unidade> lista = new ArrayList<Unidade>();
        String sql = "SELECT * FROM unidade;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codUnidade = rsConsultar.getInt("codUnidade");
                String descricao = rsConsultar.getString("Descricao");
                int qtde = rsConsultar.getInt("qtde");

                Unidade unidade = new Unidade(codUnidade, descricao, qtde);

                lista.add(unidade);
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

    public Integer inserirUnidade(Unidade unidade) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO unidade (Descricao, qtde) VALUES (?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, unidade.getDescricao());
            inserir.setInt(2, unidade.getQtde());

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
            System.out.println("erro no SQL Alcides");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Unidade consultarUnidade(int codUnidade) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Unidade unidade = null;

        String sql = "SELECT * FROM unidade WHERE codUnidade = " + codUnidade + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codUnidade = rsConsultar.getInt("codUnidade");
                String descricao = rsConsultar.getString("Descricao");
                int qtde = rsConsultar.getInt("qtde");

                unidade = new Unidade(codUnidade, descricao, qtde);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Unidade.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return unidade;
    }

    public int excluirUnidade(int codUnidade) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from unidade WHERE codUnidade = " + codUnidade + ";";
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
        return codUnidade;
    }

    public int alteraBanco(Unidade unidade, int idUnidade) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE unidade SET Descricao=?, qtde=? WHERE codUnidade=" + idUnidade + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            alterar.setInt(1, categoria.getCodCategoria());
            alterar.setString(1, unidade.getDescricao());
            alterar.setInt(2, unidade.getQtde());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idUnidade;
    }
}
