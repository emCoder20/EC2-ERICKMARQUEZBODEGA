package com.idat.EC2ERICKMARQUEZBODEGA.Model;

import javax.persistence.*;

@Entity
@Table(name="bodegas")
public class Bodegas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBodega;
    private String nombre;
    private String direccion;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false, unique = true,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references productos(id_producto)"))

    private Productos productos;





    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
