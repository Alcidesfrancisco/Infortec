/*;
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.CategoriaProduto;
import br.com.infortec.bean.Cliente;
import br.com.infortec.comunicacao.Conexao;
import br.com.infortec.util.DataConverter;
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
 * @author Alcides
 */
public class ClienteDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();
    DataConverter dataConverter = new DataConverter();

    public ClienteDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Cliente> listarTodosClientes() {

        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codCliente = rsConsultar.getInt("cod_cliente");
                String nome = rsConsultar.getString("nome_cliente");
                String cpf = rsConsultar.getString("cpf_cliente");
                String rg = rsConsultar.getString("rg_cliente");
                String orgao = rsConsultar.getString("orgao_rg_cliente");
                String dataNascimento = rsConsultar.getString("nascimento_cliente");
                String profissao = rsConsultar.getString("profissao_cliente");
                String empresa = rsConsultar.getString("empresa_cliente");
                String foneEmpresa = rsConsultar.getString("fone_empresa");
                String tipoCliente = rsConsultar.getString("tipo_cliente");
                String cnpj = rsConsultar.getString("cnpj_cliente");
                String referencia = rsConsultar.getString("referencia_cliente");
                String foneReferencia = rsConsultar.getString("fone_referencia_cliente");
                String email = rsConsultar.getString("email");

                Cliente ClienteBean = new Cliente(codCliente, nome, cpf, rg, orgao, dataNascimento, profissao, empresa, foneEmpresa, tipoCliente, cnpj, referencia, foneReferencia, email);

                lista.add(ClienteBean);
                n++;
            }
            rsConsultar.close();
            consultar.close();

//        } catch (ParseException ex) {
//                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println("Erro aqui: \n" + e);
        } finally {

            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirCliente(String nome, String cpf, String rg, String orgao, String dataNascimento, String profissao, String empresa, String foneEmpresa, String tipoCliente, String cnpj, String referencia, String foneReferencia, String email) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO cliente (nome_cliente, cpf_cliente, rg_cliente, orgao_rg_cliente, nascimento_cliente, profissao_cliente, empresa_cliente, fone_empresa, tipo_cliente, cnpj_cliente, referencia_cliente, fone_referencia_cliente, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Cliente cliente = new Cliente(nome, cpf, rg, orgao, dataNascimento, profissao, empresa, foneEmpresa, tipoCliente, cnpj, referencia, foneReferencia, email);
        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, cliente.getNome());
            inserir.setString(2, cliente.getCpf());
            inserir.setString(3, cliente.getRg());
            inserir.setString(4, cliente.getOrgao());
            inserir.setString(5, (cliente.getDataNascimento()));
            inserir.setString(6, cliente.getProfissao());
            inserir.setString(7, cliente.getEmpresa());
            inserir.setString(8, cliente.getFoneEmpresa());
            inserir.setString(9, cliente.getTipoCliente());
            inserir.setString(10, cliente.getCnpj());
            inserir.setString(11, cliente.getReferencia());
            inserir.setString(12, cliente.getFoneReferencia());
            inserir.setString(13, cliente.getEmail());
            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert foi " + id);

            inserir.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
//        } catch (ParseException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("erro no SQL Alcides");
            return -2;

        } finally {
            this.connection = conexao.fecharConexao();
        }

        return id;
    }

    public Cliente consultarCliente(int codCliente) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Cliente cliente = null;

        String sql = "SELECT * FROM cliente WHERE cod_cliente = " + codCliente + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                codCliente = rsConsultar.getInt("cod_cliente");
                String nome = rsConsultar.getString("nome_cliente");
                String cpf = rsConsultar.getString("cpf_cliente");
                String rg = rsConsultar.getString("rg_cliente");
                String orgao = rsConsultar.getString("orgao_rg_cliente");
                String dataNascimento = (rsConsultar.getString("nascimento_cliente"));
                String profissao = rsConsultar.getString("profissao_cliente");
                String empresa = rsConsultar.getString("empresa_cliente");
                String foneEmpresa = rsConsultar.getString("fone_empresa");
                String tipoCliente = rsConsultar.getString("tipo_cliente");
                String cnpj = rsConsultar.getString("cnpj_cliente");
                String referencia = rsConsultar.getString("referencia_cliente");
                String foneReferencia = rsConsultar.getString("fone_referencia_cliente");
                String email = rsConsultar.getString("email");

                cliente = new Cliente(codCliente, nome, cpf, rg, orgao, dataNascimento, profissao, empresa, foneEmpresa, tipoCliente, cnpj, referencia, foneReferencia, email);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(CategoriaProduto.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return cliente;
    }

    public int excluirCliente(int codCliente) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from cliente WHERE cod_cliente = " + codCliente + ";";
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
        return codCliente;
    }

    public int alteraCliente(Cliente cliente, int idCliente) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE cliente SET nome_cliente =?, cpf_cliente=?, rg_cliente=?, orgao_rg_cliente=?, nascimento_cliente=?, profissao_cliente=?, empresa_cliente=?, fone_empresa=?, tipo_cliente=?, cnpj_cliente=?, referencia_cliente=?, fone_referencia_cliente=?, email=? WHERE cod_cliente=" + idCliente + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            alterar.setInt(1, categoria.getCodCategoria());
            alterar.setString(1, cliente.getNome());
            alterar.setString(2, cliente.getCpf());
            alterar.setString(3, cliente.getRg());
            alterar.setString(4, cliente.getOrgao());
            alterar.setString(5, (cliente.getDataNascimento()));
            alterar.setString(6, cliente.getProfissao());
            alterar.setString(7, cliente.getEmpresa());
            alterar.setString(8, cliente.getFoneEmpresa());
            alterar.setString(9, cliente.getTipoCliente());
            alterar.setString(10, cliente.getCnpj());
            alterar.setString(11, cliente.getReferencia());
            alterar.setString(12, cliente.getFoneReferencia());
            alterar.setString(13, cliente.getEmail());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return cliente.getCodCliente();
    }
}