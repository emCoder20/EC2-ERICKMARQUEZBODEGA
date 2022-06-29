package com.idat.EC2ERICKMARQUEZBODEGA.Controller;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( path = "/clientes/v1")
public class ClientesController {

    @Autowired
    private ClientesService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<ClientesResponse>> listar() {

        return new ResponseEntity<List<ClientesResponse>>(service.listarClientes(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody ClientesRequest Clientes) {
        service.guardarCliente(Clientes);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ClientesResponse p =service.obtenerClienteId(id);
        if(p != null) {
            service.eliminarCliente(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ClientesRequest Clientes) {
        ClientesResponse p =service.obtenerClienteId(Clientes.getIdCliente());
        if(p != null) {
            service.actualizarCliente(Clientes);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientesResponse> obtenerId(@PathVariable Integer id) {
        ClientesResponse p =service.obtenerClienteId(id);
        if(p != null) {
            return  new ResponseEntity<ClientesResponse>(service.obtenerClienteId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ClientesResponse>(HttpStatus.NOT_FOUND);
    }


}
