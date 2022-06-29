package com.idat.EC2ERICKMARQUEZBODEGA.Repository;


import com.idat.EC2ERICKMARQUEZBODEGA.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes,Integer> {
}
