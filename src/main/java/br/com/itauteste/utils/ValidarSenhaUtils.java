package br.com.itauteste.utils;

import java.util.regex.Pattern;

public class ValidarSenhaUtils {

    private ValidarSenhaUtils(){
    }

    public static boolean noveOuMaisCaracters(String senha){

        final String noveOuMaisCaracters= "[A-Za-z\\d@$!%*#&^()-+]{9,}$";

        return Pattern.compile(noveOuMaisCaracters).matcher(senha).matches();
    }

    public static boolean aoMenosUmDigito(String senha){

        final String aoMenosUmDigito= "^(?=.*?[0-9]).*$";

        return Pattern.compile(aoMenosUmDigito).matcher(senha).matches();
    }

    public static boolean aoMenosUmaLetraMaiuscula(String senha){

        final String aoMenosUmaLetraMaiuscula= "^(?=.*[A-Z]).*$";

        return Pattern.compile(aoMenosUmaLetraMaiuscula).matcher(senha).matches();
    }

    public static boolean aoMenosUmaLetraMinuscula(String senha){

        final String aoMenosUmaLetraMinuscula= "^(?=.*[a-z]).*$";

        return Pattern.compile(aoMenosUmaLetraMinuscula).matcher(senha).matches();
    }

    public static boolean aoMenosUmCaracterEspecial(String senha){

        final String aoMenosUmCaracterEspecial= "^(?=.*?[#?!@$%^&*-]).*$";

        return Pattern.compile(aoMenosUmCaracterEspecial).matcher(senha).matches();
    }

}
