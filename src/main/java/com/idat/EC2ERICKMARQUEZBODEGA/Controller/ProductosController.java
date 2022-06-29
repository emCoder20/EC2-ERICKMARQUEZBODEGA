package com.idat.EC2ERICKMARQUEZBODEGA.Controller;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( path = "/productos/v1")
public class ProductosController {

    @Autowired
    private ProductosService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<ProductosResponse>> listar() {

        return new ResponseEntity<List<ProductosResponse>>(service.listarProductos(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody ProductosRequest productos) {
        service.guardarProducto(productos);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ProductosResponse p =service.obtenerProductoId(id);
        if(p != null) {
            service.eliminarProducto(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody ProductosRequest productos) {
        ProductosResponse p =service.obtenerProductoId(productos.getIdProducto());
        if(p != null) {
            service.actualizarProducto(productos);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductosResponse> obtenerId(@PathVariable Integer id) {
        ProductosResponse p =service.obtenerProductoId(id);
        if(p != null) {
            return  new ResponseEntity<ProductosResponse>(service.obtenerProductoId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ProductosResponse>(HttpStatus.NOT_FOUND);
    }

}
