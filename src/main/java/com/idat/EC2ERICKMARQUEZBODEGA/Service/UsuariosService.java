package com.idat.EC2ERICKMARQUEZBODEGA.Service;

import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Model.Usuarios;

import java.util.List;

public interface UsuariosService {

    void guardarUsuario(UsuariosRequest usuario);
    void actualizarUsuario(UsuariosRequest usuario);
    void eliminarUsuario(Integer id);
    List<UsuariosResponse> listarUsuarios();
    UsuariosResponse obtenerUsuarioId(Integer id);
}
