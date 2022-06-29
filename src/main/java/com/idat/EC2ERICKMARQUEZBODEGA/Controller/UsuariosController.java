package com.idat.EC2ERICKMARQUEZBODEGA.Controller;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Security.JWTUtil;
import com.idat.EC2ERICKMARQUEZBODEGA.Security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuariosController {

    @Autowired
    private JWTUtil util;

    @Autowired
    private UserDetailService service;


    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuariosRequest request){

        UserDetails user = service.loadUserByUsername(request.getUsuario());
        return ResponseEntity.ok(new UsuariosResponse(util.generateToken(user.getUsername())));

    }


}
