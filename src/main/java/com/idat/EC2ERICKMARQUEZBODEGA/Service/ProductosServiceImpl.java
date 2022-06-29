package com.idat.EC2ERICKMARQUEZBODEGA.Service;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Model.Productos;
import com.idat.EC2ERICKMARQUEZBODEGA.Repository.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private IProductosRepository repository;

    @Override
    public void guardarProducto(ProductosRequest Producto) {

        Productos p = new Productos();
        p.setIdProducto(Producto.getIdProducto());
        p.setProducto(p.getProducto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(p.getPrecio());
        p.setStock(p.getStock());

        repository.save(p);
    }

    @Override
    public void actualizarProducto(ProductosRequest Producto) {
        // TODO Auto-generated method stub

        Productos p = new Productos();
        p.setIdProducto(Producto.getIdProducto());
        p.setProducto(Producto.getProducto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(p.getPrecio());
        p.setStock(p.getStock());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarProducto(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<ProductosResponse> listarProductos() {

        List<ProductosResponse> listar = new ArrayList<>();

        ProductosResponse dto = null;

        List<Productos> p = repository.findAll();

        for (Productos Productos : p) {

            dto = new ProductosResponse();

            dto.setStock(Productos.getStock());
            dto.setPrecio(Productos.getPrecio());
            dto.setDescripcion(Productos.getDescripcion());
            dto.setProducto(Productos.getProducto());
            dto.setIdProducto(Productos.getIdProducto());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public ProductosResponse obtenerProductoId(Integer id) {
        // TODO Auto-generated method stub

        Productos Productos = repository.findById(id).orElse(null);
        ProductosResponse dto = new ProductosResponse();

        dto.setStock(Productos.getStock());
        dto.setPrecio(Productos.getPrecio());
        dto.setDescripcion(Productos.getDescripcion());
        dto.setProducto(Productos.getProducto());
        dto.setIdProducto(Productos.getIdProducto());

        return dto;
    }



}
