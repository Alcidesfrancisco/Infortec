/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infortec.util;

/**
 *
 * @author Infortec
 */
public class ValidaCPF_CNPJ {

    /** 
     * Metodo validacaoCPF - Responsavel em validar o CPF 
     *  
     * @return Boolean 
     * @since 29/12/2006 
     */
    public boolean validaCPF(String cpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + (11 - nCount) * digitoCPF;

            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + (12 - nCount) * digitoCPF;
        };

        //Primeiro resto da divisão por 11.  
        resto = (d1 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        //Segundo resto da divisão por 11.  
        resto = (d2 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        //Digito verificador do CPF que está sendo validado.  
        String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        return nDigVerific.equals(nDigResult);
    }

    public boolean validaCPF2(String strCpf) { // formato XXX.XXX.XXX-XX  
        if (!strCpf.substring(0, 1).equals("")) {
            try {
                boolean validado = true;
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;

                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
                    d1 = d1 + (11 - nCount) * digitoCPF;

                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
                    d2 = d2 + (12 - nCount) * digitoCPF;
                };

                //Primeiro resto da divisão por 11.  
                resto = (d1 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                d2 += 2 * digito1;

                //Segundo resto da divisão por 11.  
                resto = (d2 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }

                //Digito verificador do CPF que está sendo validado.  
                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

                //Concatenando o primeiro resto com o segundo.  
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean validaCNPJ(String cnpjNum) {
        int[] cnpj = new int[cnpjNum.length()];
        int resultP = 0;
        int resultS = 0;
        int divP = 0;
        int divS = 0;

        //converte string para um array de integer  
        for (int i = 0; i < cnpjNum.length(); i++) {
            cnpj[i] = Integer.parseInt(cnpjNum.substring(i, i + 1));
        }

        int j = 6;
        //calcula o primeiro div  
        for (int i = 0; i < 12; i++) {
            resultP += cnpj[i] * j;

            j++;
            if (j > 9) {
                j = 2;
            }
        }
        divP = resultP % 11;

        if (divP != cnpj[12]) {
            return false;
        } else {
            j = 5;
            //calcula o segundo div   
            for (int i = 0; i < 13; i++) {
                resultS += cnpj[i] * j;

                j++;
                if (j > 9) {
                    j = 2;
                }
            }
            divS = resultS % 11;

            if (divS != cnpj[13]) {
                return false;
            }
        }
        return true;
    }

    /** 
     * 
     * @author Rodrigo Scorsatto 
     */
    public class ValidaCnpj {

        /** Creates a new instance of ValidaCnpj */
        public ValidaCnpj() {
        }

        public boolean validaCNPJ2(String str_cnpj) {
            if (!str_cnpj.substring(0, 1).equals("")) {
                try {
                    str_cnpj = str_cnpj.replace('.', ' ');
                    str_cnpj = str_cnpj.replace('/', ' ');
                    str_cnpj = str_cnpj.replace('-', ' ');
                    str_cnpj = str_cnpj.replaceAll(" ", "");
                    int soma = 0, aux, dig;
                    String cnpj_calc = str_cnpj.substring(0, 12);

                    if (str_cnpj.length() != 14) {
                        return false;
                    }
                    char[] chr_cnpj = str_cnpj.toCharArray();
                    /* Primeira parte */
                    for (int i = 0; i < 4; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                            soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11)
                            ? "0" : Integer.toString(dig);
                    /* Segunda parte */
                    soma = 0;
                    for (int i = 0; i < 5; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                            soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11)
                            ? "0" : Integer.toString(dig);
                    return str_cnpj.equals(cnpj_calc);
                } catch (Exception e) {
                    System.err.println("Erro !" + e);
                    return false;
                }
            } else {
                return false;
            }

        }
    }
}
