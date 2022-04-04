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

/**
 *
 * @author Beto
 */
public class Utilitarios {

    public String encriptaSenhaSenha(String encryptSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        // senha a ser encriptada
        encryptSenha = "Alberto";
        
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(encryptSenha.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        
        // senha encriptada
        String senha = hexString.toString();

        return senha;
    }
    
    
    
}
