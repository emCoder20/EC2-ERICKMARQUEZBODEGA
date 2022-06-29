package com.idat.EC2ERICKMARQUEZBODEGA.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String producto;
    private String descripcion;
    private Double precio;
    private Integer stock;


    @OneToMany(mappedBy = "productos")
    private List<Bodegas> bodegas = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "productos_clientes",
            joinColumns = @JoinColumn(
                    name = "id_producto",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition =
                            "foreign key (id_producto) references productos(id_producto)")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true,
                    foreignKey = @ForeignKey(foreignKeyDefinition =
                            "foreign key (id_cliente) references clientes(id_cliente)")
            )

    )

    private List<Clientes> clientes = new ArrayList<>();

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


}
