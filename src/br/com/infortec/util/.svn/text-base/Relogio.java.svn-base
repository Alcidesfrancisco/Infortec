/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.util;

/**
 *
 * @author CIDA
 */
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Relogio extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel painelPrincipal = null;
    private JLabel lblHora = null;
    private JLabel by = null;

    /** 
     * @param args 
     */
    public static void main(String[] args) {
        Relogio app = new Relogio();
        app.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    /** 
     * @param owner 
     */
    public Relogio() {
        super();
        initialize();
    }

    /** 
     * This method initializes this 
     *  
     * @return void 
     */
    private void initialize() {
        this.setBounds(200, 200, 300, 200);
        this.setTitle("...:: Hora Certa ::...");
        this.setContentPane(getPainelPrincipal());
        this.setVisible(true);

        horaCerta();
    }

    /** 
     * This method initializes jContentPane 
     *  
     * @return javax.swing.JPanel 
     */
    private JPanel getPainelPrincipal() {
        if (painelPrincipal == null) {
            by = new JLabel();
            by.setBounds(new Rectangle(179, 141, 94, 22));
            by.setText("by cidinha");  
            lblHora = new JLabel();
            lblHora.setBounds(new Rectangle(103, 63, 115, 33));
            lblHora.setFont(new Font("Dialog", Font.BOLD, 24));
            lblHora.setText("");
            painelPrincipal = new JPanel();
            painelPrincipal.setLayout(null);
            painelPrincipal.add(lblHora, null);
            painelPrincipal.add(by, null);
        }
        return painelPrincipal;
    }

    public void horaCerta() {
        while (true) {
            GregorianCalendar calendario = new GregorianCalendar();
            int hr = calendario.get(Calendar.HOUR_OF_DAY);
            int min = calendario.get(Calendar.MINUTE);
            int sec = calendario.get(Calendar.SECOND);

            String hora2 =
                    ((hr < 10) ? "0" : "")
                    + hr
                    + ":"
                    + ((min < 10) ? "0" : "")
                    + min
                    + ":"
                    + ((sec < 10) ? "0" : "")
                    + sec;


            lblHora.setText(hora2);

        }
    }
}
