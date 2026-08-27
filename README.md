
# Sistema de Gestión de Ventas

Aplicación web desarrollada con Spring Boot que permite gestionar de forma eficiente las operaciones de una tienda, incluyendo administración de clientes, productos, usuarios y ventas.

Este sistema está diseñado como una solución adaptable para pequeños negocios que buscan digitalizar y optimizar su proceso de ventas.

---

## Características principales

* Autenticación de usuarios (login)
* Gestión de clientes (CRUD)
* Gestión de productos (CRUD)
* Registro de ventas
* Gestión de detalles de venta
* Administración de usuarios
* Uso de roles para control de acceso
* Integración con base de datos relacional

---

## Entidades del sistema

El sistema está basado en las siguientes entidades principales:

* Clientes
* Usuarios
* Productos
* Ventas
* Detalles de Venta

---

## Tecnologías utilizadas

* Backend: Java con Spring Boot
* Frontend: HTML, CSS, JavaScript
* Motor de plantillas: Thymeleaf
* Base de datos: MySQL
* Control de versiones: Git y GitHub

---

## Arquitectura

El proyecto sigue una arquitectura en capas organizada de la siguiente manera:

* controller: Manejo de peticiones HTTP
* service: Lógica de negocio
* repository: Acceso a datos
* entity: Modelado de la base de datos
* exception: Manejo de errores

---

## Base de datos

El sistema incluye un script SQL que contiene:

* Creación de tablas
* Relaciones entre entidades
* Datos de prueba

Esto permite simular un entorno real de gestión de ventas.

---

## Ejecución del proyecto

### Requisitos

* Java JDK 21
* MySQL Workbench
* IDE (recomendado IntelliJ)

---

### Pasos para ejecutar

1. Clonar el repositorio:

```
git clone https://github.com/Gabrielcalderon-2022327/Proyecto-Tienda.git
```

2. Importar el proyecto en el IDE

3. Ejecutar el script SQL incluido

5. Configurar las credenciales en el archivo `application.properties`

6. Ejecutar el proyecto:

7. Acceder desde el navegador:

```
http://localhost:8080
```

## Objetivo del proyecto

Este proyecto fue desarrollado con fines académicos, con el objetivo de aplicar conceptos de:

* Desarrollo web fullstack
* Arquitectura en capas
* Persistencia de datos
* Diseño de sistemas CRUD
