package com.idat.EC2ERICKMARQUEZBODEGA.Controller;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Service.BodegasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( path = "/bodegas/v1")
public class BodegasController {
    @Autowired
    private BodegasService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<BodegasResponse>> listar() {

        return new ResponseEntity<List<BodegasResponse>>(service.listarBodegas(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody BodegasRequest Bodegas) {
        service.guardarBodega(Bodegas);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        BodegasResponse p =service.obtenerBodegaId(id);
        if(p != null) {
            service.eliminarBodega(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody BodegasRequest Bodegas) {
        BodegasResponse p =service.obtenerBodegaId(Bodegas.getIdBodega());
        if(p != null) {
            service.actualizarBodega(Bodegas);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<BodegasResponse> obtenerId(@PathVariable Integer id) {
        BodegasResponse p =service.obtenerBodegaId(id);
        if(p != null) {
            return  new ResponseEntity<BodegasResponse>(service.obtenerBodegaId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<BodegasResponse>(HttpStatus.NOT_FOUND);
    }

}
