# ForoHub API

**ForoHub API** es una API REST diseñada para gestionar usuarios, cursos, tópicos y respuestas en un foro académico. Este proyecto utiliza **Spring Boot**, **Hibernate** y una base de datos relacional (**MySQL** en este caso pero puede ser otra) para su implementación.

## Características

- **Usuarios**: Registro, autenticación (JWT) y listado de usuarios.
- **Cursos**: Creación, actualización, listado y eliminación de cursos.
- **Tópicos**: Creación, actualización, listado, eliminación y gestión del estado.
- **Respuestas**: Creación, actualización, listado y eliminación de respuestas.
- **Autenticación**: Autenticación basada en JWT con roles definidos (ADMIN, MODERATOR, TRAINER, USER).

---

## Requisitos previos

- Java 17+
- Maven 3+
- Base de datos MySQL u otra base de datos compatible con Hibernate
- Flyway para la gestión de migraciones

---

## Configuración

1. **Clonar el repositorio:**

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd ForoHub_API
   ```

2. **Configurar la base de datos:**
   Actualiza las propiedades en `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://${DB_URL}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASSWORD}
   api.security.secret=${SECURITY_SECRET}
   ```

3. **Ejecutar migraciones con Flyway:**

   ```bash
   mvn flyway:migrate
   ```

4. **Construir y ejecutar la aplicación:**
   ```bash
   mvn clean install
   java -jar target/ForoHub_API.jar
   ```

---

## Endpoints principales

### Usuarios

- **POST** `/register` - Registro de nuevos usuarios
- **POST** `/login` - Autenticación de usuarios

### Cursos

- **GET** `/courses` - Listar todos los cursos
- **POST** `/courses` - Crear un nuevo curso
- **PUT** `/courses/{id}` - Actualizar un curso
- **DELETE** `/courses/{id}` - Eliminar un curso

### Tópicos

- **GET** `/topics` - Listar todos los tópicos
- **POST** `/topics` - Crear un nuevo tópico
- **PUT** `/topics/{id}` - Actualizar un tópico
- **DELETE** `/topics/{id}` - Eliminar un tópico

### Respuestas

- **GET** `/answers` - Listar todas las respuestas
- **POST** `/answers` - Crear una nueva respuesta
- **PUT** `/answers/{id}` - Actualizar una respuesta
- **DELETE** `/answers/{id}` - Eliminar una respuesta

---

## Autenticación y roles

La API utiliza **JSON Web Tokens (JWT)** para la autenticación. Cada usuario tiene un rol asociado que determina su acceso a diferentes endpoints.

Roles disponibles:

- **ADMIN**: Acceso completo
- **MODERATOR**: Gestión de tópicos y respuestas
- **TRAINER**: Gestión de cursos
- **USER**: Creación y visualización de tópicos y respuestas

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Hibernate**
- **MySQL**
- **Flyway**
- **JWT**

---

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

---

## Licencia

Este proyecto está bajo la [MIT License](LICENSE).
