package br.com.itauteste.controller;

import br.com.itauteste.models.Senha;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Senha")
public class SenhaController {

    @ApiOperation(value = "Metodo responsavel por verificar se uma senha está no padrão exigido", nickname = "validarSenha", notes="Senha Para ser validadada", tags = { })
    @ApiResponses(value = {
    @ApiResponse(code= 200, message = "Dados consultados com sucesso"),
    @ApiResponse(code= 400, message = "Erro requisição", response = Error.class),
    @ApiResponse(code= 404, message = "Recurso não encontrado", response = Error.class),
    @ApiResponse(code= 500, message = "Erro interno", response = Error.class)
    })
    @RequestMapping(value="/senha", produces = {"application/json"}, method = RequestMethod.POST)
    public Boolean verificaValidadeSenha(@ApiParam(value = "Senha", required = true) @Validated @RequestBody Senha senha){


        return true;
    }


}