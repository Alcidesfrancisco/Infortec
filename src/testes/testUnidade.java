/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.UnidadeDAO;
import br.com.infortec.bean.Unidade;

/**
 *
 * @author Infortec
 */
public class testUnidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnidadeDAO unidadeDAO = new UnidadeDAO();
//        Unidade unidade = new Unidade("Placa", 10);
//        int id = unidadeDAO.inserirUnidade(unidade);
//        System.out.println(id);
        Unidade unidade = unidadeDAO.consultarUnidade(1);
        System.out.println(unidade.getDescricao());
        
        unidade.setDescricao("Pacote");
        unidadeDAO.alteraBanco(unidade, 2);
                
    }
}
