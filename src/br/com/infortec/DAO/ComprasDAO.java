/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Compras;
import br.com.infortec.bean.Fornecedor;
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
public class ComprasDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public ComprasDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Compras> listarTodasCompras() {


        ArrayList<Compras> lista = new ArrayList<Compras>();
        String sql = "SELECT * FROM compras;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            Compras compras = new Compras();
            while (rsConsultar.next()) {



                int cod = rsConsultar.getInt("cod_compras");
                double custoTotal = rsConsultar.getDouble("custo_total_vendas");
                double vlrDesconto = rsConsultar.getDouble("valor_desconto_compras");
                double custoPgmt = rsConsultar.getDouble("custo_pagar_compras");
                int id = rsConsultar.getInt("fornecedor_cod_fornecedor");
                Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(id);


                lista.add(compras);
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

    public Integer inserirCompras(Compras compras) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO compras (custo_total_vendas, valor_desconto_compras, custo_pagar_compras, fornecedor_cod_fornecedor ) VALUES (?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            inserir.setDouble(1, compras.getCustoTotal());
            inserir.setDouble(2, compras.getVlrDesconto());
            inserir.setDouble(3, compras.getCustoPgmt());
            inserir.setInt(4, compras.getFornecedor().getCodFornecedor());


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
            System.out.println("erro no SQL");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Compras consultarCompras(int cod) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Compras compras = null;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        String sql = "SELECT * FROM compras WHERE cod_compras = " + cod + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
               // cod = rsConsultar.getInt("cod_compras");
                double custoTotal = rsConsultar.getDouble("custo_total_vendas");
                double vlrDesconto = rsConsultar.getDouble("valor_desconto_compras");
                double custoPgmt = rsConsultar.getDouble("custo_pagar_compras");
                int id = rsConsultar.getInt("fornecedor_cod_fornecedor");
                Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(id);

                compras = new Compras(cod, custoTotal, vlrDesconto, custoPgmt, fornecedor);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return compras;
    }

    public int excluirCompras(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from compras WHERE cod_compras = " + cod + ";";
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

    public int alterarCompras(Compras compras, int idCompras) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE compras SET cod_compras=?, custo_total_vendas=?, valor_desconto_compras=?, custo_pagar_compras=?, fornecedor_cod_fornecedor=?  WHERE cod_compras=" + idCompras + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setInt(1, compras.getCod());
            alterar.setDouble(2, compras.getCustoTotal());
            alterar.setDouble(3, compras.getVlrDesconto());
            alterar.setDouble(4, compras.getCustoPgmt());


            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idCompras;
    }
}
