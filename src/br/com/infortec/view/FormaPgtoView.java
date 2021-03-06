/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormaPgtoView.java
 *
 * Created on 17/11/2011, 20:18:00
 */
package br.com.infortec.view;

import br.com.infortec.DAO.FormaPgtoDAO;
import br.com.infortec.bean.FormaPgto;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author RAFAELA
 */
public class FormaPgtoView extends JPanel {

    public FormaPgtoView() {
               initComponents();

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    int cont = 0;
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
        jPanel1 = new javax.swing.JPanel();
        btOcultar = new javax.swing.JButton();
        btMostrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtPrestacao = new javax.swing.JTextField();
        descricaoFormaPagtoLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtTaxa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        table.setBackground(new java.awt.Color(255, 255, 204));
        table.setModel(tabelaModel(listaEditaForma));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        painel.setViewportView(table);

        btOcultar.setText("Esconder Lista");
        btOcultar.addActionListener(formListener);

        btMostrar.setVisible(false);
        btMostrar.setText("Mostrar Lista");
        btMostrar.addActionListener(formListener);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btOcultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btMostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
                .addComponent(btMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE))
        );

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/salvar32x32.png"))); // NOI18N
        saveButton.setText("Salvar");
        saveButton.setToolTipText("Salvar dados");
        saveButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/inserir32x32.png"))); // NOI18N
        newButton.setText("Inserir");
        newButton.setToolTipText("Inserir dados");
        newButton.addActionListener(formListener);

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/cancelar32x32.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar dados");
        btCancelar.addActionListener(formListener);

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setToolTipText("Editar dados");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btEditar.addActionListener(formListener);

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/excluir32x32.png"))); // NOI18N
        deleteButton.setText("Excluir");
        deleteButton.setToolTipText("Excluir dados");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, deleteButton, newButton, saveButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(btCancelar)
                    .addComponent(deleteButton)
                    .addComponent(btEditar)
                    .addComponent(newButton))
                .addContainerGap())
        );

        txtNome.setToolTipText("Informe o nome ");

        txtPrestacao.setToolTipText("Informe o n??mero m??ximo de presta????es");

        descricaoFormaPagtoLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        descricaoFormaPagtoLabel.setText("Descri????o:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Taxa:");

        txtDescricao.setToolTipText("Informe os dados descritivos");

        txtTaxa.setToolTipText("Taxa percentual");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("M??ximo de Presta????es:");

        jLabel4.setText("%");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Nome:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(descricaoFormaPagtoLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(375, 375, 375))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaoFormaPagtoLabel)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrestacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == btOcultar) {
                FormaPgtoView.this.btOcultarActionPerformed(evt);
            }
            else if (evt.getSource() == btMostrar) {
                FormaPgtoView.this.btMostrarActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                FormaPgtoView.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                FormaPgtoView.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btCancelar) {
                FormaPgtoView.this.btCancelarActionPerformed(evt);
            }
            else if (evt.getSource() == btEditar) {
                FormaPgtoView.this.btEditarActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                FormaPgtoView.this.deleteButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
    FormaPgtoDAO inserirFormaPgto = new FormaPgtoDAO();
    static JFrame frame;
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    }//GEN-LAST:event_btCancelarActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        int indexExcluir = table.getSelectedRow();
        listaEditaForma.get(indexExcluir);

        FormaPgto excluirForma = listaEditaForma.get(indexExcluir);;
        int excluido = formaPgtoDAO.excluiFormaPgto(excluirForma.getCodFormaPgto());
        listaEditaForma = formaPgtoDAO.listarTodasFormaPgtoDAO();
        table.setModel(tabelaModel(listaEditaForma));
        txtNome.setText("");
        txtNome.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtDescricao.setText("");
        txtPrestacao.setEnabled(false);
        txtPrestacao.setText("");
        txtTaxa.setEnabled(false);
        txtTaxa.setText("");
        txtDescricao.setText("");
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        txtNome.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtPrestacao.setEnabled(true);
        txtTaxa.setEnabled(true);
        txtNome.requestFocus();
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (cont % 2 == 0) {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            int Prestacoes = Integer.valueOf(txtPrestacao.getText());
            double taxa = Double.valueOf(txtTaxa.getText());
            FormaPgto formaPgto = new FormaPgto(txtNome.getText(), txtDescricao.getText(), Integer.valueOf(txtPrestacao.getText()), Double.valueOf(txtTaxa.getText()));
            int idForma = inserirFormaPgto.inserirFormaPgto(formaPgto);

            listaEditaForma.add(formaPgto);
            table.setModel(tabelaModel(listaEditaForma));
            int row = table.getRowCount() - 1;
            if (table.getRowCount() >= 1) {
                table.setRowSelectionInterval(row, row);
            }
            table.scrollRectToVisible(table.getCellRect(table.getRowCount() + 1, 0, true));

            txtNome.setText("");
            txtDescricao.setText("");
        } else {
            String alterDescricao = txtDescricao.getText();
            String alterNome = txtNome.getText();
            int alterPretacoes = Integer.valueOf(txtPrestacao.getText());
            double altertaxa = 0;
            try {
                altertaxa = Double.valueOf(txtTaxa.getText());
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Forma de pagamento cadastradas com taxa igual a  0");
            }


            FormaPgto formaAlterar = listaEditaForma.get(table.getSelectedRow());

            formaAlterar.setNome(alterNome);
            formaAlterar.setDescricao(alterDescricao);
            formaAlterar.setNumParcelas(alterPretacoes);
            formaAlterar.setTaxa(altertaxa);
            formaPgtoDAO.alteraFormaPgto(formaAlterar, formaAlterar.getCodFormaPgto());

            table.setModel(tabelaModel(listaEditaForma));

            txtNome.setText("");
            txtDescricao.setText("");

        }
    }//GEN-LAST:event_saveButtonActionPerformed

private void btOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOcultarActionPerformed
    painel.setVisible(false);
    btOcultar.setVisible(false);
    btMostrar.setVisible(true);
    frame.setSize(680, 270);
}//GEN-LAST:event_btOcultarActionPerformed

private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
    painel.setVisible(true);
    btOcultar.setVisible(true);
    btMostrar.setVisible(false);
    frame.setSize(680, 400);
}//GEN-LAST:event_btMostrarActionPerformed

private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if (cont % 2 == 0) {      //editar linha
        txtNome.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtPrestacao.setEnabled(true);
        txtTaxa.setEnabled(true);
        txtNome.requestFocus();
        btEditar.setText("Cancelar Edi????o");
        cont++;
        editarLinha();

    } else {                //cancelar edi????o
        cont++;
        txtNome.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtPrestacao.setEnabled(false);
        txtTaxa.setEnabled(false);
        txtNome.requestFocus();
        btEditar.setText("Editar");
    }
}//GEN-LAST:event_btEditarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btMostrar;
    private javax.swing.JButton btOcultar;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descricaoFormaPagtoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton newButton;
    private javax.swing.JScrollPane painel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrestacao;
    private javax.swing.JTextField txtTaxa;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public static void main(final String[] args) {
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
//            java.util.logging.Logger.getLogger(FormaPgtoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormaPgtoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormaPgtoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormaPgtoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                frame = new JFrame();
                frame.setContentPane(new FormaPgtoView());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
//                frame.setTitle(args[0]);
            }
        });
    }

    public TableModel tabelaModel(List<FormaPgto> listaForma) {
        int n = 0;
        JTable table1;
        FormaPgtoDAO FormaPgtoDAO = new FormaPgtoDAO();
        listaForma = FormaPgtoDAO.listarTodasFormaPgtoDAO();
        Object[][] data = new Object[listaForma.size()][5];
        String[] columnNames = {"Cod. Forma Pgto", "Nome", "Descri????o", "M??ximo Preta????es", "Taxa"};

        for (FormaPgto formaPgto : listaForma) {
            data[n][0] = formaPgto.getCodFormaPgto();
            data[n][1] = formaPgto.getNome();
            data[n][2] = formaPgto.getDescricao();
            data[n][3] = formaPgto.getNumParcelas();
            data[n][4] = formaPgto.getTaxa();

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

            @Override
            public void mouseClicked(MouseEvent e) {
                if (cont % 2 == 1) {
                    editarLinha();
                }
            }
        });
        return model;
    }
    FormaPgtoDAO formaPgtoDAO = new FormaPgtoDAO();
    List<FormaPgto> listaEditaForma = formaPgtoDAO.listarTodasFormaPgtoDAO();

    public void editarLinha() {


        int index = table.getSelectedRow();
        FormaPgto editarForma = listaEditaForma.get(index);
        txtNome.setText(editarForma.getNome());
        txtDescricao.setText(editarForma.getDescricao());
        txtPrestacao.setText(String.valueOf(editarForma.getNumParcelas()));

    }
}
