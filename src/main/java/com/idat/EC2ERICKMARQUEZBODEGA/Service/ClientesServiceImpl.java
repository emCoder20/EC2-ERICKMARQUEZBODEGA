package com.idat.EC2ERICKMARQUEZBODEGA.Service;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Model.Clientes;
import com.idat.EC2ERICKMARQUEZBODEGA.Repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private IClientesRepository repository;

    @Override
    public void guardarCliente(ClientesRequest Cliente) {

        Clientes p = new Clientes();
        p.setIdCliente(Cliente.getIdCliente());
        p.setDireccion(p.getDireccion());
        p.setDni(p.getDni());

        repository.save(p);
    }

    @Override
    public void actualizarCliente(ClientesRequest Cliente) {
        // TODO Auto-generated method stub

        Clientes p = new Clientes();
        p.setIdCliente(Cliente.getIdCliente());
        p.setNombres(Cliente.getNombres());
        p.setDireccion(p.getDireccion());
        p.setDni(p.getDni());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarCliente(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<ClientesResponse> listarClientes() {

        List<ClientesResponse> listar = new ArrayList<>();

        ClientesResponse dto = null;

        List<Clientes> p = repository.findAll();

        for (Clientes Clientes : p) {

            dto = new ClientesResponse();

            dto.setDni(Clientes.getDni());
            dto.setDireccion(Clientes.getDireccion());
            dto.setNombres(Clientes.getNombres());
            dto.setIdCliente(Clientes.getIdCliente());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public ClientesResponse obtenerClienteId(Integer id) {
        // TODO Auto-generated method stub

        Clientes Clientes = repository.findById(id).orElse(null);
        ClientesResponse dto = new ClientesResponse();

        dto.setDni(Clientes.getDni());
        dto.setDireccion(Clientes.getDireccion());
        dto.setNombres(Clientes.getNombres());
        dto.setIdCliente(Clientes.getIdCliente());

        return dto;
    }

}
