package com.idat.EC2ERICKMARQUEZBODEGA.Repository;


import com.idat.EC2ERICKMARQUEZBODEGA.Model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Productos,Integer> {
}
