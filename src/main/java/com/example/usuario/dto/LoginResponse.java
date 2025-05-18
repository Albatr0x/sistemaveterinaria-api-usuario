package com.example.usuario.dto;

public class LoginResponse {
    private String token;
    private String username;
    private String correo; // agrega otros campos si es necesario
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;

    public LoginResponse(String token, String username, String correo, String nombres, String apellido_paterno, String apellido_materno) {
        this.token = token;
        this.username = username;
        this.correo = correo;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;

    }

    // getters y setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellido_paterno() { return apellido_paterno; }
    public void setApellido_paterno(String apellido_paterno) { this.apellido_paterno = apellido_paterno; }
    public String getApellido_materno() { return apellido_materno; }
    public void setApellido_materno(String apellido_materno) { this.apellido_materno = apellido_materno; }

}