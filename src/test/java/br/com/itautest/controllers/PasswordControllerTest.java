package br.com.itautest.controllers;

import br.com.itautest.models.Password;
import br.com.itautest.services.ValidatePasswordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void validatePasswordOK(){

        Password password = new Password();
        password.setPassword("");

        ResponseEntity<Boolean> result = passwordController.checkPasswordValidity(password);
        verify(validatePasswordService,times(1)).validate(password);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

    @Test(expected = Exception.class)
    public void validatePasswordException(){

        passwordController = new PasswordController();
        passwordController.checkPasswordValidity(null);

    }

    @Test
    public void validatePasswordFalse(){

        Password password = new Password();
        password.setPassword("");

        Mockito.when(validatePasswordService.validate(Mockito.any())).thenReturn(false);
        ResponseEntity<Boolean> result = passwordController.checkPasswordValidity(password);

        Assert.assertEquals(result.getBody(), false);
    }

    @Test
    public void validatePasswordTrue(){

        Password password = new Password();
        password.setPassword("");

        Mockito.when(validatePasswordService.validate(Mockito.any())).thenReturn(true);
        ResponseEntity<Boolean> result = passwordController.checkPasswordValidity(password);

        Assert.assertEquals(result.getBody(), true);
    }
}
