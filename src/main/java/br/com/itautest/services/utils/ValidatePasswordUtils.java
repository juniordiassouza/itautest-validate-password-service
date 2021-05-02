package br.com.itautest.services.utils;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ValidatePasswordUtils {

    private static String NINE_OR_MORE_CHARACTERS = "[A-Za-z\\d@$!%*#&^()-+]{9,}$";
    private static String AT_LEAST_ONE_DIGIT = "^(?=.*?[0-9]).*$";
    private static String AT_LEAST_ONE_CAPITAL_LETTER = "^(?=.*[A-Z]).*$";
    private static String AT_LEAST_ONE_LOWER_LETTER = "^(?=.*[a-z]).*$";
    private static String AT_LEAST_ONE_SPECIAL_CHARACTER = "^(?=.*?[#?!@$%^&*-]).*$";

    private ValidatePasswordUtils(){
    }

    public Boolean isValid(String password){

        List<String> expressions = new ArrayList<>();
        expressions.add(NINE_OR_MORE_CHARACTERS);
        expressions.add(AT_LEAST_ONE_DIGIT);
        expressions.add(AT_LEAST_ONE_CAPITAL_LETTER);
        expressions.add(AT_LEAST_ONE_LOWER_LETTER);
        expressions.add(AT_LEAST_ONE_SPECIAL_CHARACTER);

        return isValidatePasswordRegularExpression(expressions, password)
                && isRepeatedCharacter(password);

    }

    public Boolean isValidatePasswordRegularExpression(List<String> expressions, String password){

        return (!expressions.stream().anyMatch(e -> !Pattern.compile(e).matcher(password).matches()));
    }

    public Boolean isRepeatedCharacter(String password){

        return !(password.toLowerCase().length()
                != password.toLowerCase().chars().distinct().count());
    }
}