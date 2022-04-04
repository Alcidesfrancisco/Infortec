/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Departamento;
import br.com.infortec.bean.Funcionario;
import br.com.infortec.comunicacao.Conexao;
import br.com.infortec.util.DataConverter;
import java.sql.Connection;
import java.util.Date;
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
public class FuncionarioDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();
    DataConverter dc = new DataConverter();
    DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public FuncionarioDAO() {
        this.connection = (Connection) conexao.abrirConexao();
    }

    public ArrayList<Funcionario> listarTodosFuncionarios() {


        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        try {
            this.connection = (Connection) conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            Departamento departamento = null;
            Funcionario funcionario = null;

            while (rsConsultar.next()) {

                int cod = rsConsultar.getInt("cod_funcionarios");
                String nome = rsConsultar.getString("nome_funcionarios");
                String cpf = rsConsultar.getString("cpf_funcionarios");
                String rg = rsConsultar.getString("rg_funcionarios");
                double salario = rsConsultar.getDouble("salario_funcionarios");
                double comissao = rsConsultar.getDouble("comissao_funcionarios");
                double meta = rsConsultar.getDouble("meta_funcionarios");
                String admissao = dc.convertDataDate(rsConsultar.getDate("admissao_funcionarios"));
                String demissao = dc.convertDataDate(rsConsultar.getDate("admissao_funcionarios"));
                String login = rsConsultar.getString("login_funcionarios");
                String senha = rsConsultar.getString("senha_funcionarios");
                String logradouro = rsConsultar.getString("logradouro_funcionario");
                String bairro = rsConsultar.getString("bairro_funcionario");
                String cidade = rsConsultar.getString("cidade_funcionario");
                String uf = rsConsultar.getString("uf_funcionario");
                String cep = rsConsultar.getString("cep_funcionario");
                String pais = rsConsultar.getString("pais_funcionario");
                String nascimento = dc.convertDataDate(rsConsultar.getDate("nascimento_funcionario"));
                String email = rsConsultar.getString("email_funcionario");
                int id = rsConsultar.getInt("departamento_cod_departamento");
                departamento = departamentoDAO.consultarDepartamento(id);
                String numero = rsConsultar.getString("numeroEnd");
                String complemento = rsConsultar.getString("complemento");
                String foto = rsConsultar.getString("foto");

                funcionario = new Funcionario(cod, nome, cpf, rg, salario, comissao, meta, admissao, demissao, login, senha, nascimento, email, departamento, logradouro, complemento, bairro, cep, cidade, uf, numero, pais, foto);

                lista.add(funcionario);
                n++;
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException e) {
            System.err.println("Erro aqui: \n" + e);
        } finally {

            this.connection = (Connection) conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirFuncionarios(Funcionario funcionario) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO funcionario (nome_funcionarios, cpf_funcionarios, rg_funcionarios, salario_funcionarios, comissao_funcionarios, meta_funcionarios, admissao_funcionarios, demissao_funcionarios, login_funcionarios, senha_funcionarios, logradouro_funcionario, bairro_funcionario, cidade_funcionario, uf_funcionario, cep_funcionario, pais_funcionario, nascimento_funcionario, email_funcionario, departamento_cod_departamento,numeroEnd,complemento,foto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.connection = (Connection) conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            inserir.setString(1, funcionario.getNome());
            inserir.setString(2, funcionario.getCpf());
            inserir.setString(3, funcionario.getRg());
            inserir.setDouble(4, funcionario.getSalario());
            inserir.setDouble(5, funcionario.getComissao());
            inserir.setDouble(6, funcionario.getMeta());
            try {
                inserir.setDate(7, dc.convertDataString(funcionario.getAdmissao()));
                if (funcionario.getDemissao().equals("")) {
                    inserir.setDate(8, null);
                } else {
                    inserir.setDate(8, dc.convertDataString(funcionario.getDemissao()));
                }
            } catch (SQLException sQLException) {
            }
            inserir.setString(9, funcionario.getLogin());
            inserir.setString(10, funcionario.getSenha());
            inserir.setString(11, funcionario.getLogradouro());
            inserir.setString(12, funcionario.getBairro());
            inserir.setString(13, funcionario.getCidade());
            inserir.setString(14, funcionario.getUf());
            inserir.setString(15, funcionario.getCep());
            inserir.setString(16, funcionario.getPais());
            inserir.setDate(17, dc.convertDataString(funcionario.getNascimento()));
            inserir.setString(18, funcionario.getEmail());
            inserir.setInt(19, funcionario.getDepartamento().getCodDepartamento());
            inserir.setString(20, funcionario.getNumero());
            inserir.setString(21, funcionario.getComplemento());
            inserir.setString(22, funcionario.getFoto());

            inserir.executeUpdate();

            ResultSet rs = inserir.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("Id gerado pelo insert:" + id);

            inserir.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Funcionário Salvo com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
            System.out.println("Erro no SQL");
            return -2;

        } finally {
            this.connection = (Connection) conexao.fecharConexao();
        }

        return id;
    }

    public Funcionario consultarFuncionario(int cod) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        Funcionario funcionario = null;


        String sql = "SELECT * FROM funcionario WHERE cod_funcionarios = " + cod + ";";
        try {
            this.connection = (Connection) conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                cod = rsConsultar.getInt("cod_funcionarios");
                String nome = rsConsultar.getString("nome_funcionarios");
                String cpf = rsConsultar.getString("cpf_funcionarios");
                String rg = rsConsultar.getString("rg_funcionarios");
                double salario = rsConsultar.getDouble("salario_funcionarios");
                double comissao = rsConsultar.getDouble("comissao_funcionarios");
                double meta = rsConsultar.getDouble("meta_funcionarios");
                String admissao = dc.convertDataDate(rsConsultar.getDate("admissao_funcionarios"));
                String demissao = dc.convertDataDate(rsConsultar.getDate("demissao_funcionarios"));
                String login = rsConsultar.getString("login_funcionarios");
                String senha = rsConsultar.getString("senha_funcionarios");
                String logradouro = rsConsultar.getString("logradouro_funcionario");
                String bairro = rsConsultar.getString("bairro_funcionario");
                String cidade = rsConsultar.getString("cidade_funcionario");
                String uf = rsConsultar.getString("uf_funcionario");
                String cep = rsConsultar.getString("cep_funcionario");
                String pais = rsConsultar.getString("pais_funcionario");
                String nascimento = dc.convertDataDate(rsConsultar.getDate("nascimento_funcionario"));
                String email = rsConsultar.getString("email_funcionario");
                int id = rsConsultar.getInt("departamento_cod_departamento");
                Departamento departamento = departamentoDAO.consultarDepartamento(id);
                String numero = rsConsultar.getString("numeroEnd");
                String complemento = rsConsultar.getString("complemento");
                String foto = rsConsultar.getString("foto");

                funcionario = new Funcionario(cod, nome, cpf, rg, salario, comissao, meta, admissao, demissao, login, senha, nascimento, email, departamento, logradouro, complemento, bairro, cep, cidade, uf, numero, pais, foto);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = (Connection) conexao.fecharConexao();
        }
        return funcionario;
    }

    public int excluirFuncionarios(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from funcionario WHERE cod_funcionarios = " + cod + ";";
        try {
            this.connection = (Connection) conexao.abrirConexao();
            excluir = this.connection.prepareStatement(sql);

            excluir.execute();
            excluir.close();
            JOptionPane.showMessageDialog(null, "Funcionário Excluído!");
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            retorno = -2;
        } finally {
            this.connection = (Connection) conexao.fecharConexao();
        }
        return cod;
    }

    public int alterarFuncionario(Funcionario funcionario, int idFuncionario) {
        this.connection = (Connection) conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE funcionario SET  cod_funcionarios=?, nome_funcionarios=?, cpf_funcionarios=?, rg_funcionarios=?, salario_funcionarios=?, comissao_funcionarios=?, meta_funcionarios=?, admissao_funcionarios=?, demissao_funcionarios=?, login_funcionarios=?, senha_funcionarios=?, logradouro_funcionario=?, bairro_funcionario=?, cidade_funcionario=?, uf_funcionario=?, cep_funcionario=?, pais_funcionario=?, nascimento_funcionario=?, email_funcionario=?, departamento_cod_departamento=?, numeroEnd=?,complemento=?,foto=?  WHERE cod_funcionarios=" + idFuncionario + ";";

        try {
            alterar = connection.prepareStatement(sql);
            alterar.setInt(1, funcionario.getCod());
            alterar.setString(2, funcionario.getNome());
            alterar.setString(3, funcionario.getCpf());
            alterar.setString(4, funcionario.getRg());
            alterar.setDouble(5, funcionario.getSalario());
            alterar.setDouble(6, funcionario.getComissao());
            alterar.setDouble(7, funcionario.getMeta());
            try {
                alterar.setDate(8, dc.convertDataString(funcionario.getAdmissao()));
                if (funcionario.getDemissao().equals("")) {
                    alterar.setDate(9, null);
                } else {
                    alterar.setDate(9, dc.convertDataString(funcionario.getDemissao()));
                }
            } catch (SQLException sQLException) {
            }
            alterar.setString(10, funcionario.getLogin());
            alterar.setString(11, funcionario.getSenha());
            alterar.setString(12, funcionario.getLogradouro());
            alterar.setString(13, funcionario.getBairro());
            alterar.setString(14, funcionario.getCidade());
            alterar.setString(15, funcionario.getUf());
            alterar.setString(16, funcionario.getCep());
            alterar.setString(17, funcionario.getPais());
            alterar.setDate(18, dc.convertDataString(funcionario.getNascimento()));
            alterar.setString(19, funcionario.getEmail());
            alterar.setInt(20, funcionario.getDepartamento().getCodDepartamento());
            alterar.setString(21, funcionario.getNumero());
            alterar.setString(22, funcionario.getComplemento());
            alterar.setString(23, funcionario.getFoto());

            alterar.execute();
            alterar.close();
            JOptionPane.showMessageDialog(null, "Funcionário Alterado com Sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return idFuncionario;
    }
}