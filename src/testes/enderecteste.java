/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.infortec.DAO.EnderecoClienteDAO;
import br.com.infortec.bean.Cliente;
import br.com.infortec.bean.Endereco;
import br.com.infortec.view.ClienteView;
import java.util.List;

/**
 *
 * @author Infortec
 */
public class enderecteste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteView clienteView = new ClienteView();
        EnderecoClienteDAO enderecoClienteDAO = new EnderecoClienteDAO();
        Cliente endeCliente = clienteView.getListaEditaCliente().get(1);
    List<Endereco> listaEndereco = enderecoClienteDAO.listarEnderecosCliente(endeCliente.getCodCliente());
    for(Endereco lista:listaEndereco){
        System.out.println(lista.getBairro());
        System.out.println(lista.getCodEndereco());
    }
    }
}
