package com.idat.EC2ERICKMARQUEZBODEGA.Service;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.BodegasResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Model.Bodegas;
import com.idat.EC2ERICKMARQUEZBODEGA.Repository.IBodegasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodegasServiceImpl implements BodegasService {


    @Autowired
    private IBodegasRepository repository;

    @Override
    public void guardarBodega(BodegasRequest Bodega) {

        Bodegas p = new Bodegas();
        p.setIdBodega(Bodega.getIdBodega());
        p.setDireccion(p.getDireccion());

        repository.save(p);
    }

    @Override
    public void actualizarBodega(BodegasRequest Bodega) {
        // TODO Auto-generated method stub

        Bodegas p = new Bodegas();
        p.setIdBodega(Bodega.getIdBodega());
        p.setNombre(Bodega.getNombre());
        p.setDireccion(p.getDireccion());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarBodega(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<BodegasResponse> listarBodegas() {

        List<BodegasResponse> listar = new ArrayList<>();

        BodegasResponse dto = null;

        List<Bodegas> p = repository.findAll();

        for (Bodegas Bodegas : p) {

            dto = new BodegasResponse();

            dto.setDireccion(Bodegas.getDireccion());
            dto.setNombre(Bodegas.getNombre());
            dto.setIdBodega(Bodegas.getIdBodega());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public BodegasResponse obtenerBodegaId(Integer id) {
        // TODO Auto-generated method stub

        Bodegas Bodegas = repository.findById(id).orElse(null);
        BodegasResponse dto = new BodegasResponse();

        dto.setDireccion(Bodegas.getDireccion());
        dto.setNombre(Bodegas.getNombre());
        dto.setIdBodega(Bodegas.getIdBodega());

        return dto;
    }


}
