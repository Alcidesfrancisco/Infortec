/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.ItensVendas;
import br.com.infortec.bean.Produto;
import br.com.infortec.bean.Vendas;
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
public class ItensVendasDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ItensVendasDAO() {
        this.connection = conexao.abrirConexao();
    }
    VendasDAO vendasDAO = new VendasDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ArrayList<ItensVendas> listarTodosItensVendas() {


        ArrayList<ItensVendas> lista = new ArrayList<ItensVendas>();
        String sql = "SELECT * FROM itens_vendas;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;

        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;


            while (rsConsultar.next()) {


                int cod = rsConsultar.getInt("cod_itens_vendas");
                int idProduto = rsConsultar.getInt("produto_cod_produto");
                double qtde = rsConsultar.getDouble("valor_uni_itens_vendas");
                double vlrUnit = rsConsultar.getDouble("valor_uni_itens_vendas");
                double vlrTotal = rsConsultar.getDouble("preco_total_vendas");
                int idVendas = rsConsultar.getInt("vendas_cod_vendas");
                Vendas vendas = vendasDAO.consultarVendas(idVendas);
                Produto produto = produtoDAO.consultarProduto(idProduto);

                ItensVendas itensVendas = new ItensVendas(cod, qtde, vlrUnit, vlrTotal, vendas, produto);
                lista.add(itensVendas);
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

    public int[] inserirItensVendas(List<ItensVendas> listaItensVendas) {

        PreparedStatement inserir = null;
        int[] id = new int[listaItensVendas.size()];
        int cont = 0;
        String sql = "INSERT INTO itens_vendas (qtde_itens_vendas, preco_total_vendas, valor_uni_itens_vendas, vendas_cod_vendas,produto_cod_produto) VALUES (?,?,?,?,?)";
        try {
            this.connection = conexao.abrirConexao();

            for (ItensVendas listaItensVenda : listaItensVendas) {
                inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                inserir.setDouble(1, listaItensVenda.getRqtde());
                inserir.setDouble(2, listaItensVenda.getVlrTotal());
                inserir.setDouble(3, listaItensVenda.getValorUni());
                inserir.setInt(4, listaItensVenda.getVendas().getCod());
                inserir.setInt(5, listaItensVenda.getProduto().getCodProduto());
                inserir.executeUpdate();

                ResultSet rs = inserir.getGeneratedKeys();

                if (rs.next()) {
                    id[cont] = rs.getInt(1);
                }
                System.out.println("Id gerado pelo insert foi: " + id);

                inserir.close();
                rs.close();
                //     JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                cont++;
            }
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL");
            id[cont] = -2;
            return id;
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return id;
    }

    public List<ItensVendas> consultarItensVendas(int codVenda) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ItensVendas itensVendas = null;
        ArrayList<ItensVendas> lista = new ArrayList<ItensVendas>();

        String sql = "SELECT * FROM itens_vendas WHERE vendas_cod_vendas = " + codVenda + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codVenda = rsConsultar.getInt("vendas_cod_vendas");
                double qtde = rsConsultar.getDouble("qtde_itens_venda");
                double vlrTotal = rsConsultar.getDouble("valor_uni_itens_vendas");
                double vlrUnit = rsConsultar.getDouble("valor_uni_itens_vendas");
                int idVendas = rsConsultar.getInt("vendas_cod_vendas");
                int idProduto = rsConsultar.getInt("produto_cod_produto");
                Vendas vendas = vendasDAO.consultarVendas(idVendas);
                Produto produto = produtoDAO.consultarProduto(idProduto);

                itensVendas = new ItensVendas(codVenda, qtde, vlrUnit, vlrTotal, vendas, produto);
                lista.add(itensVendas);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return lista;
    }
    public ItensVendas consultarItem(int codItemVenda) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ItensVendas itensVendas = null;
       
        String sql = "SELECT * FROM itens_vendas WHERE cod_itens_vendas = " + codItemVenda + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codItemVenda = rsConsultar.getInt("cod_itens_vendas");
                double qtde = rsConsultar.getDouble("qtde_itens_vendas");
                double vlrTotal = rsConsultar.getDouble("valor_uni_itens_vendas");
                double vlrUnit = rsConsultar.getDouble("valor_uni_itens_vendas");
                int idVendas = rsConsultar.getInt("vendas_cod_vendas");
                int idProduto = rsConsultar.getInt("produto_cod_produto");
                Vendas vendas = vendasDAO.consultarVendas(idVendas);
                Produto produto = produtoDAO.consultarProduto(idProduto);

                itensVendas = new ItensVendas(codItemVenda, qtde, vlrUnit, vlrTotal, vendas, produto);
               
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return itensVendas;
    }

    public int excluirItensVendas(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from itens_vendas WHERE cod_itens_vendas = " + cod + ";";
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

    public int alterarItensVendas(ItensVendas itensVendas, int idItensVendas) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE itens_vendas SET qtde_itens_vendas=?, preco_total_vendas=?, valor_uni_itens_vendas=?, preco_total_vendas=?  WHERE cod_itens_vendas=" + idItensVendas + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setInt(1, itensVendas.getCod());
            alterar.setDouble(2, itensVendas.getRqtde());
            alterar.setDouble(3, itensVendas.getVlrTotal());
            alterar.setDouble(4, itensVendas.getValorUni());
            alterar.setInt(5, itensVendas.getVendas().getCod());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idItensVendas;
    }
}
