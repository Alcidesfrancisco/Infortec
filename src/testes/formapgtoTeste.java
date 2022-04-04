/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.FormaPgtoDAO;
import br.com.infortec.bean.FormaPgto;
import java.util.List;

/**
 *
 * @author Infortec
 */
public class formapgtoTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      FormaPgtoDAO formaDAO = new FormaPgtoDAO();
      List<FormaPgto> formaLista = formaDAO.listarTodasFormaPgtoDAO();
      for(FormaPgto forma: formaLista){
//          System.out.println(forma.getCodFormaPgto());
//          System.out.println(forma.getNome());
//          System.out.println(forma.getDescricao());
//          System.out.println(forma.getNumParcelas());
//          System.out.println(forma.getTaxa());
//      
      }
      FormaPgto inserir = new FormaPgto("agiota", "Pagamento para se lascar", 3, 30);
      int id = formaDAO.inserirFormaPgto(inserir);
        System.out.println(id);
//      FormaPgto consultar = formaDAO.consultarFormaPgto(1);
//        System.out.println(consultar.getCodFormaPgto());
//        System.out.println(consultar.getDescricao());
//        System.out.println(consultar.getNome());
//        System.out.println(consultar.getNumParcelas());
//        System.out.println(consultar.getTaxa());
//        System.out.println("");
//        
//        int id2 = formaDAO.alteraFormaPgto(inserir, 3);
//        System.out.println(id2);
//        
//        int id3 = formaDAO.excluiFormaPgto(3);
//        System.out.println(id3);
        
      
    }
}
