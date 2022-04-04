/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

    
/**
 *SHA-1

O Secure Hash Algoritmo, uma função de espalhamento unidirecional inventada 
 * pela NSA, gera um valor hash de 160 bits, a partir de um tamanho arbitrário 
 * de mensagem. O funcionamento interno do SHA-1 é muito parecido com o observado 
 * no MD4, indicando que os estudiosos da NSA basearam-se no MD4 e fizeram melhorias 
 * em sua segurança. De fato, a fraqueza existente em parte do MD5, citada 
 * anteriormente, descoberta após o SHA-1 ter sido proposto, não ocorre no SHA-1. 
 * Atualmente, não há nenhum ataque de criptoanálise conhecido contra o SHA-1. 
 * Mesmo o ataque da força bruta torna-se impraticável, devido ao seu valor hash 
 * de 160 bits. Porém, não há provas de que, no futuro, alguém não possa descobrir 
 * como quebrar o SHA-1.
 * @author Infortec
 */
public class MecanicaCriptografaUtil {
   
	 private static MecanicaCriptografaUtil instance;
	 public MecanicaCriptografaUtil(){}
	 
	//Padrao Singleton, para garantir apenas uma instancia dessa classe.
	 public static MecanicaCriptografaUtil getInstance(){
	 if(instance==null){
	 instance = new MecanicaCriptografaUtil();
	 }
	 return instance;
	 }
	 
	 //A Funcao
	 public String criptografaSenha(String senha) throws NoSuchAlgorithmException{
	 
	 //Essa classe pega um valor de tamanho arbitrario e transforma em um valor de tamanho fixo
	 MessageDigest md = MessageDigest.getInstance( "SHA" );
	 
	//Atualiza o valor com os bytes especificados
	 md.update( senha.getBytes() );
	//Conclui o cálculo de hash realizando operações finais, tais como  preenchimento.
	 BigInteger hash = new BigInteger( 1, md.digest() );
	//Retorna a representação String decimal deste BigInteger, com tamanho igual a 16.
	 String retornaSenha = hash.toString( 16 );
	 return retornaSenha;
	 }
	}

