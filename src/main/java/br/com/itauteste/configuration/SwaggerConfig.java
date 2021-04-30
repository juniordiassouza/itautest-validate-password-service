package br.com.itauteste.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // .paths(paths())
                .build().pathMapping("/").directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder().code(500).message("500 message")
                                .responseModel(new ModelRef("Error")).build()));
    }

    private List<ResponseMessage> newArrayList(ResponseMessage error) {

        List<ResponseMessage> retorno = new ArrayList<>();
        retorno.add(error);

        return retorno;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Validador de senha",
                "API responsavel por validar uma senha.",
                "1.0",
                "***",
                new Contact("Junior Oliveira", "***", "junior.dias.souzaa@gmail.com"),
                "***", "****", Collections.emptyList());
    }
}