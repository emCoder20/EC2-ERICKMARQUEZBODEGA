package com.idat.EC2ERICKMARQUEZBODEGA.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="productos_bodegas")
public class ProductosBodegas {

    @Id
    private ProductosBodegasPK fk = new ProductosBodegasPK();

    private Integer idProducto;

    public ProductosBodegasPK getFk() {
        return fk;
    }

    public void setFk(ProductosBodegasPK fk) {
        this.fk = fk;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

@Embeddable
class ProductosBodegasPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "id_producto", nullable = false, unique = true)
    private Integer idProducto;

    @Column(name = "id_bodega", nullable = false, unique = true)
    private Integer idBodega;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }
}

