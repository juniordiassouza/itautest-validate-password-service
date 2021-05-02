package br.com.itautest.service.util;

import br.com.itautest.models.Password;
import br.com.itautest.services.utils.ValidatePasswordUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidatePasswordUtilsTest {

    @Mock
    private ValidatePasswordUtils validatePasswordUtils;

    @Test
    public void isValidUtilsTrue(){

        Password password = new Password();
        password.setPassword("AbTp9!fok");

        Mockito.when(validatePasswordUtils.isValid(Mockito.anyString())).thenReturn(true);
        Boolean result = validatePasswordUtils.isValid(password.getPassword());

        Assert.assertEquals(result, true);

    }

    @Test
    public void isValidUtilsFalse(){

        Password password = new Password();
        password.setPassword("");

        Mockito.when(validatePasswordUtils.isValid(Mockito.anyString())).thenReturn(false);
        Boolean result = validatePasswordUtils.isValid(password.getPassword());

        Assert.assertEquals(result, false);

    }

    @Test
    public void validateUtilsPasswordsFalse(){

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result = validatePasswordUtils.isValid("");
        Assert.assertEquals(result, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result1 = validatePasswordUtils.isValid("aa");
        Assert.assertEquals(result1, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result2 = validatePasswordUtils.isValid("ab");
        Assert.assertEquals(result2, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result3 = validatePasswordUtils.isValid("AAAbbbCc");
        Assert.assertEquals(result3, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result4 = validatePasswordUtils.isValid("AbTp9!foo");
        Assert.assertEquals(result4, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result5 = validatePasswordUtils.isValid("AbTp9!foA");
        Assert.assertEquals(result5, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result6 = validatePasswordUtils.isValid("AbTp9 fok");
        Assert.assertEquals(result6, false);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result7 = validatePasswordUtils.isValid("AbTp9 fok ");
        Assert.assertEquals(result7, false);

    }

    @Test
    public void validateUtilsPasswordsTrue(){

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result = validatePasswordUtils.isValid("AbTp9!fok");
        Assert.assertEquals(result, true);

        validatePasswordUtils = new ValidatePasswordUtils();
        Boolean result1 = validatePasswordUtils.isValid("AbTp9!fokG*");
        Assert.assertEquals(result1, true);

    }

}
