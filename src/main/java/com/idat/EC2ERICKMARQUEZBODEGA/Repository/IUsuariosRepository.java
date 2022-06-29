package com.idat.EC2ERICKMARQUEZBODEGA.Repository;


import com.idat.EC2ERICKMARQUEZBODEGA.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {

}
