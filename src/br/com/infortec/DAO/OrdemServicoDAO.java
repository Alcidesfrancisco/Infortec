/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Funcionario;
import br.com.infortec.bean.OrdemServico;
import br.com.infortec.bean.Servico;
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
 * @author Israelly
 */
public class OrdemServicoDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public OrdemServicoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<OrdemServico> listarTodasOrdemServico() {


        ArrayList<OrdemServico> lista = new ArrayList<OrdemServico>();
        String sql = "SELECT * FROM ordem_servico;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        try {
            this.connection = conexao.abrirConexao();
            consultar = this.connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            int n = 0;
            OrdemServico ordemServico = new OrdemServico();
            while (rsConsultar.next()) {





                int cod = rsConsultar.getInt("cod_servico");
                String dadosAparelho = rsConsultar.getString("dados_aparelh_servico");
                Date entrada = rsConsultar.getDate("data_entrada");
                Date prevSaida = rsConsultar.getDate("previsao_saida_servico");
                Date entrega = rsConsultar.getDate("data_entrega_servico");
                String defeito = rsConsultar.getString("defeito_servico");
                double preco = rsConsultar.getDouble("preco_servico");
                String formaPgto = rsConsultar.getString("forma_pagamento_servico");
                int idCte = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCte);
                int idServ = rsConsultar.getInt("Servico_idServico");
                Servico servico = servicoDAO.consultarServico(idServ);
                int idFunc = rsConsultar.getInt("funcionarios_cod_funcionarios");
                Funcionario funcionario = funcionarioDAO.consultarFuncionario(idFunc);



                lista.add(ordemServico);
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

    public Integer inserirOrdemServico(OrdemServico ordemServico) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO ordem_servico (dados_aparelh_servico, data_entrada, previsao_saida_servico, data_entrega_servico, defeito_servico, preco_servico, forma_pagamento_servico, cliente_cod_cliente, Servico_idServico, funcionarios_cod_funcionarios  ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            inserir.setString(1, ordemServico.getDadosAparelho());
            inserir.setDate(2, ordemServico.getEntrada());
            inserir.setDate(3, ordemServico.getPrevSaida());
            inserir.setDate(4, ordemServico.getEntrega());
            inserir.setString(5, ordemServico.getDefeito());
            inserir.setDouble(6, ordemServico.getPreco());
            inserir.setString(7, ordemServico.getFormaPgto());
            inserir.setInt(8, ordemServico.getCliente().getCodCliente());
            inserir.setInt(9, ordemServico.getServico().getIdServico());
            inserir.setInt(10, ordemServico.getFuncionario().getCod());
            


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

    public OrdemServico consultarOrdemServico(int cod) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        OrdemServico ordemServico = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        ServicoDAO servicoDAO = new ServicoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        String sql = "SELECT * FROM ordem_servico WHERE cod_servico = " + cod + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();

            while (rsConsultar.next()) {
                cod = rsConsultar.getInt("cod_servico");
                String dadosAparelho = rsConsultar.getString("dados_aparelh_servico");
                Date entrada = rsConsultar.getDate("data_entrada");
                Date prevSaida = rsConsultar.getDate("previsao_saida_servico");
                Date entrega = rsConsultar.getDate("data_entrega_servico");
                String defeito = rsConsultar.getString("defeito_servico");
                double preco = rsConsultar.getDouble("preco_servico");
                String formaPgto = rsConsultar.getString("forma_pagamento_servico");
                int idCte = rsConsultar.getInt("cliente_cod_cliente");
                Cliente cliente = clienteDAO.consultarCliente(idCte);
                int idServ = rsConsultar.getInt("Servico_idServico");
                Servico servico = servicoDAO.consultarServico(idServ);
                int idFunc = rsConsultar.getInt("funcionarios_cod_funcionarios");
                Funcionario funcionario = funcionarioDAO.consultarFuncionario(idFunc);

    

                ordemServico = new OrdemServico(cod, dadosAparelho, entrada, prevSaida, entrega, defeito, preco, formaPgto, cliente, servico, funcionario);

            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(OrdemServico.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return ordemServico;
    }

    public int excluirOrdemServico(int cod) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from ordem_servico WHERE cod_servico = " + cod + ";";
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

    public int alterarOrdemServico(OrdemServico ordemServico, int id) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE ordem_servico SET dados_aparelh_servico=? data_entrada=? previsao_saida_servico=? data_entrega_servico=? defeito_servico=? preco_servico=? forma_pagamento_servico=? cliente_cod_cliente=? Servico_idServico=? funcionarios_cod_funcionarios=?    WHERE cod_servico=" + id + ";";

        try {
            alterar = connection.prepareStatement(sql);
            
            alterar.setString(1, ordemServico.getDadosAparelho());
            alterar.setDate(2, ordemServico.getEntrada());
            alterar.setDate(3, ordemServico.getPrevSaida());
            alterar.setDate(4, ordemServico.getEntrega());
            alterar.setString(5, ordemServico.getDefeito());
            alterar.setDouble(6, ordemServico.getPreco());
            alterar.setString(7, ordemServico.getFormaPgto());
            alterar.setInt(8, ordemServico.getCliente().getCodCliente());
            alterar.setInt(9, ordemServico.getServico().getIdServico());
            alterar.setInt(10, ordemServico.getFuncionario().getCod());
            

            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return id;
    }
}

