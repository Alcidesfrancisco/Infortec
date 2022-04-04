/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Compras;
import br.com.infortec.bean.ItensCompras;
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

/**
 *
 * @author Israelly
 */
public class ItensComprasDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ItensComprasDAO() {
        this.connection = conexao.abrirConexao();
    }
    ComprasDAO comprasDAO = new ComprasDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ArrayList<ItensCompras> listarTodosItensCompras() throws SQLException {


        ArrayList<ItensCompras> lista = new ArrayList<ItensCompras>();
        String sql = "SELECT * FROM itens_compras";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;

        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;


            while (rsConsultar.next()) {


                int cod = rsConsultar.getInt("cod_itens_compras");
                int idproduto = rsConsultar.getInt("produto_cod_produto");
                double qtde = rsConsultar.getDouble("qtde_itens_compras");
                double vlrUnit = rsConsultar.getDouble("valor_uni_itens_compras");
                double VlrTotal = rsConsultar.getDouble("valor_total_itens_compras");
                int id = rsConsultar.getInt("compras_cod_compras");
                Compras compras = comprasDAO.consultarCompras(id);
                Produto produto = produtoDAO.consultarProduto(idproduto);

                ItensCompras itensCompras = new ItensCompras(cod, produto, qtde, vlrUnit, VlrTotal, compras);
                lista.add(itensCompras);
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

    public int inserirÌtensCompras(List<ItensCompras> listaItensCompras) {

        PreparedStatement inserir = null;
        int id = 0;
       
        String sql = "INSERT INTO itens_compras (produto_cod_produto, qtde_itens_compras, valor_uni_itens_compras,valor_total_itens_compras, compras_cod_compras) VALUES (?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();

            for (ItensCompras inserirCompras : listaItensCompras) {
                inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                inserir.setInt(1, inserirCompras.getProduto().getCodProduto());
                inserir.setDouble(2, inserirCompras.getQtde());
                inserir.setDouble(3, inserirCompras.getVlrUnit());
                inserir.setDouble(4, inserirCompras.getVlrTotal());
                inserir.setInt(5, inserirCompras.getCompras().getCod());

                inserir.executeUpdate();

                ResultSet rs = inserir.getGeneratedKeys();

                    if (rs.next()) {
                id = rs.getInt(1);
            }
                System.out.println("Id gerado pelo insert foi: " + id);

                inserir.close();
                rs.close();
            }
            //  JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL");
           
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public ArrayList<ItensCompras> consultarItensCompras(int codCompras) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ItensCompras itensCompras = null;
        ArrayList<ItensCompras> lista = new ArrayList<ItensCompras>();

        String sql = "SELECT * FROM itens_compras WHERE compras_cod_compras = " + codCompras + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codCompras = rsConsultar.getInt("cod_itens_compras");
                int idproduto = rsConsultar.getInt("produto_cod_produto");
                double qtde = rsConsultar.getDouble("qtde_itens_compras");
                double vlrUnit = rsConsultar.getDouble("valor_uni_itens_compras");
                double vlrtotal = rsConsultar.getDouble("valor_total_itens_compras");
                int id = rsConsultar.getInt("compras_cod_compras");
                Compras compras = comprasDAO.consultarCompras(id);
                Produto produto = produtoDAO.consultarProduto(idproduto);

                itensCompras = new ItensCompras(id, produto, qtde, vlrUnit, vlrtotal, compras);

                lista.add(itensCompras);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public int excluirItensCompras(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from itens_compras WHERE cod_itens_compras = " + cod + ";";
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

    public int alterarItensCompras(ItensCompras itensCompras, int idItensCompras) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE itens_compras SET cod_itens_compras=?, produto_cod_produto=?, qtde_itens_compras=?, valor_uni_itens_compras=?,valor_total_itens_compras, compras_cod_compras=?  WHERE cod_itens_compras=" + idItensCompras + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setInt(1, itensCompras.getProduto().getCodProduto());
            alterar.setDouble(2, itensCompras.getQtde());
            alterar.setDouble(3, itensCompras.getVlrUnit());
            alterar.setDouble(4, itensCompras.getVlrTotal());
            alterar.setInt(5, itensCompras.getCompras().getCod());


            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idItensCompras;
    }
}
