/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Estoque;
import br.com.infortec.bean.ItensVendas;
import br.com.infortec.bean.Produto;
import br.com.infortec.bean.Unidade;
import br.com.infortec.comunicacao.Conexao;

import br.com.infortec.util.DataConverter;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Israelly
 */
public class EstoqueDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    UnidadeDAO unidadeDAO = new UnidadeDAO();
    DataConverter dc = new DataConverter();

    public EstoqueDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Estoque> listarTodosEstoques() {

        ArrayList<Estoque> lista = new ArrayList<Estoque>();
        String sql = "SELECT * FROM estoque;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                String tipo = rsConsultar.getString("tipo_estoque");
                String data = null;
                try {
                    data = dc.convertDataDate(rsConsultar.getDate("data_estoque"));
                } catch (NullPointerException sQLException) {
                }
                double quantidade = rsConsultar.getDouble("qtde_estoque");
                int idProduto = rsConsultar.getInt("produto_cod_produto");
                Produto produto = produtoDAO.consultarProduto(idProduto);
                int codUnidade = rsConsultar.getInt("Unidade_codUnidade");
                Unidade unidade = unidadeDAO.consultarUnidade(codUnidade);
                double totalItens = rsConsultar.getDouble("total_itens");

                Estoque estoque = new Estoque(produto, tipo, data, quantidade, unidade, totalItens);

                lista.add(estoque);
                n++;
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException e) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Erro aqui: \n" + e);
        } finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirEstoque(Estoque estoque) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO estoque (tipo_estoque, data_estoque, qtde_estoque, produto_cod_produto, Unidade_codUnidade,total_itens) VALUES (?,?,?,?,?,?)";


        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            inserir.setString(1, estoque.getTipo());
            inserir.setDate(2, dc.convertDataString(estoque.getData()));
            inserir.setDouble(3, estoque.getQuantidade());
            inserir.setInt(4, estoque.getProduto().getCodProduto());
            inserir.setInt(5, estoque.getUnidade().getCod());
            inserir.setDouble(6, estoque.getTotalItens());

            try {
                inserir.executeUpdate();
            } catch (MySQLIntegrityConstraintViolationException mySQLIntegrityConstraintViolationException) {
            JOptionPane.showMessageDialog(null, "Produto já cadastrado no estoque!\n Selecionae o Produto Desejado e Clique em alterar.");
            }

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert foi " + id);

            inserir.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException e) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL ");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Estoque consultarEstoque(int codEstoque) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Estoque estoque = null;
        Unidade unidade = null;
        String sql = "SELECT * FROM estoque WHERE produto_cod_produto = " + codEstoque + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {

                String tipo = rsConsultar.getString("tipo_estoque");
                String data = dc.convertDataDate(rsConsultar.getDate("data_estoque"));
                double quantidade = rsConsultar.getDouble("qtde_estoque");
                int codProduto = rsConsultar.getInt("produto_cod_produto");
                Produto produto = produtoDAO.consultarProduto(codProduto);
                int codUnidade = rsConsultar.getInt("Unidade_codUnidade");
                unidade = unidadeDAO.consultarUnidade(codUnidade);
                double totalItens = rsConsultar.getDouble("total_itens");

                estoque = new Estoque(produto, tipo, data, quantidade, unidade, totalItens);
            }
            rsConsultar.close();
            consultar.close();
        } catch (SQLException errConsultar) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, errConsultar);
            System.err.println("Erro de SQL:" + errConsultar);

        } finally {
            this.connection = conexao.fecharConexao();
        }
        return estoque;
    }

    public int excluirEstoque(int produto_cod_produto) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from estoque WHERE produto_cod_produto = " + produto_cod_produto + ";";
        try {
            this.connection = conexao.abrirConexao();
            excluir = this.connection.prepareStatement(sql);

            excluir.execute();
            excluir.close();

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro:" + ex);
            retorno = -2;
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return produto_cod_produto;
    }

    public int alterarEstoqueTotal(Estoque estoque) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE estoque SET data_estoque=?, qtde_estoque=?, tipo_estoque=? ,total_itens=?, produto_cod_produto=?, Unidade_codUnidade=? WHERE produto_cod_produto=" + estoque.getProduto().getCodProduto() + ";";
        try {
            alterar = connection.prepareStatement(sql);

            alterar.setDate(1, dc.convertDataString(estoque.getData()));
            alterar.setDouble(2, estoque.getQuantidade());
            alterar.setString(3, estoque.getTipo());
            alterar.setDouble(4, estoque.getTotalItens());
            alterar.setInt(5, estoque.getProduto().getCodProduto());
            alterar.setInt(6, estoque.getUnidade().getCod());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return estoque.getProduto().getCodProduto();
    }

    public void alterarEstoqueVenda(List<ItensVendas> estoqueItens) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

//        Estoque estoqueBanco = this.consultarEstoque(estoqueItens.);
//        estoque.setTotalItens((estoqueBanco.getTotalItens()) - (estoque.getTotalItens()));

        String sql = "";//UPDATE estoque SET total_itens=? WHERE produto_cod_produto=" + estoque.getProduto().getCodProduto() + ";";

        try {
            alterar = connection.prepareStatement(sql);
            //alterar.setDouble(1, estoque.getTotalItens());

            alterar.execute();
            alterar.close();

        } catch (SQLException e) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Erro de SQL de estoqurDAO:+ \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
      //  return estoque.getProduto().getCodProduto();
    }

}