package br.com.itautest.services;

import br.com.itautest.exceptions.ValidateException;
import br.com.itautest.exceptions.MessageExceptionEnum;
import br.com.itautest.models.Password;
import br.com.itautest.services.utils.ValidatePasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatePasswordService {

    @Autowired
    private ValidatePasswordUtils utils;

    public Boolean validate(Password password) {

        boolean result = false;

        try {

            result = utils.isValid(password.getPassword());

        }catch (Exception e){

            throw new ValidateException(MessageExceptionEnum.MSG_ERROR_GENERIC);
        }

        return result;
    }

}
