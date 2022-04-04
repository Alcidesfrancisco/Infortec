/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Fornecedor;
import java.sql.SQLException;
import br.com.infortec.comunicacao.Conexao;
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

/**
 *
 * @author Infortec
 */
public class FornecedorDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public FornecedorDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<Fornecedor> listarTodosFornecedores() {


        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        String sql = "SELECT * FROM fornecedor;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            while (rsConsultar.next()) {

                int codCliente = rsConsultar.getInt("cod_fornecedor");
                String nome = rsConsultar.getString("nome_fornecedor");
                String cnpj = rsConsultar.getString("cnpj_fornecedor");
                String email = rsConsultar.getString("email_fornecedor");
                String fax = rsConsultar.getString("fax_fornecedor");
                String fone = rsConsultar.getString("fone_fornecedor");
                String logradouro = rsConsultar.getString("logradouro_fornecedor");
                String bairro = rsConsultar.getString("bairro_fornecedor");
                String cidade = rsConsultar.getString("cidade_fornecedor");
                String uf = rsConsultar.getString("uf_fornecedor");
                String numero = rsConsultar.getString("numero_fornecedor");
                String pais = rsConsultar.getString("pais_fornecedor");
                String cpf = rsConsultar.getString("cpf_fornecedor");
                String tipo = rsConsultar.getString("tipo_fornecedor");
                String cep = rsConsultar.getString("cep_fornecedor");
                String complemento = rsConsultar.getString("complemento_fornecedor");

                Fornecedor fornecedor = new Fornecedor(codCliente, nome, cnpj, email, fax, fone, cpf, tipo, logradouro, complemento, bairro, cep, cidade, uf, numero, pais);

                lista.add(fornecedor);
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

    public Integer inserirfornecedor(Fornecedor fornecedor) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO fornecedor (nome_fornecedor, cnpj_fornecedor, email_fornecedor, fax_fornecedor, fone_fornecedor, logradouro_fornecedor, bairro_fornecedor, cidade_fornecedor, uf_fornecedor, cep_fornecedor, numero_fornecedor, pais_fornecedor, cpf_fornecedor, tipo_fornecedor, complemento_fornecedor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, fornecedor.getNome());
            inserir.setString(2, fornecedor.getCnpj());
            inserir.setString(3, fornecedor.getEmail());
            inserir.setString(4, fornecedor.getFax());
            inserir.setString(5, fornecedor.getFoneFornecedor());
            inserir.setString(6, fornecedor.getLogradouro());
            inserir.setString(7, fornecedor.getBairro());
            inserir.setString(8, fornecedor.getCidade());
            inserir.setString(9, fornecedor.getUf());
            inserir.setString(10, fornecedor.getCep());
            inserir.setString(11, fornecedor.getNumero());
            inserir.setString(12, fornecedor.getPais());
            inserir.setString(13, fornecedor.getCpf());
            inserir.setString(14, fornecedor.getTipo());
            inserir.setString(15, fornecedor.getComplemento());

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

    public Fornecedor consultarFornecedor(int codFornecedor) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Fornecedor fornecedor = null;

        String sql = "SELECT * FROM fornecedor WHERE cod_fornecedor = " + codFornecedor + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                codFornecedor = rsConsultar.getInt("cod_fornecedor");
                String nome = rsConsultar.getString("nome_fornecedor");
                String cnpj = rsConsultar.getString("cnpj_fornecedor");
                String email = rsConsultar.getString("email_fornecedor");
                String fax = rsConsultar.getString("fax_fornecedor");
                String fone = rsConsultar.getString("fone_fornecedor");
                String logradouro = rsConsultar.getString("logradouro_fornecedor");
                String bairro = rsConsultar.getString("bairro_fornecedor");
                String cidade = rsConsultar.getString("cidade_fornecedor");
                String uf = rsConsultar.getString("uf_fornecedor");
                String cep = rsConsultar.getString("cep_fornecedor");
                String numero = rsConsultar.getString("numero_fornecedor");
                String pais = rsConsultar.getString("pais_fornecedor");
                String cpf = rsConsultar.getString("cpf_fornecedor");
                String tipo = rsConsultar.getString("tipo_fornecedor");
                String complemento = rsConsultar.getString("complemento_fornecedor");

                fornecedor = new Fornecedor(codFornecedor, nome, cnpj, email, fax, fone, cpf, logradouro, complemento, bairro, cep, cidade, uf, numero, pais, tipo);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return fornecedor;
    }

    public int excluirFornecedor(int codFornecedor) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from fornecedor WHERE cod_fornecedor = " + codFornecedor + ";";
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
        return codFornecedor;
    }

    public int alteraFornecedor(Fornecedor fornecedor, int idFornecedor) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE fornecedor SET nome_fornecedor=?, cnpj_fornecedor=?, email_fornecedor=?, fax_fornecedor=?, fone_fornecedor=?, logradouro_fornecedor=?, bairro_fornecedor=?, cidade_fornecedor=?, uf_fornecedor=?, cep_fornecedor=?, numero_fornecedor=?, pais_fornecedor=?, cpf_fornecedor=?, tipo_fornecedor=? ,complemento_fornecedor=? WHERE cod_fornecedor=" + idFornecedor + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            
            alterar.setString(1, fornecedor.getNome());
            alterar.setString(2, fornecedor.getCnpj());
            alterar.setString(3, fornecedor.getEmail());
            alterar.setString(4, fornecedor.getFax());
            alterar.setString(5, fornecedor.getFoneFornecedor());
            alterar.setString(6, fornecedor.getLogradouro());
            alterar.setString(7, fornecedor.getBairro());
            alterar.setString(8, fornecedor.getCidade());
            alterar.setString(9, fornecedor.getUf());
            alterar.setString(10, fornecedor.getCep());
            alterar.setString(11, fornecedor.getNumero());
            alterar.setString(12, fornecedor.getPais());
            alterar.setString(13, fornecedor.getCpf());
            alterar.setString(14, fornecedor.getTipo());
            alterar.setString(15, fornecedor.getComplemento());

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return fornecedor.getCodFornecedor();
    }
}
