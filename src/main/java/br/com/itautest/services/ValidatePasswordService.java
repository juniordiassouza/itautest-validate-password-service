package br.com.itautest.services;

import br.com.itautest.models.Password;
import br.com.itautest.utils.ValidatePasswordUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatePasswordService {

    public Boolean validate(Password password) {

        return ValidatePasswordUtils.isValid(password.getPassword());
    }

}
