/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscaProdutoView.java
 *
 * Created on 30/11/2011, 05:45:20
 */
package br.com.infortec.view;

import br.com.infortec.DAO.ComprasDAO;
import br.com.infortec.DAO.ProdutoComprasDAO;
import br.com.infortec.DAO.ProdutoDAO;
import br.com.infortec.bean.Compras;
import br.com.infortec.bean.ItensCompras;
import br.com.infortec.bean.Produto;
import br.com.infortec.bean.ProdutoCompras;
import br.com.infortec.converter.RowSorterToStringConverter;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Infortec
 */
public class BuscaProdutoView extends javax.swing.JPanel {

    /** Creates new form BuscaProdutoView */
    public BuscaProdutoView() {
        initComponents();
        RowSorterToStringConverter rowSorterToStringConverter = new RowSorterToStringConverter();
        rowSorterToStringConverter.setTable(table);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private static int codCompra;
    ProdutoComprasDAO ProdutoComprasDAO = new ProdutoComprasDAO();
    ComprasDAO comprasDAO = new ComprasDAO();
    ProdutoCompras produtoCompras=null;
    ItensCompras itensCompras = new ItensCompras();
    public static int add=0;
    public static List<ItensCompras> produtosComprados= new ArrayList<ItensCompras>();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        table.setModel(tabelaModel(listaBuscaProduto));
        table.setRowSorter(new TableRowSorter(table.getModel()));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar Produto");

        jButton1.setText("Importar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton2)
                .addContainerGap(556, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
ComprasView cv = new ComprasView();
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Produto produto = listaBuscaProduto.get(table.getSelectedRow());
    System.out.println(produto.getNome());
//ComprasView.produtoimportado = produto;
ComprasView.setTxtProduto(produto.getNome());
produtosComprados.add(itensCompras);
produtosComprados.get(0).setProduto(produto);
//cv.table.setModel(cv.tabelaModel(produtosComprados));

//Compras compra = comprasDAO.consultarCompras(codCompra);

//int idProdutoCompra = ProdutoComprasDAO.inserirProdutoCompras(produtoCompras);
//ComprasView.setProdutoCompras(produtoCompras);
//frame.dispose();
    
    //EstoqueView ev = new EstoqueView();
//Produto produto = listaBuscaProduto.get(table.getSelectedRow());
//ev.importaProduto(produto);

    
    //    table.getValueAt(table.getSelectedRow(), 1);
//    Produto produto = listaBuscaProduto.get(table.getSelectedRow());
    
    
//    EstoqueView.produtoImportado = produto;
//
//    EstoqueView.txtProduto.setText(produto.getNome());


//frame.dispose();

}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//    cv.table.setModel(cv.tabelaModel(produtosComprados));
}//GEN-LAST:event_jButton2ActionPerformed
    ProdutoDAO produtoDAO = new ProdutoDAO();
    List<Produto> listaBuscaProduto = produtoDAO.listarTodosProdutos();
    int cont = 0;
    private static JFrame frame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
public void adicionaProduto(){
produtosComprados.add(itensCompras);
produtosComprados.get(add).setProduto(listaBuscaProduto.get(table.getSelectedRow()));
//cv.table.setModel(cv.tabelaModel(produtosComprados));
add++;
}

public void removeProduto(int index){
produtosComprados.remove(index);
add--;
}
    
    
    public TableModel tabelaModel(List<Produto> listaProdutos) {
        int n = 0;
        JTable table1;
        listaProdutos = produtoDAO.listarTodosProdutos();
        Object[][] data = new Object[listaProdutos.size()][10];
        String[] columnNames = {"cod Produto", "Nome", "Descri????o", "Valor Compra", "Valor Venda", "Estoque", "Localiza????o", "Fornecedor", "Categoria", "Margem Lucro"};

        for (Produto produtos : listaProdutos) {
            data[n][0] = produtos.getCodProduto();
            data[n][1] = produtos.getNome();
            data[n][2] = produtos.getDescricao();
            data[n][3] = produtos.getValorCompra();
            data[n][4] = produtos.getValorVenda();
            data[n][5] = produtos.getEstoque();
            data[n][6] = produtos.getLocalizacao();
            data[n][7] = produtos.getFornecedor().getNome();
            data[n][8] = produtos.getCategoria().getnomeCategoria();
            data[n][9] = produtos.getMargemLucro();

            n++;
        }

        table1 = new JTable(data, columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table1.setFillsViewportHeight(true);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(300);
        table1.getColumnModel().getColumn(2).setPreferredWidth(300);
        javax.swing.table.TableModel model = table1.getModel();
        table1.setRowSorter(new TableRowSorter(table.getModel()));


        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (cont % 2 == 1) {
                    editarLinha();
                }
            }
        });
        return model;//adiciona um modela a tabela
    }
    
    public Object convertReverse(Object mask) {
        TableRowSorter sorter = new TableRowSorter(table.getModel());

        // o seguinte comando torna o filtro case-sensitive. se voc??
        //quisre o fitro case-insensitive, descomente a linha abaixo e
        //comente as 7 linhas abaixo dela
        //sorter.setRowFilter(RowFilter.regexFilter(".*" + mask + ".*"));

        //as seguintes 7 linhas criam um filtro case-sensitie. se voc?? deseja
        //um filtro case-insensitive, comente essas linhas e descomente a linha
        //acima
        String m = mask.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
        }
        sorter.setRowFilter(RowFilter.regexFilter(".*" + sb + ".*"));
        return sorter;
    }

    public void editarLinha() {
        int index = table.getSelectedRow();


//        nomeProdutoField.setText((String) table.getValueAt(table.getSelectedRow(), 1));
//        descricaoProdutoField.setText((String) table.getValueAt(table.getSelectedRow(), 2));
//        valorCompraProdutoField.setText((String) table.getValueAt(table.getSelectedRow(), 3).toString());
//        valorVendaProdutoField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
//        estoqueField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
//        localizacaoProdutoField.setText((String) table.getValueAt(table.getSelectedRow(), 6));
//        FornecedorComboBox.setSelectedItem((String) table.getValueAt(table.getSelectedRow(), 7));
//        categoriaComboBox.setSelectedItem((String) table.getValueAt(table.getSelectedRow(), 8));
//        MargemLucroTextField.setText(table.getValueAt(table.getSelectedRow(), 9).toString());

    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                frame = new JFrame();
                frame.setContentPane(new BuscaProdutoView());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
//                frame.setTitle(args[0]);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    public static void setCodCompra(int idCompra) {
        codCompra = idCompra;
    }
}
