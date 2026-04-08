package com.gabrielcalderon.Tienda.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Detalle_Venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigo_detalle_venta;

    @Column(name = "cantidad")
    @NotNull(message = "La cantidad no puede esta vacío")
    @Range(min = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    @NotNull(message = "El precio no puede esta vacío")
    @Range(min = 1, message = "El precio debe ser mayor a 0")
    private Double precio_unitario;

    @Column(name = "subtotal")
    @NotNull(message = "El subtotal no puede esta vacío")
    @Range(min = 1, message = "El subtotal debe ser mayor a 0")
    private Double subtotal;

    @Column(name = "productos_codigo_producto")
    @NotNull(message = "El codigo de producto no puede esta vacío")
    private Integer productos_codigo_producto;

    @Column(name = "ventas_codigo_venta")
    @NotNull(message = "El codigo de venta no puede esta vacío")
    private Integer ventas_codigo_venta;

    @Column(name = "estado")
    @NotNull(message = "El estado no puede esta vacío")
    private Integer estado;


    public Integer getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductos_codigo_producto() {
        return productos_codigo_producto;
    }

    public void setProductos_codigo_producto(Integer productos_codigo_producto) {
        this.productos_codigo_producto = productos_codigo_producto;
    }

    public Integer getVentas_codigo_venta() {
        return ventas_codigo_venta;
    }

    public void setVentas_codigo_venta(Integer ventas_codigo_venta) {
        this.ventas_codigo_venta = ventas_codigo_venta;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
