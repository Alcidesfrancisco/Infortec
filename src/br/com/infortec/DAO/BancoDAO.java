/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Banco;
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
public class BancoDAO {
    
    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public BancoDAO() {
        this.connection = conexao.abrirConexao();
    }
    
    public ArrayList<Banco> listarTodosBancos() {

        ArrayList<Banco> lista = new ArrayList<Banco>();
        String sql = "SELECT * FROM banco;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codBanco = rsConsultar.getInt("cod_banco");
                String nome = rsConsultar.getString("nome_banco");
                String agencia = rsConsultar.getString("agencia_banco");
                String conta = rsConsultar.getString("conta_banco");
                String gerente = rsConsultar.getString("gerente_banco");
                String fone = rsConsultar.getString("fone_banco");
                String observacao = rsConsultar.getString("observacoes_banco");
               
                Banco banco = new Banco(codBanco, nome, agencia, conta, gerente, fone, observacao);

                lista.add(banco);
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

    public Integer inserirBanco(Banco banco) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO banco (nome_banco, agencia_banco, conta_banco, gerente_banco, fone_banco, observacoes_banco) VALUES (?,?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, banco.getNome());
            inserir.setString(2, banco.getAgencia());
            inserir.setString(3, banco.getConta());
            inserir.setString(4, banco.getGerente());
            inserir.setString(5, banco.getFone());
            inserir.setString(6, banco.getObs());
            
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

    public Banco consultarBanco(int codBanco) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Banco banco = null;

        String sql = "SELECT * FROM banco WHERE cod_banco = " + codBanco + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codBanco = rsConsultar.getInt("cod_banco");
                String nome = rsConsultar.getString("nome_banco");
                String agencia = rsConsultar.getString("agencia_banco");
                String conta = rsConsultar.getString("conta_banco");
                String gerente = rsConsultar.getString("gerente_banco");
                String fone = rsConsultar.getString("fone_banco");
                String obs = rsConsultar.getString("observacoes_banco");
                
                banco = new Banco(codBanco, nome, agencia, conta, gerente, fone, obs);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return banco;
    }

    public int excluirBanco(int codBanco) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from banco WHERE cod_banco = " + codBanco + ";";
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
        return codBanco;
    }

    public int alteraBanco(Banco banco, int idBanco) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE banco SET nome_banco=?, agencia_banco=?, conta_banco=?, gerente_banco=?, fone_banco=?, observacoes_banco=? WHERE cod_banco=" + idBanco + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            alterar.setInt(1, categoria.getCodCategoria());
            alterar.setString(1, banco.getNome());
            alterar.setString(2, banco.getAgencia());
            alterar.setString(3, banco.getConta());
            alterar.setString(4, banco.getGerente());
            alterar.setString(5, banco.getFone());
            alterar.setString(6, banco.getObs());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idBanco;
    }
}
