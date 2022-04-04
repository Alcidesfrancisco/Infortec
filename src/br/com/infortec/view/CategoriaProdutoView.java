/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CategoriaProdutoView.java
 *
 * Created on 15/11/2011, 12:09:29
 */
package br.com.infortec.view;

import br.com.infortec.DAO.CategoriaProdutoDAO;
import br.com.infortec.bean.CategoriaProduto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Infortec
 */
public class CategoriaProdutoView extends javax.swing.JFrame {

    /** Creates new form CategoriaProdutoView */
    public CategoriaProdutoView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        painel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btMostrar = new javax.swing.JButton();
        btOcultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table.setBackground(new java.awt.Color(255, 255, 204));
        table.setModel(tabelaModel(listaCat));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMouseEntered(evt);
            }
        });
        painel.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Nome da Categoria:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Descrição da Categoria");

        txtNome.setEnabled(false);
        txtNome.setToolTipText("Informe o nome da categoria de produto pretendida");

        txtDescricao.setEnabled(false);
        txtDescricao.setToolTipText("Informe os dados descritivos da categoria");

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/salvar32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar dados");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/cancelar32x32.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar dados");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setToolTipText("Editar dados");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 12));
        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/inserir32x32.png"))); // NOI18N
        btInserir.setText("Inserir");
        btInserir.setToolTipText("Inserir dados");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/excluir32x32.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Excluir dados");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btExcluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btEditar)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir))
                .addContainerGap())
        );

        btMostrar.setText("Mostrar lista");
        btMostrar.setVisible(false);
        btMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarActionPerformed(evt);
            }
        });

        btOcultar.setText("Esconder lista");
        btOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOcultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btOcultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMostrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(475, 475, 475))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(494, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    CategoriaProdutoDAO inserircategoriaProduto = new CategoriaProdutoDAO();

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    if (cont % 2 == 0) {
        int idCat = inserircategoriaProduto.inserirCategoria(txtNome.getText(), txtDescricao.getText());

        String objDescricao = txtDescricao.getText();
        CategoriaProduto c = new CategoriaProduto(idCat, txtNome.getText(), objDescricao);
        listaCat.add(c);
        table.setModel(tabelaModel(listaCat));
        int row = table.getRowCount() - 1;
       if(table.getRowCount()>=1){
            table.setRowSelectionInterval(row, row);
            }
        table.scrollRectToVisible(table.getCellRect(table.getRowCount() + 1, 0, true));

        txtNome.setText("");
        txtDescricao.setText("");
    } else {
        String objDescricao = txtDescricao.getText();
        String objNome = txtNome.getText();
        //  CategoriaProduto catAlterar = new CategoriaProduto(,objNome, objDescricao);

        CategoriaProduto catAlterar = listaCat.get(table.getSelectedRow());

        catAlterar.setnomeCategoria(objNome);
        catAlterar.setdescricaoCategoria(objDescricao);
        categoriaProdutoDAO.alteraCategoria(catAlterar, catAlterar.getCodCategoria());

        table.setModel(tabelaModel(listaCat));

        txtNome.setText("");
        txtDescricao.setText("");

    }
}//GEN-LAST:event_btSalvarActionPerformed

private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
    txtNome.setEnabled(true);
    txtDescricao.setEnabled(true);
    txtNome.requestFocus();
}//GEN-LAST:event_btInserirActionPerformed

private void btOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOcultarActionPerformed

    painel.setVisible(false);
    btOcultar.setVisible(false);
    btMostrar.setVisible(true);
}//GEN-LAST:event_btOcultarActionPerformed

private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
    painel.setVisible(true);
    btOcultar.setVisible(true);
    btMostrar.setVisible(false);
}//GEN-LAST:event_btMostrarActionPerformed
    int cont = 0;
private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if (cont % 2 == 0) {      //editar linha
        txtNome.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtNome.requestFocus();
        btEditar.setText("Cancelar Edição");
        btSalvar.setText("Alterar");
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/requisicao.png")));
        cont++;
        editarLinha();

    } else {                //cancelar edição
        cont++;
        txtNome.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtNome.requestFocus();
        btEditar.setText("Editar");
        btSalvar.setText("Salvar");

    }

}//GEN-LAST:event_btEditarActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

    int indexExcluir = table.getSelectedRow();
    listaCat.get(indexExcluir);

    CategoriaProduto cat = listaCat.get(indexExcluir);;
    int excluido = categoriaProdutoDAO.excluiCategoriaProduto(cat.getCodCategoria());
    listaCat = categoriaProdutoDAO.listarTodasCategoriasProdutos();
    table.setModel(tabelaModel(listaCat));
    txtNome.setText("");
    txtNome.setEnabled(false);
    txtDescricao.setEnabled(false);
    txtDescricao.setText("");

//    JOptionPane.showMessageDialog(null, "Categoria com id: "+cat.getCodCategoria()+"\n"
//            + "nome: "+cat.getnomeCategoria()+"\n"
//            + "descrição: "+cat.getdescricaoCategoria()+"\n"
//            + "foi excluida.");


}//GEN-LAST:event_btExcluirActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    dispose();
}//GEN-LAST:event_btCancelarActionPerformed

private void tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseEntered
    txtNome.requestFocus();
}//GEN-LAST:event_tableMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CategoriaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CategoriaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CategoriaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CategoriaProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CategoriaProdutoView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btMostrar;
    private javax.swing.JButton btOcultar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane painel;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public TableModel tabelaModel(List<CategoriaProduto> listaCat) {
        int n = 0;
        JTable table1;
        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        listaCat = categoriaProdutoDAO.listarTodasCategoriasProdutos();
        Object[][] data = new Object[listaCat.size()][3];
        String[] columnNames = {"Cod. Categoria", "Nome categoria", "Descrição Categoria"};

        for (CategoriaProduto categoria : listaCat) {
            data[n][0] = categoria.getCodCategoria();
            data[n][1] = categoria.getnomeCategoria();
            data[n][2] = categoria.getdescricaoCategoria();

            n++;
        }

        table1 = new JTable(data, columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table1.setFillsViewportHeight(true);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(300);
        table1.getColumnModel().getColumn(2).setPreferredWidth(300);
        javax.swing.table.TableModel model = table1.getModel();



        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (cont % 2 == 1) {
                    editarLinha();
                }
            }
        });
        return model;
    }
    CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
    List<CategoriaProduto> listaCat = categoriaProdutoDAO.listarTodasCategoriasProdutos();

    public void editarLinha() {


        int index = table.getSelectedRow();
        System.out.println(index);

        txtNome.setText((String) table.getValueAt(table.getSelectedRow(), 1));
        txtDescricao.setText((String) table.getValueAt(table.getSelectedRow(), 2));

    }

    /**
     * @param txtDescricao the txtDescricao to set
     */
    public void setTxtDescricao(javax.swing.JTextField txtDescricao) {
        this.txtDescricao = txtDescricao;
    }

    /**
     * @param txtNome the txtNome to set
     */
    public void setTxtNome(javax.swing.JTextField txtNome) {
        this.txtNome = txtNome;
    }
}
