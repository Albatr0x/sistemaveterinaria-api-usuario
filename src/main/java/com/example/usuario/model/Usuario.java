package com.example.usuario.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean enabled;

    private String secretKey; // Campo para almacenar la clave secreta

    // Campos para 2FA

    private boolean using2fa;

    private Long Idveterinaria;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;

    private Integer tipo_documento;

    private String nro_documento;

    private String nro_telefono;

    private String direccion;


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public void setUsing2fa(boolean using2fa) {
        this.using2fa = using2fa;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    public Long getIdveterinaria() {
        return Idveterinaria;
    }

    public void setIdveterinaria(Long idveterinaria) {
        Idveterinaria = idveterinaria;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(Integer tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(String nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    // Implementación de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // O devuelve los roles del usuario si los tienes
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    public Long getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // Getter y Setter (o @Data de Lombok)
    public boolean isUsing2fa() {
        return using2fa;
    }

    public String getSecretKey() {
        return secretKey;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // Puedes modificar esto según tu lógica de negocio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Puedes modificar esto según tu lógica de negocio
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Puedes modificar esto según tu lógica de negocio
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}

