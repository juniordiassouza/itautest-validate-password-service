package br.com.itautest.services;

import br.com.itautest.exceptions.ValidateException;
import br.com.itautest.exceptions.MessageExceptionEnum;
import br.com.itautest.models.Password;
import br.com.itautest.utils.ValidatePasswordUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatePasswordService {

    public Boolean validate(Password password) {

        boolean result = false;

        try {

            result = ValidatePasswordUtils.isValid(password.getPassword());

        }catch (Exception e){

            throw new ValidateException(MessageExceptionEnum.MSG_ERROR_GENERIC);
        }

        return result;
    }

}
