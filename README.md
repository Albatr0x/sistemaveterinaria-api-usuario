# API de Usuarios - Sistema Veterinaria

Este proyecto es una API REST para la gestión de usuarios del Sistema Veterinaria, desarrollada con Spring Boot.

## Estructura del Proyecto

```
src/main/java/com/example/usuario/
├── configuracion/         # Configuraciones de la aplicación
├── controller/           # Controladores REST
├── dto/                 # Objetos de transferencia de datos
├── model/              # Entidades del dominio
├── repository/         # Repositorios de datos
├── service/           # Lógica de negocio
└── Util/              # Utilidades y helpers
```

## Componentes Principales

### Modelo de Datos
- `Usuario`: Entidad principal que implementa `UserDetails` de Spring Security
  - Atributos principales:
    - id: Identificador único
    - username: Nombre de usuario (único)
    - password: Contraseña encriptada
    - enabled: Estado de la cuenta
    - secretKey: Clave para autenticación de dos factores
    - using2fa: Indicador de uso de 2FA
    - Datos personales (nombres, apellidos, correo, etc.)

### Controladores
- `UsuarioController`: Expone los endpoints REST
  - Endpoints principales:
    - POST `/api/usuario`: Crear nuevo usuario
    - GET `/api/usuario`: Listar usuarios (paginado)
    - GET `/api/usuario/{id}`: Obtener usuario por ID
    - GET `/api/usuario/buscar/username`: Buscar por nombre de usuario
    - POST `/api/usuario/login`: Autenticación de usuario
    - POST `/api/usuario/guardar-secret`: Guardar clave secreta para 2FA

### Servicios
- `UsuarioService`: Interfaz que define las operaciones de negocio
- `UsuarioServiceImpl`: Implementación de las operaciones de negocio
- `CustomUserDetailsService`: Servicio personalizado para autenticación

### Seguridad
- Implementación de JWT para autenticación
- Soporte para autenticación de dos factores (2FA)
- Encriptación de contraseñas con BCrypt

## Configuración

### Requisitos
- Java 17 o superior
- Maven
- PostgreSQL

### Variables de Entorno
El archivo `application.properties` contiene las siguientes configuraciones:
- Conexión a base de datos PostgreSQL
- Configuración de JWT
- Puerto del servidor (9100)

## Cómo Levantar la Aplicación

1. Clonar el repositorio
2. Configurar la base de datos PostgreSQL
3. Ejecutar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
   O usando Docker:
   ```bash
   docker-compose up
   ```

## Acceso a Swagger

La documentación de la API está disponible en Swagger UI:
- URL: `http://localhost:9100/swagger-ui.html`
- Endpoints disponibles:
  - `/v3/api-docs`: Especificación OpenAPI
  - `/swagger-ui.html`: Interfaz de Swagger UI

## Características de Seguridad

- Autenticación basada en JWT
- Soporte para autenticación de dos factores (2FA)
- Encriptación de contraseñas
- Protección contra CSRF
- Endpoints públicos y protegidos configurados

## DTOs (Data Transfer Objects)

- `LoginResponse`: Respuesta del proceso de login
- `GuardarSecretKeyRequest`: Solicitud para guardar clave secreta 2FA

## Utilidades

- `JwtUtil`: Utilidad para generación y validación de tokens JWT 