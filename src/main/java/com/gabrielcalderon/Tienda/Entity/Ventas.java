package com.gabrielcalderon.Tienda.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigo_venta;

    @Column(name = "fecha_venta")
    @NotNull(message = "La fecha no puede esta vacío")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fecha_venta;

    @Column(name = "total")
    @NotNull(message = "El total no puede esta vacío")
    private Double total;

    @Column(name = "estado")
    @NotNull(message = "El estado no puede esta vacío")
    private Integer estado;

    @Column(name = "clientes_dpi_cliente")
    @NotNull(message = "El dpi del cliente no puede esta vacío")
    private Integer clientes_dpi_cliente;

    @Column(name = "usuarios_codigo_usuario")
    @NotNull(message = "El codigo de usuario no puede esta vacío")
    private Integer usuarios_codigo_usuario;


    public Integer getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Integer codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClientes_dpi_cliente() {
        return clientes_dpi_cliente;
    }

    public void setClientes_dpi_cliente(Integer clientes_dpi_cliente) {
        this.clientes_dpi_cliente = clientes_dpi_cliente;
    }

    public Integer getUsuarios_codigo_usuario() {
        return usuarios_codigo_usuario;
    }

    public void setUsuarios_codigo_usuario(Integer usuarios_codigo_usuario) {
        this.usuarios_codigo_usuario = usuarios_codigo_usuario;
    }
}
