/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infortec;

import br.com.infortec.view.MenuView;

import ch.randelshofer.quaqua.tiger.Quaqua14TigerCrossPlatformLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author projeto
 */
public class Infortec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
//            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        aplicarLookAndFell(new Quaqua14TigerCrossPlatformLookAndFeel());

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    public static void aplicarLookAndFell(LookAndFeel LAF) {
        try {
            UIManager.setLookAndFeel(LAF);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Infortec.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void look() {
        // updateComponentTreeUI();
        // SwingUtilities.updateComponentTreeUI(MenuView);
    }
}