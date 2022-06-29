package com.idat.EC2ERICKMARQUEZBODEGA.Service;

import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasResponse;


import java.util.List;

public interface BodegasService {
    void guardarBodega(BodegasRequest bodega);
    void actualizarBodega(BodegasRequest bodega);
    void eliminarBodega(Integer id);
    List<BodegasResponse> listarBodegas();
    BodegasResponse obtenerBodegaId(Integer id);

}


