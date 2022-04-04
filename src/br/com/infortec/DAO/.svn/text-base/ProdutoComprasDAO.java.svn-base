/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Compras;
import br.com.infortec.bean.ItensCompras;
import br.com.infortec.bean.Produto;
import br.com.infortec.bean.ProdutoCompras;
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
 * @author Israelly
 */
public class ProdutoComprasDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ProdutoComprasDAO() {
        this.connection = conexao.abrirConexao();
    }
    ComprasDAO comprasDAO = new ComprasDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ArrayList<ProdutoCompras> listarProdutoComprasDAO() {


        ArrayList<ProdutoCompras> lista = new ArrayList<ProdutoCompras>();
        String sql = "SELECT * FROM produto_has_itens_compras;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;


        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int idProd = rsConsultar.getInt("produto_cod_produto");
                Produto produto = produtoDAO.consultarProduto(idProd);
                int idCompras = rsConsultar.getInt("itens_compras_cod_itens_compras");
                Compras Compras = comprasDAO.consultarCompras(idCompras);


                ProdutoCompras produtoCompras = new ProdutoCompras(produto, Compras);

                lista.add(produtoCompras);
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

    public Integer inserirProdutoCompras(ProdutoCompras produtoCompras) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO produto_has_itens_compras (produto_cod_produto, itens_compras_cod_itens_compras) VALUES (?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            inserir.setInt(1, produtoCompras.getProduto().getCodProduto());
            inserir.setInt(2, produtoCompras.getCompras().getCod());


            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("O Id gerado pelo insert foi: " + id);

            inserir.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public ProdutoCompras consultarProdutoCompras(int codProduto, int codCompras) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ProdutoCompras produtoCompras = null;


        String sql = "SELECT * FROM produto_has_itens_compras WHERE produto_cod_produto = " + codProduto + " AND WHERE itens_compras_cod_itens_compras=" + codCompras + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {

                int idProd = rsConsultar.getInt("produto_has_itens_compras");
                Produto produto = produtoDAO.consultarProduto(idProd);
                int idCompras = rsConsultar.getInt("itens_vendas_cod_itens_compras");
                Compras Compras = comprasDAO.consultarCompras(idCompras);

                produtoCompras = new ProdutoCompras(produto, Compras);

            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(ProdutoCompras.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return produtoCompras;
    }

    public int excluirProdutoCompras(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from produto_has_itens_compras WHERE codProduto = " + cod + ";";
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
        return cod;
    }

    public int alterarProdutoVendas(ProdutoCompras produtoCompras, int id) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE produto_has_itens_compras SET produto_cod_produto=? itens_compras_cod_itens_compras=? WHERE codProduto=" + id + ";";

        try {
            alterar = connection.prepareStatement(sql);


            alterar.setInt(1, produtoCompras.getProduto().getCodProduto());
            alterar.setInt(2, produtoCompras.getCompras().getCod());


            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return id;
    }
}
