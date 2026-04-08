package com.gabrielcalderon.Tienda.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer codigo_producto;

    @Column(name = "nombre_producto")
    @NotBlank(message = "El nombre del producto no puede esta vacío")
    private String nombre_producto;

    @Column(name = "precio")
    @NotNull(message = "El precio no puede esta vacío")
    @Range(min = 1, message = "El precio debe ser mayor a 0")
    private Double precio;

    @Column(name = "stock")
    @NotNull(message = "El stock no puede esta vacío")
    @Range(min = 1, message = "El stock debe ser mayor a 0")
    private Integer stock;

    @Column(name = "estado")
    @NotNull(message = "El estado no puede esta vacío")
    private Integer estado;



    public Integer getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Integer codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
