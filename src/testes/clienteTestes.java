/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.ClienteDAO;
import br.com.infortec.bean.Cliente;

/**
 *
 * @author Infortec
 */
public class clienteTestes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ClienteDAO clienteDAO = new ClienteDAO();
       int idCliente = clienteDAO.inserirCliente("Luciano", "0348509888", "36548877", "ssp", null, "programador", "CEZAR", "5569099", "F", "5668890000178", "SouzaCruz", "2345678", "aleida@hotmail.com");
        System.out.println(idCliente);
      
        
        System.out.println("");
        Cliente cliente2 = clienteDAO.consultarCliente(idCliente);
        System.out.println("cnpj "+cliente2.getCnpj());
        System.out.println(" cod: "+cliente2.getCodCliente());
        System.out.println("cpf "+cliente2.getCpf());
        System.out.println("daya "+cliente2.getDataNascimento());
        System.out.println("email "+cliente2.getEmail());
        System.out.println("empresa "+cliente2.getEmpresa());
        System.out.println("fome empresa "+cliente2.getFoneEmpresa());
        System.out.println("nome "+cliente2.getNome());
        System.out.println("orgao "+cliente2.getOrgao());
        System.out.println("profissão "+cliente2.getProfissao());
        System.out.println("referencia "+cliente2.getReferencia());
        System.out.println("RG "+cliente2.getRg());
        System.out.println("tipo "+cliente2.getTipoCliente());
        System.out.println("");
        
        
        int excluido = clienteDAO.excluirCliente(3);
        System.out.println(excluido);
    }
    
}
