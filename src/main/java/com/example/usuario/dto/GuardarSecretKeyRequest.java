package com.example.usuario.dto;

public class GuardarSecretKeyRequest {
    private Long usuarioId;
    private String secret;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }
}