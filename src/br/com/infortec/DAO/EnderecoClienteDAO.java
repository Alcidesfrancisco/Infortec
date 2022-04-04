/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

/**
 *
 * @author Infortec
 */
import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Endereco;
import br.com.infortec.comunicacao.Conexao;
import br.com.infortec.util.DataConverter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EnderecoClienteDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public EnderecoClienteDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Endereco> listarTodosEnderecosCliente() {


        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        ClienteDAO clienteDAO = new ClienteDAO();
        String sql = "SELECT * FROM cliente_endereco;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {


                int codEndereco = rsConsultar.getInt("cod_endereco");
                String logradouro = rsConsultar.getString("logradouro_endereco");
                String complemento = rsConsultar.getString("complemento_endereco");
                String cep = rsConsultar.getString("cep_endereco");
                String bairro = rsConsultar.getString("bairro_endereco");
                String cidade = rsConsultar.getString("cidade_endereco");
                String uf = rsConsultar.getString("uf_endereco");
                String numero = rsConsultar.getString("numero_endereco");
                String pais = rsConsultar.getString("pais_endereco");
                String tipo = rsConsultar.getString("tipo_endereco");
                int idCliente = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCliente);

                Endereco endereco = new Endereco(codEndereco, cliente, logradouro, complemento, bairro, cep, cidade, uf, numero, pais, tipo);

                lista.add(endereco);
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

    public ArrayList<Endereco> listarEnderecosCliente(int idCliente) {


        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        ClienteDAO clienteDAO = new ClienteDAO();
        String sql = "SELECT * FROM cliente_endereco WHERE cliente_cod_cliente= " + idCliente + ";";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {


                int codEndereco = rsConsultar.getInt("cod_endereco");
                String logradouro = rsConsultar.getString("logradouro_endereco");
                String complemento = rsConsultar.getString("complemento_endereco");
                String cep = rsConsultar.getString("cep_endereco");
                String bairro = rsConsultar.getString("bairro_endereco");
                String cidade = rsConsultar.getString("cidade_endereco");
                String uf = rsConsultar.getString("uf_endereco");
                String numero = rsConsultar.getString("numero_endereco");
                String pais = rsConsultar.getString("pais_endereco");
                String tipo = rsConsultar.getString("tipo_endereco");
                Cliente cliente = clienteDAO.consultarCliente(idCliente);

                Endereco endereco = new Endereco(codEndereco, null, logradouro, complemento, bairro, cep, cidade, uf, numero, pais, tipo);

                lista.add(endereco);
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

    public Integer inserirEnderecoCliente(Endereco endereco) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO cliente_endereco (cliente_cod_cliente, logradouro_endereco, complemento_endereco, cep_endereco, bairro_endereco, cidade_endereco, uf_endereco, numero_endereco, pais_endereco, tipo_endereco) VALUES (?,?,?,?,?,?,?,?,?,?)";



        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setInt(1, endereco.getCliente().getCodCliente());
            inserir.setString(2, endereco.getLogradouro());
            inserir.setString(3, endereco.getComplemento());
            inserir.setString(4, endereco.getCep());
            inserir.setString(5, endereco.getBairro());
            inserir.setString(6, endereco.getCidade());
            inserir.setString(7, endereco.getUf());
            inserir.setString(8, endereco.getNumero());
            inserir.setString(9, endereco.getPais());
            inserir.setString(10, endereco.getTipo());

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

    public Cliente consultarEnderecoCliente(int codCliente, int codEndereco) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Cliente cliente = null;
DataConverter dc = new DataConverter();
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
                String dataNascimento = dc.convertDataDate(rsConsultar.getDate("nascimento_cliente"));
                String profissao = rsConsultar.getString("profissao_cliente");
                String empresa = rsConsultar.getString("empresa_cliente");
                String foneEmpresa = rsConsultar.getString("fone_empresa");
                String tipoCliente = rsConsultar.getString("tipo_cliente");
                String cnpj = rsConsultar.getString("cnpj_cliente");
                String referencia = rsConsultar.getString("referencia_cliente");
                String foneReferencia = rsConsultar.getString("fone_referencia_cliente");
                String email = rsConsultar.getString("email");
                String tipo = rsConsultar.getString("tipo_endereco");

                cliente = new Cliente(codCliente, nome, cpf, rg, orgao, dataNascimento, profissao, empresa, foneEmpresa, tipoCliente, cnpj, referencia, foneReferencia, email);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return cliente;
    }

    public int excluirEnderecosCliente(int codCliente, int codEndereco) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from cliente_endereco WHERE cliente_cod_cliente = " + codCliente + " AND cod_endereco=" + codEndereco + ";";
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

    public int alteraEnderecoCliente(Endereco endereco, int idCliente) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE cliente_endereco SET logradouro_endereco =?, complemento_endereco=?, cep_endereco=?, bairro_endereco=?, cidade_endereco=?, uf_endereco=?, numero_endereco=?, pais_endereco=?, tipo_endereco=? WHERE cod_cliente=" + idCliente + " AND cliente_cod_cliente=" + endereco.getCodEndereco() + ";";

        try {
            alterar = connection.prepareStatement(sql);

            alterar.setString(1, endereco.getLogradouro());
            alterar.setString(2, endereco.getComplemento());
            alterar.setString(3, endereco.getCep());
            alterar.setString(4, endereco.getBairro());
            alterar.setString(5, endereco.getCidade());
            alterar.setString(6, endereco.getUf());
            alterar.setString(7, endereco.getNumero());
            alterar.setString(8, endereco.getPais());
            alterar.setString(9, endereco.getTipo());


            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return endereco.getCodEndereco();
    }
}
