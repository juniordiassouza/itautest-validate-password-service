package br.com.itautest.controllers;

import br.com.itautest.models.Password;
import br.com.itautest.services.ValidatePasswordService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Password")
public class PasswordController implements RestApiController{

    @Autowired
    private ValidatePasswordService validadePasswordService;

    @ApiOperation(value = "Method responsible for verifying that a password is in the required standard.", nickname = "validatePassword", notes="Password to be validated", tags = { })
    @ApiResponses(value = {
    @ApiResponse(code= 200, message = "Data successfully executed"),
    @ApiResponse(code= 400, message = "Request error"),
    @ApiResponse(code= 404, message = "Resource not found"),
    @ApiResponse(code= 500, message = "Internal error")
    })
    @RequestMapping(value="/password", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkPasswordValidity(@ApiParam(value = "Password", required = true) @Validated @RequestBody Password password){

        return returnOk(this.validadePasswordService.validate(password));
    }


}