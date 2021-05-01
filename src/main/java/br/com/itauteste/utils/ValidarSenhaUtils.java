package br.com.itauteste.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidarSenhaUtils {

    private static String NOVE_OU_MAIS_CARACTERS = "[A-Za-z\\d@$!%*#&^()-+]{9,}$";
    private static String AO_MENOS_UM_DIGITO= "^(?=.*?[0-9]).*$";
    private static String AO_MENOS_UMA_LETRA_MAIUSCULA= "^(?=.*[A-Z]).*$";
    private static String AO_MENOS_UMA_LETRA_MINUSCULA= "^(?=.*[a-z]).*$";
    private static String AO_MENOS_UM_CARACTER_ESPECIAL= "^(?=.*?[#?!@$%^&*-]).*$";

    private ValidarSenhaUtils(){
    }

    public static boolean validar(String senha){

        List<String> expresssoes = new ArrayList<>();
        expresssoes.add(NOVE_OU_MAIS_CARACTERS);
        expresssoes.add(AO_MENOS_UM_DIGITO);
        expresssoes.add(AO_MENOS_UMA_LETRA_MAIUSCULA);
        expresssoes.add(AO_MENOS_UMA_LETRA_MINUSCULA);
        expresssoes.add(AO_MENOS_UM_CARACTER_ESPECIAL);

        return expressaoRegular(expresssoes, senha);

    }

    public static boolean expressaoRegular(List<String> expressoes, String senha){

        return (!expressoes.stream().anyMatch(e -> !Pattern.compile(e).matcher(senha).matches()))
                && verificaSecaracterRepetido(senha);
    }

    public static boolean verificaSecaracterRepetido(String senha){

        return !(senha.toLowerCase().length()
                != senha.toLowerCase().chars().distinct().count());
    }
}