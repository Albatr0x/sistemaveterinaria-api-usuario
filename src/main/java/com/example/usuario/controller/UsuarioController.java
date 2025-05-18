package com.example.usuario.controller;

import com.example.usuario.Util.JwtUtil;
import com.example.usuario.model.Usuario;
import com.example.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.usuario.dto.LoginResponse;
import com.example.usuario.dto.GuardarSecretKeyRequest;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // READ (all)
    @GetMapping
    public ResponseEntity<Page<Usuario>> getAllUsuario(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<Usuario> listaUsuario = usuarioService.findAll(pageable);
        return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
    }

    // READ (by id)
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Búsqueda por nombre
    @GetMapping("/buscar/username")
    public ResponseEntity<Usuario> getUsuarioByNombre(@RequestParam String username) {
        return usuarioService.findByUsername(username)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        return usuarioService.findByUsername(loginRequest.getUsername())
                .filter(usuario -> passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword()))
                .map(usuario -> {
                    String token = jwtUtil.generateToken(usuario.getUsername());
                    // Ajusta los campos según tu entidad Usuario
                    LoginResponse response = new LoginResponse(token, usuario.getUsername(), usuario.getCorreo(),
                            usuario.getNombres(), usuario.getApellido_paterno(), usuario.getApellido_materno());
                    return ResponseEntity.ok().body(response);
                })
                .orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

    @PostMapping("/guardar-secret")
    public ResponseEntity<Void> guardarSecretKey(@RequestBody GuardarSecretKeyRequest request) {
        usuarioService.guardarSecretKey(request.getUsuarioId(), request.getSecret());
        return ResponseEntity.ok().build();
    }



}
