package com.idat.EC2ERICKMARQUEZBODEGA.Model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="productos_clientes")
public class ProductosClientes {

    @Id
    private ProductosClientesPK fk = new ProductosClientesPK();

    private Integer dni;

    public ProductosClientesPK getFk() {
        return fk;
    }

    public void setFk(ProductosClientesPK fk) {
        this.fk = fk;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}

@Embeddable

class ProductosClientesPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "id_producto", nullable = false, unique = true)
    private Integer idProducto;

    @Column(name = "id_cliente", nullable = false, unique = true)
    private Integer idCliente;

    public Integer getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
