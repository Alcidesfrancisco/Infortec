/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServicoView.java
 *
 * Created on 12/10/2011, 19:07:04
 */
package br.com.infortec.view;

import br.com.infortec.DAO.ServicoDAO;
import br.com.infortec.bean.Servico;
import br.com.infortec.util.LimitadorCaracteres;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Infortec
 */
public class ServicoView extends JPanel {

    public ServicoView() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btInserir = new javax.swing.JButton()
        ;
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        FormListener formListener = new FormListener();

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Descri????o do Servi??o:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Pre??o do Servi??o:");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescricao.setToolTipText("Informe os dados descritivos do servi??o");

        txtPreco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPreco.setToolTipText("Informe o valor do servi??o");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/cancelar32x32.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar dados");
        btCancelar.addActionListener(formListener);

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/excluir32x32.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Excluir dados");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btExcluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btExcluir.addActionListener(formListener);

        btInserir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/inserir32x32.png"))); // NOI18N
        btInserir.setText("Inserir");
        btInserir.setToolTipText("Inserir dados");
        btInserir.addActionListener(formListener);

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/salvar32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar dados");
        btSalvar.addActionListener(formListener);

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setToolTipText("Editar dados");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, table, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btEditar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btEditar.addActionListener(formListener);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btInserir)
                .addGap(6, 6, 6)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btExcluir, btInserir, btSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btInserir)
                    .addComponent(btEditar))
                .addContainerGap())
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Servi??os", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setForeground(java.awt.Color.blue);

        table.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        table.setFont(new java.awt.Font("Tahoma", 3, 14));
        table.setForeground(new java.awt.Color(0, 51, 0));
        table.setModel(tabelaModel(listaEditaServico));
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.setAutoscrolls(false);
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == btCancelar) {
                ServicoView.this.btCancelarActionPerformed(evt);
            }
            else if (evt.getSource() == btExcluir) {
                ServicoView.this.btExcluirActionPerformed(evt);
            }
            else if (evt.getSource() == btInserir) {
                ServicoView.this.btInserirActionPerformed(evt);
            }
            else if (evt.getSource() == btSalvar) {
                ServicoView.this.btSalvarActionPerformed(evt);
            }
            else if (evt.getSource() == btEditar) {
                ServicoView.this.btEditarActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
    int cont = 0;
    static JFrame frame;
    ServicoDAO servicoDAO = new ServicoDAO();
    List<Servico> listaEditaServico = servicoDAO.listarTodosServicos();
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        frame.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int indexExcluir = table.getSelectedRow();

        Servico excluirServico = listaEditaServico.get(indexExcluir);
        int excluido = servicoDAO.excluirServico(excluirServico.getIdServico());
        listaEditaServico = servicoDAO.listarTodosServicos();
        table.setModel(tabelaModel(listaEditaServico));

        txtDescricao.setText("");
        txtPreco.setText("");

        txtDescricao.setEnabled(false);
        txtPreco.setEnabled(false);
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        cont = 2;

        txtDescricao.setText("");
        txtPreco.setText("");

        txtDescricao.setEnabled(true);
        txtPreco.setEnabled(true);

        txtDescricao.requestFocus();

        int row = listaEditaServico.size() - 1;
        table.scrollRectToVisible(table.getCellRect(row, 0, true));
    }//GEN-LAST:event_btInserirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (cont % 2 == 0) {
            String descricao = txtDescricao.getText();
            double preco = Double.valueOf(txtPreco.getText());

            Servico servico = new Servico(descricao, preco);
            int isServico = servicoDAO.inserirServico(servico);

            listaEditaServico.add(servico);
            table.setModel(tabelaModel(listaEditaServico));
            int row = table.getRowCount() - 1;
            if (table.getRowCount() >= 1) {
                table.setRowSelectionInterval(row, row);
            }
            table.scrollRectToVisible(table.getCellRect(table.getRowCount() + 1, 0, true));

            txtDescricao.setText("");
            txtPreco.setText("");
        } else {
            String alterDescricao = txtDescricao.getText();
            Double alterpreco = Double.valueOf(txtPreco.getText());

            Servico servicoAlterar = listaEditaServico.get(table.getSelectedRow());

            servicoAlterar.setDescricao(alterDescricao);
            servicoAlterar.setPreco(alterpreco);

            servicoDAO.alterarServico(servicoAlterar);

            table.setModel(tabelaModel(listaEditaServico));

            txtDescricao.setText("");
            txtPreco.setText("");
        }
    }//GEN-LAST:event_btSalvarActionPerformed

private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if (cont % 2 == 0) {      //editar linha
        txtDescricao.setEnabled(true);
        txtPreco.setEnabled(true);

        btEditar.setText("Cancelar Edi????o");
        txtDescricao.requestFocus();
        cont++;
        editarLinha();

    } else {                //cancelar edi????o
        txtDescricao.setEnabled(false);
        txtPreco.setEnabled(false);
        btEditar.setText("Editar");
        txtDescricao.requestFocus();
        cont++;
    }
}//GEN-LAST:event_btEditarActionPerformed
    LimitadorCaracteres obj = new LimitadorCaracteres();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPreco;
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
//            java.util.logging.Logger.getLogger(ServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                frame = new JFrame();
                frame.setContentPane(new ServicoView());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
//                frame.setTitle(args[0]);
            }
        });
    }

    public TableModel tabelaModel(List<Servico> listaServicos) {
        int n = 0;
        JTable table1;
        ServicoDAO servicoDAO = new ServicoDAO();
        listaServicos = servicoDAO.listarTodosServicos();
        Object[][] data = new Object[listaServicos.size()][3];
        String[] columnNames = {"Cod servico", "Descri????o", "preco"};

        for (Servico servicos : listaServicos) {
            data[n][0] = servicos.getIdServico();
            data[n][1] = servicos.getDescricao();
            data[n][2] = servicos.getPreco();
            n++;
        }
        table1 = new JTable(data, columnNames);
        table1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        table1.setFont(new Font("Tahoma", 3, 14)); // NOI18N
        table1.setForeground(new java.awt.Color(0, 51, 0));

        //     table1.setPreferredScrollableViewportSize(new Dimension(800, 800));
        table1.setFillsViewportHeight(true);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(300);
        table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        javax.swing.table.TableModel model = table1.getModel();

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (cont % 2 == 1) {
                    editarLinha();
                }
            }
        });
        return model;//adiciona um modela a tabela
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void editarLinha() {
        int index = table.getSelectedRow();

        txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
        txtPreco.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));

    }
}
