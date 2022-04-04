/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Funcionario;
import br.com.infortec.bean.Vendas;
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
public class VendasDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();
    ClienteDAO clienteDAO = new ClienteDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public VendasDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Vendas> listarTodasVendas() {

        ArrayList<Vendas> lista = new ArrayList<Vendas>();
        String sql = "SELECT * FROM vendas;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;

        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;

            while (rsConsultar.next()) {
                int cod = rsConsultar.getInt("cod_vendas");
                double vlrTotal = rsConsultar.getDouble("valor_total_vendas");
                double vlrDesc = rsConsultar.getDouble("valor_desconto_vendas");
                double vlrPg = rsConsultar.getDouble("valor_a_pagar_vendas");
                int id = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(id);
                int idFunc = rsConsultar.getInt("funcionarios_cod_funcionarios");
                Funcionario funcionario = funcionarioDAO.consultarFuncionario(idFunc);

                Vendas vendas = new Vendas(cod, vlrTotal, vlrDesc, vlrPg, cliente, funcionario);

                lista.add(vendas);
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
     public Integer inserirVendasCab(Vendas vendas) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO vendas (cliente_cod_cliente, funcionarios_cod_funcionarios) VALUES (?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setInt(1, vendas.getCliente().getCodCliente());
            inserir.setInt(2, vendas.getFuncionario().getCod());


            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert foi: " + id);

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

    public Integer inserirVendas(Vendas vendas) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO vendas (valor_total_vendas, valor_desconto_vendas, valor_a_pagar_vendas, cliente_cod_cliente, funcionarios_cod_funcionarios) VALUES (?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setDouble(1, vendas.getVlrTotal());
            inserir.setDouble(2, vendas.getVlrDesc());
            inserir.setDouble(3, vendas.getVlrPg());
            inserir.setInt(4, vendas.getCliente().getCodCliente());
            inserir.setInt(5, vendas.getFuncionario().getCod());


            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert foi: " + id);

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

    public Vendas consultarVendas(int cod) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Vendas vendas = null;

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        String sql = "SELECT * FROM vendas WHERE cod_vendas = " + cod + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                cod = rsConsultar.getInt("cod_vendas");
                double vlrTotal = rsConsultar.getDouble("valor_total_vendas");
                double vlrDesc = rsConsultar.getDouble("valor_desconto_vendas");
                double vlrPg = rsConsultar.getDouble("valor_a_pagar_vendas");
                int id = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(id);
                int idFunc = rsConsultar.getInt("funcionarios_cod_funcionarios");
                Funcionario funcionario = funcionarioDAO.consultarFuncionario(idFunc);


                vendas = new Vendas(cod, vlrTotal, vlrDesc, vlrPg, cliente, funcionario);

            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return vendas;
    }

    public int excluirVendas(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from vendas WHERE cod_vendas = " + cod + ";";
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

    public int alterarCompras(Vendas vendas, int idVendas) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE vendas SET valor_total_vendas=? valor_desconto_vendas=? valor_a_pagar_vendas=? cliente_cod_cliente=? funcionarios_cod_funcionarios=?  WHERE cod_vendas=" + idVendas + ";";

        try {
            alterar = connection.prepareStatement(sql);


            alterar.setDouble(1, vendas.getVlrTotal());
            alterar.setDouble(2, vendas.getVlrDesc());
            alterar.setDouble(3, vendas.getVlrPg());
            alterar.setInt(4, vendas.getCliente().getCodCliente());
            alterar.setInt(5, vendas.getFuncionario().getCod());



            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idVendas;
    }
}
