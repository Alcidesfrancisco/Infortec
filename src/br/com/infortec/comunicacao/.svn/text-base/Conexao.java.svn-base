/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.comunicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Infortec
 */
public class Conexao {

    private String login = "root";
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/infortec";
    private String senha = "";
    private Connection conexao;

    public Connection abrirConexao() {
        try {
            Class.forName(driver);
            System.out.println("Driver carregado!");

        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível carregar o driver!\n" + e);
        }


        try {
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conectado ao Banco de dados!\n");
        } catch (SQLException ex) {
            System.out.println("Não foi possível conectar o banco!\n" + ex);
        }

    //    System.out.println(conexao);
        return conexao;
    }

    public Connection fecharConexao() {
        try {
            conexao.close();
            System.out.println("Conexao Fechada!\n");
        } catch (SQLException ex) {
            System.out.println("Não foi possível fechar a conexao!\n");
        }
        System.out.println(conexao);
        return conexao;
    }
}
