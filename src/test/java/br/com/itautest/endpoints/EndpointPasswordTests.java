package br.com.itautest.endpoints;

import br.com.itautest.models.Password;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EndpointPasswordTests {

    final String BASE_PATH = "http://localhost:8080/api/validator/v1/password";

    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {

        restTemplate = new RestTemplate();
    }

    @Test
    public void testPasswordFalse() throws JsonProcessingException {

        Password password = new Password();
        password.setPassword("");

        Boolean result = restTemplate.postForObject(BASE_PATH, password, Boolean.class);

        Assert.assertEquals(result,false);
    }

    @Test
    public void testPasswordTrue() throws JsonProcessingException {

        Password password = new Password();
        password.setPassword("AbTp9!fokG*");

        Boolean result = restTemplate.postForObject(BASE_PATH, password, Boolean.class);

        Assert.assertEquals(result,true);
    }

}
