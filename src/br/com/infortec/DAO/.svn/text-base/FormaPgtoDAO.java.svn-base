/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.DAO;

import br.com.infortec.bean.FormaPgto;
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
 * @author Infortec
 */
public class FormaPgtoDAO {

    private Connection connection = null;
    private Conexao conexao = new Conexao();

    public FormaPgtoDAO() {
        this.connection = conexao.abrirConexao();
    }

    public ArrayList<FormaPgto> listarTodasFormaPgtoDAO() {

        ArrayList<FormaPgto> lista = new ArrayList<FormaPgto>();
        String sql = "SELECT * FROM forma_pagto;";
        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;

        try {
            this.connection = conexao.abrirConexao();

            consultar = this.connection.prepareStatement(sql);

            rsConsultar = consultar.executeQuery();
            int n = 0;

            while (rsConsultar.next()) {

                int codFormaPgto = rsConsultar.getInt("cod_forma_pagto");
                String nome = rsConsultar.getString("nome_forma_pagto");
                String descricao = rsConsultar.getString("descricao_forma_pagto");
                int numParcelas = rsConsultar.getInt("num_de_prestacoes_forma_pagto");
                double taxa = rsConsultar.getDouble("taxa");

                FormaPgto formaPgto = new FormaPgto(codFormaPgto, nome, descricao, numParcelas, taxa);

                lista.add(formaPgto);
                n++;
            }
            rsConsultar.close();
            consultar.close();
        } catch (SQLException e) {
            System.err.println("Erro: \n" + e);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return lista;
    }

    public Integer inserirFormaPgto(FormaPgto formaPgto) {

        PreparedStatement inserir = null;
        int id = 0;
        String sql = "INSERT INTO forma_pagto (nome_forma_pagto, descricao_forma_pagto, num_de_prestacoes_forma_pagto, taxa) VALUES (?, ?, ?, ?)";



        try {
            this.connection = conexao.abrirConexao();
            inserir = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // inserir.setInt(1, formaPgto.getCodFormaPgto());
            inserir.setString(1, formaPgto.getNome());
            inserir.setString(2, formaPgto.getDescricao());
            inserir.setInt(3, formaPgto.getNumParcelas());
            inserir.setDouble(4, formaPgto.getTaxa());

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

    public FormaPgto consultarFormaPgto(int idFormaPgto) {

        PreparedStatement consultar = null;
        ResultSet rsConsultar = null;
        FormaPgto formaPgto = null;

        String sql = "SELECT * FROM forma_pagto WHERE cod_forma_pagto = " + idFormaPgto + ";";
        try {
            this.connection = conexao.abrirConexao();
            consultar = connection.prepareStatement(sql);
            rsConsultar = consultar.executeQuery();
            while (rsConsultar.next()) {
                idFormaPgto = rsConsultar.getInt("cod_forma_pagto");
                String nome = rsConsultar.getString("nome_forma_pagto");
                String descricao = rsConsultar.getString("descricao_forma_pagto");
                int numPrestacao = rsConsultar.getInt("num_de_prestacoes_forma_pagto");
                double taxa = rsConsultar.getDouble("taxa");

                formaPgto = new FormaPgto(idFormaPgto, nome, descricao, numPrestacao, taxa);
            }
            rsConsultar.close();
            consultar.close();

        } catch (SQLException errConsultar) {
            System.out.println("Erro de SQL:" + errConsultar);
            Logger.getLogger(FormaPgto.class.getName()).log(Level.SEVERE, null, errConsultar);
        } finally {
            this.connection = conexao.fecharConexao();
        }
        return formaPgto;
    }

    public int excluiFormaPgto(int idFormaPgto) {

        PreparedStatement excluir = null;
        int retorno = 0;
        String sql = "DELETE from forma_pagto WHERE cod_forma_pagto = " + idFormaPgto + ";";
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
        return idFormaPgto;
    }

    public int alteraFormaPgto(FormaPgto formaPgto, int idFormaPgto) {
        this.connection = conexao.abrirConexao();
        PreparedStatement alterar = null;

        String sql = "UPDATE forma_pagto SET nome_forma_pagto=?, descricao_forma_pagto=?, num_de_prestacoes_forma_pagto = ?, taxa = ?  WHERE cod_forma_pagto=" + idFormaPgto + ";";

        try {
            alterar = connection.prepareStatement(sql);
//            alterar.setInt(1, categoria.getCodCategoria());
            alterar.setString(1, formaPgto.getNome());
            alterar.setString(2, formaPgto.getDescricao());
            alterar.setInt(3, formaPgto.getNumParcelas());
            alterar.setDouble(4, formaPgto.getTaxa());
            alterar.execute();
            alterar.close();
        } catch (SQLException e) {
            System.err.println("Erro de SQL:+ \n" + e);
        }
        return formaPgto.getCodFormaPgto();
    }
}
