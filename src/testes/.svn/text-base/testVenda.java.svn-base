/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.ClienteDAO;
import br.com.infortec.DAO.FuncionarioDAO;
import br.com.infortec.DAO.VendasDAO;
import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Funcionario;
import br.com.infortec.bean.Vendas;

/**
 *
 * @author Infortec
 */
public class testVenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ClienteDAO clienteDAO = new ClienteDAO();
      FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
      VendasDAO vendasDAO = new VendasDAO();
      Cliente cliente = clienteDAO.consultarCliente(1);
      Funcionario funcionario = funcionarioDAO.consultarFuncionario(2);
   
        Vendas venda = new Vendas(cliente, funcionario);
        int idvendas = vendasDAO.inserirVendasCab(venda);
        System.out.println(idvendas);
        System.out.println(venda.getCliente().getNome());
        System.out.println(venda.getFuncionario().getLogin());
    }
}
