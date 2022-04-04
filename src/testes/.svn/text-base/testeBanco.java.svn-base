/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.BancoDAO;
import br.com.infortec.bean.Banco;
import java.util.List;

/**
 *
 * @author Infortec
 */
public class testeBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BancoDAO bancoDAO = new BancoDAO();
//        Banco banco = new Banco("Itaú", "3456-X", "09899", "Edilson", "34567688", "perto da praça");
//         int idBanco = bancoDAO.inserirBanco(banco);
//         System.out.println(idBanco);
        
//        Banco banco = bancoDAO.consultarBanco(1);
//        System.out.println(banco.getAgencia());
        List<Banco> lista = bancoDAO.listarTodosBancos();
        for(Banco banco:lista){
            System.out.println(banco.getAgencia());
            System.out.println(banco.getCodBanco());
            System.out.println(banco.getConta());
            System.out.println(banco.getConta());
            System.out.println(banco.getFone());
        }
    
    }
}
