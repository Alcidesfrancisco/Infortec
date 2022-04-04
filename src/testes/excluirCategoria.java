/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.CategoriaProdutoDAO;
import br.com.infortec.bean.CategoriaProduto;

/**
 *
 * @author Infortec
 */
public class excluirCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
     
       
       int id = categoriaProdutoDAO.excluiCategoriaProduto(1);
        System.out.println(id);
    }
}
