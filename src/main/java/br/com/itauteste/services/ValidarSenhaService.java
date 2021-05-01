package br.com.itauteste.services;

import br.com.itauteste.models.Senha;
import br.com.itauteste.utils.ValidarSenhaUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidarSenhaService {

    public static Boolean validar(Senha senha){

        Boolean retorno = false;

        if(ValidarSenhaUtils.noveOuMaisCaracters(senha.getSenha())
            && ValidarSenhaUtils.aoMenosUmDigito(senha.getSenha())
                && ValidarSenhaUtils.aoMenosUmaLetraMaiuscula(senha.getSenha())
                    && ValidarSenhaUtils.aoMenosUmaLetraMinuscula(senha.getSenha())
                       && ValidarSenhaUtils.aoMenosUmCaracterEspecial(senha.getSenha())){

            retorno = true;
        }

        return retorno;
    }
}
