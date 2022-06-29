package com.idat.EC2ERICKMARQUEZBODEGA.Repository;


import com.idat.EC2ERICKMARQUEZBODEGA.Model.Bodegas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBodegasRepository extends JpaRepository<Bodegas,Integer> {
}
