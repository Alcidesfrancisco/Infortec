/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Infortec
 */
public class DataConverter {
    // Conversao de datas SQL - String
    
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    // Formatação de texto
    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoDate = new SimpleDateFormat("yyyy-MM-dd");

    public Date convertDataString(String strData){
        java.sql.Date formatodate=null;
        try {
            formatodate = new java.sql.Date(fmt.parse(strData).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DataConverter.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "A data Informada é inválida");
        }

        return formatodate;
    }

    public String convertDataDate(Date dtDate){
        String strData = fmt.format(dtDate);

        return strData;
    }       
    
    /*  teste seu metodo    
    
     //Cria uma data do tipo Util(texto)
     java.util.Date dataUtil = new java.util.Date();
     // Cria uma data do tipo sqlDate e atribui um valor do tipo Long
     Date dataSql = new java.sql.Date(dataUtil.getTime());

     //System.out.println(dataSql);         
     
     */
    
    //
}
