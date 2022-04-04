/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Telefone;
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
public class TelefoneDAO {
    
    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public TelefoneDAO() {
        this.connection = conexao.abrirConexao();
    }
    
    public ArrayList<Telefone> listarTodosTelefonesCliente() {


        ArrayList<Telefone> lista = new ArrayList<Telefone>();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        String sql = "SELECT * FROM cliente_telefone;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {
                
                int cod = rsConsultar.getInt("cod_telefone");
                String num = rsConsultar.getString("num_telefone");
                String tipo = rsConsultar.getString("tipo_telefone");
                int idCliente = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCliente);
                Telefone telefone = new Telefone();
                
    

    lista.add(telefone);
                n++;
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException e) {
            System.err.println("Erro SQL: \n" + e);
        } finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }
    public Integer inserirTelefone(Telefone telefone) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO cliente_telefone (cod_telefone, num_telefone, tipo_telefone, cliente_cod_cliente ) VALUES (?,?,?,?)";



        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //inserir.setInt(1, endereco.getCliente().getCodCliente());
            //inserir.setString(2, endereco.getLogradouro());
            inserir.setInt(1, telefone.getCod());
            inserir.setString(2,telefone.getNum());
            inserir.setString(3, telefone.getTipo());
            inserir.setInt(4, telefone.getCliente().getCodCliente());
            

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
public Telefone consultarTelefone(int cod) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Telefone telefone = null;

        String sql = "SELECT * FROM telefone WHERE cod_telefone = " + cod + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            ClienteDAO clienteDAO = new ClienteDAO();
            while (rsConsultar.next()) {
                cod = rsConsultar.getInt("cod_telefone");
                String num = rsConsultar.getString("num_telefone");
                String tipo = rsConsultar.getString("tipo_telefone");
                int idCliente = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCliente);
                

                telefone = new Telefone(cod, num, tipo, cliente);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Telefone.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return telefone;
    }
public int excluirTelefone(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from cliente_telefone WHERE cod_telefone = " + cod +  ";";
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
public int alteraTelefone( Telefone telefone) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;
        
        

        String sql = "UPDATE cliente_telefone SET  num_telefone=?, tipo_telefone=?, cliente_cod_cliente=? WHERE cod_telefone=" + telefone.getCod() +  ";";

        try {
            alterar = connection.prepareStatement(sql);

            
            alterar.setString(1, telefone.getNum());
            alterar.setString(2, telefone.getTipo());
            alterar.setInt(3, telefone.getCliente().getCodCliente());
            
            
            

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return telefone.getCliente().getCodCliente();
    }
}
