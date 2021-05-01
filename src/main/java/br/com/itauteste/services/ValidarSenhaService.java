package br.com.itauteste.services;

import br.com.itauteste.models.Senha;
import br.com.itauteste.utils.ValidarSenhaUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidarSenhaService {

    public Boolean validar(Senha senha) {

        return ValidarSenhaUtils.validar(senha.getSenha());
    }

}
