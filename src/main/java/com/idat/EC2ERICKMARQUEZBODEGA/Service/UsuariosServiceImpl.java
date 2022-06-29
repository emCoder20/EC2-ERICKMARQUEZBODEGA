package com.idat.EC2ERICKMARQUEZBODEGA.Service;


import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosRequest;
import com.idat.EC2ERICKMARQUEZBODEGA.DTO.UsuariosResponse;
import com.idat.EC2ERICKMARQUEZBODEGA.Model.Usuarios;
import com.idat.EC2ERICKMARQUEZBODEGA.Repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService{
    @Autowired
    private IUsuariosRepository repository;

    @Override
    public void guardarUsuario(UsuariosRequest Usuario) {

        Usuarios p = new Usuarios();
        p.setIdUsuario(Usuario.getIdUsuario());
        p.setUsuario(p.getUsuario());
        p.setPassword(p.getPassword());
        p.setRol(p.getRol());

        repository.save(p);
    }

    @Override
    public void actualizarUsuario(UsuariosRequest Usuario) {
        // TODO Auto-generated method stub

        Usuarios p = new Usuarios();
        p.setIdUsuario(Usuario.getIdUsuario());
        p.setUsuario(Usuario.getUsuario());
        p.setPassword(p.getPassword());
        p.setRol(p.getRol());


        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

    @Override
    public List<UsuariosResponse> listarUsuarios() {

        List<UsuariosResponse> listar = new ArrayList<>();

        UsuariosResponse dto = null;

        List<Usuarios> p = repository.findAll();

        for (Usuarios Usuarios : p) {

            dto = new UsuariosResponse();

            dto.setRol(Usuarios.getRol());
            dto.setPassword(Usuarios.getPassword());
            dto.setUsuario(Usuarios.getUsuario());
            dto.setIdUsuario(Usuarios.getIdUsuario());

            listar.add(dto);
        }

        return listar;
    }


    @Override
    public UsuariosResponse obtenerUsuarioId(Integer id) {
        // TODO Auto-generated method stub

        Usuarios Usuarios = repository.findById(id).orElse(null);
        UsuariosResponse dto = new UsuariosResponse();

        dto.setIdUsuario(Usuarios.getIdUsuario());
        dto.setRol(Usuarios.getRol());
        dto.setPassword(Usuarios.getPassword());
        dto.setUsuario(Usuarios.getUsuario());
        dto.setIdUsuario(Usuarios.getIdUsuario());

        return dto;
    }


}
