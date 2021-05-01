package br.com.itauteste.controllers;

import br.com.itauteste.models.Erro;
import br.com.itauteste.models.Senha;
import br.com.itauteste.services.ValidarSenhaService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Senha")
public class SenhaController implements RestApiController{

    @Autowired
    private static ValidarSenhaService validarSenhaService;

    @ApiOperation(value = "Metodo responsavel por verificar se uma senha está no padrão exigido", nickname = "validarSenha", notes="Senha Para ser validadada", tags = { })
    @ApiResponses(value = {
    @ApiResponse(code= 200, message = "Dados executados com sucesso"),
    @ApiResponse(code= 400, message = "Erro requisição", response = Erro.class),
    @ApiResponse(code= 404, message = "Recurso não encontrado", response = Erro.class),
    @ApiResponse(code= 500, message = "Erro interno", response = Erro.class)
    })
    @RequestMapping(value="/senha", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> verificaValidadeSenha(@ApiParam(value = "Senha", required = true) @Validated @RequestBody Senha senha){

        return returnOk(this.validarSenhaService.validar(senha));
    }


}