/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.CategoriaProdutoDAO;
import br.com.infortec.DAO.CategoriaProdutoDAO;
import br.com.infortec.DAO.FornecedorDAO;
import br.com.infortec.DAO.ProdutoDAO;
import br.com.infortec.bean.CategoriaProduto;
import br.com.infortec.bean.Fornecedor;
import br.com.infortec.bean.Produto;

/**
 *
 * @author Infortec
 */
public class testeProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(5);
        System.out.println(fornecedor+"    testtttt  +++++++++++++++coF|ornecedor");
        CategoriaProdutoDAO categoriaProdutoDAO= new CategoriaProdutoDAO();
        CategoriaProduto categoria = categoriaProdutoDAO.consultarCategoria(1);
        Produto produto = new Produto("Placa Mãe", "Placa mãe Assus modelo GT-245", 200.0, 300.0, 10.0, "GA3", fornecedor, categoria, 30);
       
        int id = produtoDAO.inserirproduto(produto);
        System.out.println(id);
    }
}
