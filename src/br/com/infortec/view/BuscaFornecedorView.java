/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscaFornecedorView.java
 *
 * Created on 14/10/2011, 03:34:13
 */
package br.com.infortec.view;

import br.com.infortec.view.*;
import br.com.infortec.DAO.FornecedorDAO;
import br.com.infortec.bean.Fornecedor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuário
 */
public class BuscaFornecedorView extends JPanel {

    public BuscaFornecedorView() {
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    static JFrame frame;
     FornecedorDAO fornecedorDAO = new FornecedorDAO();
    List<Fornecedor> ListaEditFornecedor = fornecedorDAO.listarTodosFornecedores();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        masterScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        tabPanel.setForeground(java.awt.Color.blue);
        tabPanel.setFont(new java.awt.Font("Tahoma", 1, 12));

        table.setModel(tabelaModel(ListaEditFornecedor));
        masterScrollPane.setViewportView(table);

        tabPanel.addTab("Lista de Fornecedores", masterScrollPane);

        jButton1.setText("Exportar");
        jButton1.setToolTipText("Exportar dados");
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jButton1) {
                BuscaFornecedorView.this.jButton1ActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Fornecedor fornecedor = ListaEditFornecedor.get(table.getSelectedRow());
ComprasView.fornecedorImportado = fornecedor;
ComprasView.setTxtFornecedor(fornecedor.getNome());
frame.dispose();
}//GEN-LAST:event_jButton1ActionPerformed
    @SuppressWarnings("unchecked")
    int cont = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable table;
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
//            java.util.logging.Logger.getLogger(BuscaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BuscaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BuscaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BuscaFornecedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                frame = new JFrame();
                frame.setContentPane(new BuscaFornecedorView());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                //          frame.setTitle(args[0]);
            }
        });
    }
   

    public TableModel tabelaModel(List<Fornecedor> listaFornecedor) {
        int n = 0;
        JTable table1;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        listaFornecedor = fornecedorDAO.listarTodosFornecedores();
        Object[][] data = new Object[listaFornecedor.size()][16];
        String[] columnNames = {"Cod. Fornecedor", "Nome", "CNPJ", "email", "Fax", "Fone", "Logradouro", "Bairro", "Cidade", "UF", "CEP", "Nº", "País", "CPF", "tipo", "Complemento"};

        for (Fornecedor fornecedor : listaFornecedor) {
            data[n][0] = fornecedor.getCodFornecedor();
            data[n][1] = fornecedor.getNome();
            data[n][2] = fornecedor.getCnpj();
            data[n][3] = fornecedor.getEmail();
            data[n][4] = fornecedor.getFax();
            data[n][5] = fornecedor.getFoneFornecedor();
            data[n][6] = fornecedor.getLogradouro();
            data[n][7] = fornecedor.getBairro();
            data[n][8] = fornecedor.getCidade();
            data[n][9] = fornecedor.getUf();
            data[n][10] = fornecedor.getCep();
            data[n][11] = fornecedor.getNumero();
            data[n][12] = fornecedor.getPais();
            data[n][13] = fornecedor.getCpf();
            data[n][14] = fornecedor.getTipo();
            data[n][15] = fornecedor.getComplemento();

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

    public void editarLinha() {


        int index = table.getSelectedRow();
        System.out.println(index);
//{"Cod. Fornecedor", "Nome", "CNPJ", "email", "Fax", "Fone", "Logradouro", "Bairro", "Cidade", 
//"UF", "CEP", "Nº", "País", "CPF", "tipo","Complemento"};
//        nomeFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 1));
//        cnpjFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 2));
//        emailFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 3));
//        faxFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 4));
//        foneFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 5));
//        logradouroFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 6));
//        bairroFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 7));
//        cidadeFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 8));
//        ufFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 9));
//        cepFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 10));
//        numeroFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 11));
//        paisFornecedorField.setText((String) table.getValueAt(table.getSelectedRow(), 12));
//        cpfFornecedorFileld.setText((String) table.getValueAt(table.getSelectedRow(), 13));
//        if (((String) table.getValueAt(table.getSelectedRow(), 14)).equals("Física")) {
//            tipoComBox.setSelectedIndex(1);
//            cnpjFornecedorLabel.setVisible(false);
//            cnpjFornecedorField.setVisible(false);
//        } else if (((String) table.getValueAt(table.getSelectedRow(), 14)).equals("Jurídica")) {
//            tipoComBox.setSelectedIndex(2);
//            cpfFornecedorFileld.setVisible(false);
//            cpfLabel.setVisible(false);
//        }
//        txtComplemento.setText((String) table.getValueAt(table.getSelectedRow(), 15));

    }
}