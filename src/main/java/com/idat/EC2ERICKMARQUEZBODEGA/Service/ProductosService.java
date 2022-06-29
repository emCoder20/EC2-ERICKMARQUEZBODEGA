package com.idat.EC2ERICKMARQUEZBODEGA.Service;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ProductosResponse;

import java.util.List;

public interface ProductosService {

    void guardarProducto(ProductosRequest producto);
    void actualizarProducto(ProductosRequest producto);
    void eliminarProducto(Integer id);
    List<ProductosResponse> listarProductos();
    ProductosResponse obtenerProductoId(Integer id);
}
