# 🛒 DonPedritoMarket

### "De la esquina del barrio a la nube: una historia de transformación digital"

En un mercado tradicional del barrio, Don Pedrito conocía a todos sus clientes por su nombre. Pero con el paso del tiempo y el avance de la tecnología, las necesidades cambiaron. Fue entonces que surgió una idea: **llevar ese mismo espíritu cercano al mundo digital**. Así nació **DonPedritoMarket**, un sistema desarrollado con fines académicos que simula la gestión integral de un mercado local, usando herramientas modernas como Spring Boot, MySQL y React.

---

## 📌 Funcionalidades principales

- 🧑‍💼 Gestión de usuarios (registro e inicio de sesión)
- 📦 CRUD de productos
- 🧍‍♂️ CRUD de clientes
- 🚚 CRUD de proveedores
- 📊 Interfaz visual con React 
- 🔐 estructura REST y buenas prácticas de arquitectura

---

## ⚙️ Tecnologías utilizadas

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (soportado también modo embebido H2 temporalmente)
- Maven
- Lombok

### Frontend 
- React
- HTML, CSS
- Axios (para llamadas a la API REST)
- Boostrap
---

## 🗂️ Estructura del proyecto

DAE-DonPedritoMarket/
├── backend/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ │ └── com.donpedrito.market/
│ │ │ └── resources/
│ │ │ ├── application.properties
│ │ │ ├── schema.sql
│ │ │ └── data.sql
│ └── pom.xml
├── frontend/ (React) 
└── README.md

## 🔧 Configuración del ambiente

### Spring Boot Standalone

Para simplificar la ejecución del backend, se ha usado Spring Boot, que permite ejecutar aplicaciones como **standalone** (sin necesidad de servidor externo). También se puede desplegar en servidores web con configuraciones adicionales.

---

## 🧰 Configuración con Maven

Si es la primera vez que usas Maven:

1. **Actualizar dependencias**  
   En Eclipse, haz clic derecho sobre el proyecto → `Maven` → `Update Project...`  
   Esto descargará todas las librerías necesarias.

2. **Validar el proyecto**  
   Haz clic derecho sobre el proyecto → `Run As` → `Maven install`  
   Si todo está correcto, verás en la consola el mensaje : BUILD SUCCESS

   ## 🗃️ Base de datos relacional

Se utiliza una base de datos embebida para pruebas rápidas y desarrollo. Al reiniciar la aplicación, se restauran los datos iniciales definidos en:

- `schema.sql` → estructura de tablas
- `data.sql` → datos de ejemplo
Ubicación: backend/src/main/resources/


*Puedes conectar con MySQL para entornos persistentes.*

---

## ▶️ Iniciar la aplicación

### Backend (Spring Boot)

1. Abre el proyecto en Eclipse o IntelliJ.
2. Ubica el archivo:
   
com.donpedrito.market.DonpedritoMarketApplication

3. Haz clic derecho → `Run As` → `Spring Boot App`
4. El servidor iniciará por defecto en el puerto `8085`

**Cambiar puerto (opcional):**  
Edita el archivo `application.properties`:

---

### Frontend (React) 



























