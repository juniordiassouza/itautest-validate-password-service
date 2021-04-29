package br.com.itauteste.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class SenhaController {

    @PutMapping("/validaSenha/{senha}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean verificaValidadeSenha(@PathVariable(value = "senha") String senha){


        return null;
    }


}