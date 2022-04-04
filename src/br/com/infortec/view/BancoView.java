/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BancoView.java
 *
 * Created on 28/11/2011, 19:25:33
 */
package br.com.infortec.view;

import br.com.infortec.DAO.BancoDAO;
import br.com.infortec.bean.Banco;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Infortec
 */
public class BancoView extends javax.swing.JFrame {

    /** Creates new form BancoView */
    public BancoView() {
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
        jLabel6 = new javax.swing.JLabel();
        txtGerente = new javax.swing.JTextField();
        txtConta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        jPanel3 = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        bordaErro = new javax.swing.JTextField();
        borbaOk = new javax.swing.JTextField();
        toolTip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Conta:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Fone:");

        txtGerente.setEnabled(false);
        txtGerente.setToolTipText("Informe o nome do gerente");
        txtGerente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGerenteFocusGained(evt);
            }
        });

        txtConta.setEnabled(false);
        txtConta.setToolTipText("Informe o número da conta");
        txtConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContaFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Observações:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Gerente:");

        txtObs.setEnabled(false);
        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtObs.setRows(5);
        txtObs.setToolTipText("Observações adicionais ");
        txtObs.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtObs);

        txtNome.setEnabled(false);
        txtNome.setToolTipText("Informe o nome do banco");
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Nome do Banco:");

        txtAgencia.setEnabled(false);
        txtAgencia.setToolTipText("Informe os dígitos da agência");
        txtAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgenciaActionPerformed(evt);
            }
        });
        txtAgencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAgenciaFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Agência:");

        txtFone.setEnabled(false);
        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFone.setToolTipText("Informe um telefone para contato");
        txtFone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFoneFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtAgencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFone, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtConta, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(314, 314, 314)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(tabelaModel(listaEditaBanco));
        jScrollPane1.setViewportView(table);

        btEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        btEditar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btEditarFocusGained(evt);
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
        btCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btCancelarFocusGained(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infortec/imagens/salvar32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar dados");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        btSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btSalvarFocusGained(evt);
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
        btExcluir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btExcluirFocusGained(evt);
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
        btInserir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btInserirFocusGained(evt);
            }
        });

        bordaErro.setVisible(false);
        bordaErro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 102)));

        borbaOk.setVisible(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btInserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borbaOk, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bordaErro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEditar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bordaErro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(borbaOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInserir)
                    .addComponent(btExcluir)
                    .addComponent(btCancelar)
                    .addComponent(btSalvar)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        toolTip.setText("tooltip");
        toolTip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                toolTipFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(toolTip))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int cont = 0;
    BancoDAO bancoDAO = new BancoDAO();
    static BancoView bv;
    List<Banco> listaEditaBanco = bancoDAO.listarTodosBancos();
private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if (cont % 2 == 0) {      //editar linha
        txtNome.setEnabled(true);
        txtAgencia.setEnabled(true);
        txtConta.setEnabled(true);
        txtFone.setEnabled(true);
        txtGerente.setEnabled(true);
        txtObs.setEnabled(true);
        btEditar.setText("Cancelar Edição");
        cont++;
        editarLinha();

    } else {                //cancelar edição
        txtNome.setEnabled(false);
        txtAgencia.setEnabled(false);
        txtConta.setEnabled(false);
        txtFone.setEnabled(false);
        txtGerente.setEnabled(false);
        txtObs.setEnabled(false);
        txtNome.requestFocus();
        txtNome.setText("");
        txtAgencia.setText("");
        txtConta.setText("");
        txtFone.setText("");
        txtGerente.setText("");
        btEditar.setText("Editar");
        cont++;
    }
}//GEN-LAST:event_btEditarActionPerformed

private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed

    cont = 0;
    txtNome.setText("");
    txtAgencia.setText("");
    txtConta.setText("");
    txtFone.setText("");
    txtGerente.setText("");
    txtObs.setBorder(borbaOk.getBorder());
    txtNome.setBorder(borbaOk.getBorder());
    txtAgencia.setBorder(borbaOk.getBorder());
    txtConta.setBorder(borbaOk.getBorder());
    txtFone.setBorder(borbaOk.getBorder());
    txtGerente.setBorder(borbaOk.getBorder());
    txtObs.setBorder(borbaOk.getBorder());


    txtAgencia.setEnabled(true);
    txtConta.setEnabled(true);
    txtFone.setEnabled(true);
    txtGerente.setEnabled(true);
    txtNome.setEnabled(true);
    txtObs.setEnabled(true);
    txtNome.requestFocus();

    table.setModel(tabelaModel(listaEditaBanco));
    int row = listaEditaBanco.size() - 1;
    table.scrollRectToVisible(table.getCellRect(row, 0, true));
}//GEN-LAST:event_btInserirActionPerformed

private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    int indexExcluir = table.getSelectedRow();

    Banco excluirBanco = listaEditaBanco.get(indexExcluir);
    int excluido = bancoDAO.excluirBanco(excluirBanco.getCodBanco());
    listaEditaBanco = bancoDAO.listarTodosBancos();
    table.setModel(tabelaModel(listaEditaBanco));

    txtNome.setText("");
    txtAgencia.setText("");
    txtConta.setText("");
    txtFone.setText("");
    txtGerente.setText("");
    txtObs.setText("");

    txtAgencia.setEnabled(false);
    txtConta.setEnabled(false);
    txtFone.setEnabled(false);
    txtGerente.setEnabled(false);
    txtNome.setEnabled(false);
    txtObs.setEnabled(false);

}//GEN-LAST:event_btExcluirActionPerformed

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    if (txtNome.getText().length() > 50) {
        JOptionPane.showMessageDialog(null, "O nome do Banco Deve ter até 50 caracteres");
        txtNome.requestFocus();
        txtNome.setBorder(bordaErro.getBorder());
    } else if (txtAgencia.getText().length() > 10) {
        JOptionPane.showMessageDialog(null, "O número da Agência deve ter até 10 caracteres");
        txtAgencia.requestFocus();
        txtAgencia.setBorder(bordaErro.getBorder());
    } else if (txtConta.getText().length() > 10) {
        JOptionPane.showMessageDialog(null, "O número da Conta deve ter até 10 caracteres");
        txtConta.requestFocus();
        txtConta.setBorder(bordaErro.getBorder());
    } else if (txtGerente.getText().length() > 50) {
        JOptionPane.showMessageDialog(null, "O Nome do Gerente deve ter até 50 caracteres");
        txtGerente.requestFocus();
        txtGerente.setBorder(bordaErro.getBorder());
    } else if (txtObs.getText().length() > 256) {
        JOptionPane.showMessageDialog(null, "O número do telefone ter até 10 caracteres");
        txtObs.requestFocus();
        txtObs.setBorder(bordaErro.getBorder());
    } else if (cont % 2 == 0) {
        String nome = txtNome.getText();
        String agencia = txtAgencia.getText();
        String conta = txtConta.getText();
        String gerente = txtGerente.getText();
        String fone = txtFone.getText();
        String obs = txtObs.getText();

        Banco banco = new Banco(nome, agencia, conta, gerente, fone, obs);
        int idBanco = bancoDAO.inserirBanco(banco);
        listaEditaBanco.add(banco);
        table.setModel(tabelaModel(listaEditaBanco));
        int row = table.getRowCount() - 1;
        if (table.getRowCount() >= 1) {
            table.setRowSelectionInterval(row, row);
        }
        table.scrollRectToVisible(table.getCellRect(row, 0, true));

        txtNome.setText("");
        txtAgencia.setText("");
        txtConta.setText("");
        txtFone.setText("");
        txtGerente.setText("");
        txtObs.setText("");
        txtObs.setBorder(borbaOk.getBorder());
        txtNome.setBorder(borbaOk.getBorder());
        txtAgencia.setBorder(borbaOk.getBorder());
        txtConta.setBorder(borbaOk.getBorder());
        txtFone.setBorder(borbaOk.getBorder());
        txtGerente.setBorder(borbaOk.getBorder());
        txtObs.setBorder(borbaOk.getBorder());
    } else {

        String alterNome = txtNome.getText();
        String alterAgencia = txtAgencia.getText();
        String alterConta = txtConta.getText();
        String alterGerente = txtGerente.getText();
        String alterFone = txtFone.getText();
        String alterObs = txtObs.getText();

        Banco bancoAlterar = listaEditaBanco.get(table.getSelectedRow());

        bancoAlterar.setAgencia(alterAgencia);
        bancoAlterar.setConta(alterConta);
        bancoAlterar.setFone(alterFone);
        bancoAlterar.setGerente(alterGerente);
        bancoAlterar.setNome(alterNome);
        bancoAlterar.setObs(alterObs);

        bancoDAO.alteraBanco(bancoAlterar, bancoAlterar.getCodBanco());
        listaEditaBanco.add(bancoAlterar);
        table.setModel(tabelaModel(listaEditaBanco));

        txtNome.setText("");
        txtAgencia.setText("");
        txtConta.setText("");
        txtFone.setText("");
        txtGerente.setText("");
        txtObs.setText("");
        txtObs.setBorder(borbaOk.getBorder());
        txtNome.setBorder(borbaOk.getBorder());
        txtAgencia.setBorder(borbaOk.getBorder());
        txtConta.setBorder(borbaOk.getBorder());
        txtFone.setBorder(borbaOk.getBorder());
        txtGerente.setBorder(borbaOk.getBorder());
        txtObs.setBorder(borbaOk.getBorder());
    }
}//GEN-LAST:event_btSalvarActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    bv.dispose();
}//GEN-LAST:event_btCancelarActionPerformed

private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
}//GEN-LAST:event_txtNomeFocusLost

    private void txtAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgenciaActionPerformed

    private void toolTipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toolTipFocusGained
    }//GEN-LAST:event_toolTipFocusGained

    private void txtAgenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAgenciaFocusGained

        toolTip.setText(txtAgencia.getToolTipText());


    }//GEN-LAST:event_txtAgenciaFocusGained

    private void txtContaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContaFocusGained
        toolTip.setText(txtConta.getToolTipText());
    }//GEN-LAST:event_txtContaFocusGained

    private void txtGerenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGerenteFocusGained
        // TODO add your handling code here:
        toolTip.setText(txtGerente.getToolTipText());
    }//GEN-LAST:event_txtGerenteFocusGained

    private void btEditarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btEditarFocusGained
        // TODO add your handling code here:
         toolTip.setText(btEditar.getToolTipText());
    }//GEN-LAST:event_btEditarFocusGained

    private void btInserirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btInserirFocusGained
        // TODO add your handling code here
        toolTip.setText(btInserir.getToolTipText());
    }//GEN-LAST:event_btInserirFocusGained

    private void btExcluirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btExcluirFocusGained
        // TODO add your handling code here:
        toolTip.setText(btExcluir.getToolTipText());
    }//GEN-LAST:event_btExcluirFocusGained

    private void btCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btCancelarFocusGained
        // TODO add your handling code here:
        toolTip.setText(btCancelar.getToolTipText());
    }//GEN-LAST:event_btCancelarFocusGained

    private void btSalvarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btSalvarFocusGained
        // TODO add your handling code here:
        toolTip.setText(btSalvar.getToolTipText());
    }//GEN-LAST:event_btSalvarFocusGained

    private void txtFoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFoneFocusGained
        // TODO add your handling code here:
        toolTip.setText(txtFone.getToolTipText());
    }//GEN-LAST:event_txtFoneFocusGained

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
//            java.util.logging.Logger.getLogger(BancoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BancoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BancoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BancoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new BancoView().setVisible(true);
                bv = new BancoView();
                bv.setDefaultCloseOperation(bv.DISPOSE_ON_CLOSE);
                bv.setResizable(false);
                bv.pack();
                bv.setVisible(true);
                //bv.setTitle(args[0]);
                bv.setLocationRelativeTo(null);
                bv.setSize(520, 570);
            }
        });
    }

    public TableModel tabelaModel(List<Banco> listaBanco) {
        int n = 0;
        JTable table1;
        listaBanco = bancoDAO.listarTodosBancos();
        Object[][] data = new Object[listaBanco.size()][7];
        String[] columnNames = {"cod Banco", "Nome", "Agência", "Conta", "Gerente", "Fone", "Observações"};

        for (Banco Bancos : listaBanco) {
            data[n][0] = Bancos.getCodBanco();
            data[n][1] = Bancos.getNome();
            data[n][2] = Bancos.getAgencia();
            data[n][3] = Bancos.getConta();
            data[n][4] = Bancos.getGerente();
            data[n][5] = Bancos.getFone();
            data[n][6] = Bancos.getObs();

            n++;
        }

        table1 = new JTable(data, columnNames);
        table1.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table1.setFillsViewportHeight(true);
        table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(150);
        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
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

    public void editarLinha() {


        //   int index = table.getSelectedRow();


        txtNome.setText((String) table.getValueAt(table.getSelectedRow(), 1));
        txtAgencia.setText((String) table.getValueAt(table.getSelectedRow(), 2));
        txtConta.setText((String) table.getValueAt(table.getSelectedRow(), 3));
        txtFone.setText((String) table.getValueAt(table.getSelectedRow(), 5));
        txtGerente.setText((String) table.getValueAt(table.getSelectedRow(), 4));
        txtObs.setText((String) table.getValueAt(table.getSelectedRow(), 6));

//        txtDescricao.setText((String) table.getValueAt(table.getSelectedRow(), 2));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField borbaOk;
    private javax.swing.JTextField bordaErro;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JLabel toolTip;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtConta;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtGerente;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObs;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
