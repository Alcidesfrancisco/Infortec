/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.ComprasDAO;
import br.com.infortec.DAO.FornecedorDAO;
import br.com.infortec.DAO.ProdutoComprasDAO;
import br.com.infortec.DAO.ProdutoDAO;
import br.com.infortec.bean.Compras;
import br.com.infortec.bean.Fornecedor;
import br.com.infortec.bean.Produto;
import br.com.infortec.bean.ProdutoCompras;

/**
 *
 * @author Infortec
 */
public class testprodutoCompra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDAO.consultarFornecedor(4);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ComprasDAO comprasDAO = new ComprasDAO();
        Compras compras = comprasDAO.consultarCompras(2);
        Produto produto = produtoDAO.consultarProduto(18);
        
        //int id = comprasDAO.inserirCompras(compras);
        ProdutoCompras produtoCompras = new ProdutoCompras(produto, compras);
        ProdutoComprasDAO produtoComprasDAO = new ProdutoComprasDAO();
        int id = produtoComprasDAO.inserirProdutoCompras(produtoCompras);
        System.out.println(id);
    }
}
