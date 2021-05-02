package br.com.itautest.controllers;

import br.com.itautest.exceptions.ValidateException;
import br.com.itautest.models.Password;
import br.com.itautest.services.ValidatePasswordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PasswordControllerTest {

    @Mock
    private ValidatePasswordService validatePasswordService;

    @InjectMocks
    private PasswordController passwordController;

    @Test
    public void validatePassword(){

        Password password = new Password();
        password.setPassword("fdf");

        ResponseEntity<Boolean> result = passwordController.verificaValidadeSenha(password);
        verify(validatePasswordService,times(1)).validate(password);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}
