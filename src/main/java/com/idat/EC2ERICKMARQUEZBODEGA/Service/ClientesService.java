package com.idat.EC2ERICKMARQUEZBODEGA.Service;

import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.ClientesResponse;

import java.util.List;

public interface ClientesService {

    void guardarCliente(ClientesRequest cliente);
    void actualizarCliente(ClientesRequest cliente);
    void eliminarCliente(Integer id);
    List<ClientesResponse> listarClientes();
    ClientesResponse obtenerClienteId(Integer id);
    
}
