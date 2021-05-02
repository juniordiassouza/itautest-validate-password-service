package br.com.itautest.controllers;


import br.com.itautest.models.Password;
import br.com.itautest.services.ValidatePasswordService;
import br.com.itautest.utils.ValidatePasswordUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ValidatePasswordServiceTest {

    @InjectMocks
    private ValidatePasswordService validatePasswordService;

    @Mock
    private ValidatePasswordUtils validatePasswordUtils;

    @Test
    public void testPasswordService(){

        Password password = new Password();
        password.setPassword("fdf");

        Boolean result = validatePasswordService.validate(password);
        verify(validatePasswordUtils,times(1)).isValid(password.getPassword());

        Assert.assertEquals(result, false);
    }

}
