/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.CategoriaProduto;
import br.com.infortec.bean.Fornecedor;
import br.com.infortec.bean.Produto;
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

public class ProdutoDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ProdutoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Produto> listarTodosProdutos() {


        ArrayList<Produto> lista = new ArrayList<Produto>();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        String sql = "SELECT * FROM produto;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {


                int codProduto = rsConsultar.getInt("cod_produto");
                String nome = rsConsultar.getString("nome_produto");
                String descricao = rsConsultar.getString("descricao_produto");
                double valorCompra = rsConsultar.getDouble("valor_compra_produto");
                double valorVenda = rsConsultar.getDouble("valor_venda_produto");
                double estoque = rsConsultar.getDouble("estoque");
                String localizacao = rsConsultar.getString("localizacao_produto");
                int idFornecedor = rsConsultar.getInt("fornecedor_cod_fornecedor");
                Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(idFornecedor);
                int idCategoriaProduto = rsConsultar.getInt("cod_categoria_produto");
                CategoriaProduto categoriaProduto = categoriaProdutoDAO.consultarCategoria(idCategoriaProduto);
                double lucro = rsConsultar.getDouble("margemLucro");

                Produto produto = new Produto(codProduto, nome, descricao, valorCompra, valorVenda, estoque, localizacao, fornecedor, categoriaProduto, lucro);

                lista.add(produto);
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

    public Integer inserirproduto(Produto produto) {

        PreparedStatement inserir = null;
        int id = 0;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        String sql = "INSERT INTO produto (nome_produto, descricao_produto, valor_compra_produto, valor_venda_produto, estoque,localizacao_produto, fornecedor_cod_fornecedor, cod_categoria_produto, margemLucro) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, produto.getNome());
            inserir.setString(2, produto.getDescricao());
            inserir.setDouble(3, produto.getValorCompra());
            inserir.setDouble(4, produto.getValorVenda());
            inserir.setDouble(5, produto.getEstoque());
            inserir.setString(6, produto.getLocalizacao());
            inserir.setInt(7, produto.getFornecedor().getCodFornecedor());
            inserir.setInt(8, produto.getCategoria().getCodCategoria());
            inserir.setDouble(9, produto.getMargemLucro());

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

    public Produto consultarProduto(int codProduto) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Produto produto = null;
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        String sql = "SELECT * FROM produto WHERE cod_produto = " + codProduto + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                codProduto = rsConsultar.getInt("cod_produto");
                String nome = rsConsultar.getString("nome_produto");
                String descricao = rsConsultar.getString("descricao_produto");
                double valorCompra = rsConsultar.getDouble("valor_compra_produto");
                double valorVenda = rsConsultar.getDouble("valor_venda_produto");
                double estoque = rsConsultar.getDouble("estoque");
                String localizacao = rsConsultar.getString("localizacao_produto");
                int idFornecedor = rsConsultar.getInt("fornecedor_cod_fornecedor");
                System.out.println("teste id fornecedor" + idFornecedor);
                Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(idFornecedor);
                int idCategoriaProduto = rsConsultar.getInt("cod_categoria_produto");
                System.out.println("teste id categoria" + idCategoriaProduto);
                CategoriaProduto categoriaProduto = categoriaProdutoDAO.consultarCategoria(idCategoriaProduto);
                double lucro = rsConsultar.getDouble("margemLucro");

                produto = new Produto(codProduto, nome, descricao, valorCompra, valorVenda, estoque, localizacao, fornecedor, categoriaProduto, lucro);
            }
            rsConsultar.close();
            consultar.close();
       //     JOptionPane.showMessageDialog(null, "produto Encontrado");
        } catch (SQLException errConsultar) {
            System.err.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return produto;
    }

     public Produto consultarNomeProduto(String NomeProduto) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Produto produto = null;
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        String sql = "SELECT * FROM produto WHERE nome_produto = '" + NomeProduto + "';";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                int codProduto = rsConsultar.getInt("cod_produto");
                String nome = rsConsultar.getString("nome_produto");
                String descricao = rsConsultar.getString("descricao_produto");
                double valorCompra = rsConsultar.getDouble("valor_compra_produto");
                double valorVenda = rsConsultar.getDouble("valor_venda_produto");
                double estoque = rsConsultar.getDouble("estoque");
                String localizacao = rsConsultar.getString("localizacao_produto");
                int idFornecedor = rsConsultar.getInt("fornecedor_cod_fornecedor");
                System.out.println("teste id fornecedor" + idFornecedor);
                Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(idFornecedor);
                int idCategoriaProduto = rsConsultar.getInt("cod_categoria_produto");
                System.out.println("teste id categoria" + idCategoriaProduto);
                CategoriaProduto categoriaProduto = categoriaProdutoDAO.consultarCategoria(idCategoriaProduto);
                double lucro = rsConsultar.getDouble("margemLucro");

                produto = new Produto(codProduto, nome, descricao, valorCompra, valorVenda, estoque, localizacao, fornecedor, categoriaProduto, lucro);
            }
            rsConsultar.close();
            consultar.close();
       //     JOptionPane.showMessageDialog(null, "produto Encontrado");
        } catch (SQLException errConsultar) {
            System.err.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return produto;
    }
    
    public int excluirProduto(int codproduto) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from produto WHERE cod_produto = " + codproduto + ";";
        try {
            this.connection = conexao.abrirConexao();
            excluir = this.connection.prepareStatement(sql);

            excluir.execute();
            excluir.close();
JOptionPane.showMessageDialog(null, "produto Excluido com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            retorno = -2;
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return codproduto;
    }

    public int alterarProduto(Produto produto) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE produto SET nome_produto =?, descricao_produto=?, valor_compra_produto=?, valor_venda_produto=?, estoque=?, localizacao_produto=?, fornecedor_cod_fornecedor=?, cod_categoria_produto=?,margemLucro=? WHERE cod_produto=" + produto.getCodProduto() + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setString(1, produto.getNome());
            alterar.setString(2, produto.getDescricao());
            alterar.setDouble(3, produto.getValorCompra());
            alterar.setDouble(4, produto.getValorVenda());
            alterar.setDouble(5, produto.getEstoque());
            alterar.setString(6, produto.getLocalizacao());
            alterar.setInt(7, produto.getFornecedor().getCodFornecedor());
            alterar.setInt(8, produto.getCategoria().getCodCategoria());
            alterar.setDouble(9, produto.getMargemLucro());

            alterar.execute();
            alterar.close();
            JOptionPane.showMessageDialog(null, "produto Alterado com suecesso!");
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return produto.getCodProduto();
    }
}