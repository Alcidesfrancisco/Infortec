/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.CategoriaProduto;
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
public class CategoriaProdutoDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public CategoriaProdutoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<CategoriaProduto> listarTodasCategoriasProdutos() {

        // declaracao de variaveis locais

        // objeto do tipo ArrayList<aluno>
        ArrayList<CategoriaProduto> lista = new ArrayList<CategoriaProduto>();
        // codigo sql a ser executado
        String sql = "SELECT * FROM categoria_produto;";
        // responsavel por executar o comando sql
        PreparedStatement consultar = null;
        // responsavel por receber o resultado do comando sql
        ResultSet rsConsultar = null;
        // objeto da classe EnderecoDAO



        try {
            this.connection = conexao.abrirConexao();
            // executa o comando sql e atribui seu retorno na variavel consultar
            consultar = this.connection.prepareStatement(sql);
            // atribui seu retorno na variavel rsConsultar
            rsConsultar = consultar.executeQuery();
            int n = 0;
            // enquanto existir o proximo, continue
            while (rsConsultar.next()) {
                // atribui seus respectivos dados
                int codCategoria = rsConsultar.getInt("cod_categoria_produto");
                String nome = rsConsultar.getString("nome_categoria_produto");
                String descricao = rsConsultar.getString("descricao_categoria");

                // cria um objeto aluno com seus dados
                CategoriaProduto categoriaProduto = new CategoriaProduto(codCategoria, nome, descricao);

                //  JOptionPane.showMessageDialog(null, Aluno.getEndereco() + " - " + n);
                // adiciona o objeto endereco a lista
                lista.add(categoriaProduto);
                n++;
            }
            // fecha a conexao com as variaveis de conexao
            rsConsultar.close();
            consultar.close();
        } // caso aconteca algum erro no try, o catch tenta resolver
        catch (SQLException e) {
            System.err.println("Erro: \n" + e);
        } // se o catch nao resolver, mesmo assim a conexao sera finalizada
        finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirCategoria(String nome, String descricao) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO categoria_produto (cod_categoria_produto, nome_categoria_produto, descricao_categoria) VALUES (?, ?, ?)";


        CategoriaProduto categoriaProduto = new CategoriaProduto(nome, descricao);
        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setInt(1, categoriaProduto.getCodCategoria());
            inserir.setString(2, categoriaProduto.getnomeCategoria());
            inserir.setString(3, categoriaProduto.getdescricaoCategoria());

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

    public CategoriaProduto consultarCategoria(int idCategoria) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        CategoriaProduto categoriaProduto = null;

        //ProfessorDAO professorDAO = new ProfessorDAO();

        String sql = "SELECT * FROM categoria_produto WHERE cod_categoria_produto = " + idCategoria + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                idCategoria = rsConsultar.getInt("cod_categoria_produto");
                String nome = rsConsultar.getString("nome_categoria_produto");
                String descricao = rsConsultar.getString("descricao_categoria");

                categoriaProduto = new CategoriaProduto(idCategoria, nome, descricao);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(CategoriaProduto.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return categoriaProduto;
    }

    public int excluiCategoriaProduto(int idcategoria) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from categoria_produto WHERE cod_categoria_produto = " + idcategoria + ";";
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
        return idcategoria;
    }

    public int alteraCategoria(CategoriaProduto categoria, int idCategoriaAntigo) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE categoria_produto SET nome_categoria_produto=?, descricao_categoria=? WHERE cod_categoria_produto=" + idCategoriaAntigo + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            alterar.setInt(1, categoria.getCodCategoria());
            alterar.setString(1, categoria.getnomeCategoria());
            alterar.setString(2, categoria.getdescricaoCategoria());
            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return categoria.getCodCategoria();
    }
}
