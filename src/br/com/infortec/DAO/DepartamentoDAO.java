/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;


import br.com.infortec.bean.Departamento;
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
public class DepartamentoDAO {
    
     private Connection connection = null;
    private Conexao conexao = new Conexao();

    public DepartamentoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Departamento> listarTodosDepartamentos() {

        ArrayList<Departamento> lista = new ArrayList<Departamento>();
        String sql = "SELECT * FROM departamento;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codDepartamento = rsConsultar.getInt("cod_departamento");
                String nome = rsConsultar.getString("nome_departamento");
                

                Departamento departamento = new Departamento(codDepartamento, nome);

                lista.add(departamento);
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

    public Integer inserirDepartamento(Departamento departamento) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO departamento (nome_departamento) VALUES (?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, departamento.getNome());
            
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

    public Departamento consultarDepartamento(int codDepartamento) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Departamento departamento = null;

        String sql = "SELECT * FROM departamento WHERE cod_departamento = " + codDepartamento + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codDepartamento = rsConsultar.getInt("cod_departamento");
                String descricao = rsConsultar.getString("nome_departamento");
              
                departamento = new Departamento(codDepartamento, descricao);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Departamento.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return departamento;
    }

    public int excluirDepartamento(int codDepartamento) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from departamento WHERE cod_departamento = " + codDepartamento + ";";
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
        return codDepartamento;
    }

    public int alteraDepartamento(Departamento departamento) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE unidade SET Descricao=?, qtde=? WHERE codUnidade=" + departamento.getCodDepartamento() + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            
            alterar.setString(1, departamento.getNome());
            

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return departamento.getCodDepartamento();
    }
}
