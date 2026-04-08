package com.gabrielcalderon.Tienda.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigo_usuario;

    @Column(name = "username")
    @NotBlank(message = "El username no puede esta vacío")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "El password no puede esta vacío")
    private String password;

    @Column(name = "email")
    @NotBlank(message = "El email no puede esta vacío")
    private String email;

    @Column(name = "rol")
    @NotBlank(message = "El rol no puede esta vacío")
    private String rol;

    @Column(name = "estado")
    @NotNull(message = "El estado no puede esta vacío")
    private Integer estado;


    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }
    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
