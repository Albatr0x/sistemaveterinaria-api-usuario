package com.example.usuario.service;

import com.example.usuario.model.Usuario;
import dev.samstevens.totp.exceptions.QrGenerationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    Page<Usuario> findAll(Pageable pageable);
    boolean existsById(Long id);
    void deleteById(Long id);

    public void guardarSecretKey(Long usuarioId, String secret);
    public Usuario buscarPorId(Long usuarioId);
    public String generarQRCode(String secret, String username) throws QrGenerationException;
    public boolean verificarCodigo2FA(String secret, String code);
    public void habilitar2FA(Long usuarioId);

    // Operaciones adicionales
    Optional<Usuario> findByUsername(String username);

}
