/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infortec;

/**
 *
 * @author Infortec
 */
    import java.awt.GridLayout;  
    import java.awt.event.ActionEvent;  
    import java.awt.event.ActionListener;  
      
    import javax.swing.*;  
      
    public class SimpleSwing extends JFrame {  
      
       private JButton btn1, btn2;  
      
       public SimpleSwing() {  
          super("Teste");  
          setDefaultCloseOperation(EXIT_ON_CLOSE);  
          setLayout(new GridLayout(2, 1, 5, 5));  
      
          btn1 = new JButton("Faz algo...");  
          btn2 = new JButton("Reiniciar App");  
      
          add(btn1);  
          add(btn2);  
      
          pack();  
          btn1.addActionListener(new ActionListener() {  
      
             public void actionPerformed(ActionEvent arg0) {  
                JOptionPane.showMessageDialog(null, "Uma simples Mensagem!");  
             }  
          });  
            
          btn2.addActionListener(new ActionListener() {  
      
             public void actionPerformed(ActionEvent e) {  
                fechar();  
             }  
          });  
       }  
         
       public void fechar(){  
          SimpleSwing.main(null);  
          this.dispose();  
       }  
      
       public static void main(String[] args) {  
          new SimpleSwing().setVisible(true);  
       }  
    }  
