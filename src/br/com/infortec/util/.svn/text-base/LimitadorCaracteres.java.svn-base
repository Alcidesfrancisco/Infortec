/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Endemias
 */
public class LimitadorCaracteres {
//Limitador do UF
    public static String maxLengthAZ(String entrada, int tamanho) {
        StringBuffer saida = new StringBuffer();
        char[] caracteres = removeCaractersAZ(entrada).toCharArray();
        for (int i = 0; i < caracteres.length && i <= tamanho; i++) {
            saida.append(caracteres[i]);
        }
        return saida.toString();
    }

    public static String removeCaractersAZ(String entrada) {
        Pattern numericos = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher encaixe = numericos.matcher(entrada);
        StringBuffer saida = new StringBuffer();
        while (encaixe.find()) {
            saida.append(encaixe.group());
        }
        return saida.toString();
    }
    
    
    //limitador do Alfanumerico
        public static String maxLengthAZ19(String entrada, int tamanho) {
        StringBuffer saida = new StringBuffer();
        char[] caracteres = removeCaractersAZ19(entrada).toCharArray();
        for (int i = 0; i < caracteres.length && i <= tamanho; i++) {
            saida.append(caracteres[i]);
        }
        return saida.toString();
    }

    public static String removeCaractersAZ19(String entrada) {
        Pattern alfanumericos = Pattern.compile("[0-9-A-Z-Á-É-ô-õ-ç-ê-é-ú]", Pattern.CASE_INSENSITIVE);
        Matcher encaixe = alfanumericos.matcher(entrada);
        StringBuffer saida = new StringBuffer();
        while (encaixe.find()) {
            saida.append(encaixe.group());
        }
        return saida.toString();
    }
    //limitador numerico
           public static String maxLength19(String entrada, int tamanho) {
        StringBuffer saida = new StringBuffer();
        char[] caracteres = removeCaracters19(entrada).toCharArray();
        for (int i = 0; i < caracteres.length && i <= tamanho; i++) {
            saida.append(caracteres[i]);
        }
        return saida.toString();
    }

    public static String removeCaracters19(String entrada) {
        Pattern numericos = Pattern.compile("[0-9--]", Pattern.CASE_INSENSITIVE);
        Matcher encaixe = numericos.matcher(entrada);
        StringBuffer saida = new StringBuffer();
        while (encaixe.find()) {
            saida.append(encaixe.group());
        }
        return saida.toString();
    }
    
    
}
