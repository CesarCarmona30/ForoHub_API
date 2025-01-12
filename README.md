# ForoHub API

### Descripción
API RESTful desarrollada con Spring Boot para gestionar un foro de discusión. Este proyecto permite la creación, edición, eliminación y consulta de publicaciones y comentarios en un entorno seguro y escalable.

### Tecnologías
- **Spring Boot 3.4.1**
- **Java 17/21**
- **MySQL**
- **Spring Security**
- **Spring Data JPA**
- **Flyway**

### Características
- Gestión de usuarios (autenticación y autorización).
- CRUD de publicaciones y comentarios.
- Validación de datos del lado del servidor.
- Versionado de la base de datos con Flyway.

### Requisitos previos
1. **Java 17 o superior**
2. **Maven 3.8+**
3. **MySQL 8+**

### Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/CesarCarmona30/ForoHub_API.git
   cd ForoHub_API
   ```

2. Configura la base de datos:
   - Crea una base de datos MySQL llamada `foro_hub`.
   - Actualiza las credenciales de la base de datos en `application.properties` o `application.yml`.

3. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

4. Accede a la API en: `http://localhost:8080`

### Endpoints principales
- **Usuarios**:
  - `POST /api/v1/auth/register`: Registro de usuarios.
  - `POST /api/v1/auth/login`: Autenticación de usuarios.
- **Publicaciones**:
  - `GET /api/v1/posts`: Listar todas las publicaciones.
  - `POST /api/v1/posts`: Crear una nueva publicación.
  - `PUT /api/v1/posts/{id}`: Actualizar una publicación.
  - `DELETE /api/v1/posts/{id}`: Eliminar una publicación.
- **Comentarios**:
  - `POST /api/v1/posts/{postId}/comments`: Crear un comentario en una publicación.

### Contribuciones
Si deseas contribuir al proyecto, realiza un fork del repositorio, crea una rama para tus cambios y abre un pull request.

### Licencia
Este proyecto está licenciado bajo la [MIT License](LICENSE).

---

**Autor:** [Cesar Carmona](https://github.com/CesarCarmona30)
