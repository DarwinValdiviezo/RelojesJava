# Guía de ejecución para los proyectos

Este README proporciona los pasos necesarios para compilar y ejecutar los ejemplos de sincronización de relojes implementados en Java.

## Requisitos

Antes de comenzar, asegúrate de contar con lo siguiente:
- **Java JDK 17 o superior** instalado y configurado en tu sistema.
- **Apache Maven** instalado (si vas a usar Maven para gestionar dependencias y compilación).
- Un editor o entorno de desarrollo, como IntelliJ IDEA, Eclipse o Visual Studio Code.
- Acceso a Internet para descargar dependencias de Maven y conectarte a servidores NTP.

## Ejemplo 1: NTPClient (Cliente NTP)

### Archivos involucrados
- `NTPClient.java`

### Instrucciones
1. Abre el archivo `NTPClient.java`.
2. Verifica que la dependencia de **Apache Commons Net** esté incluida si estás utilizando Maven:
   ```xml
   <dependency>
       <groupId>commons-net</groupId>
       <artifactId>commons-net</artifactId>
       <version>3.6</version>
   </dependency>

# Ejemplo 2: Algoritmo de Cristian

## Archivos involucrados
- `ServidorCristian.java`
- `ClienteCristian.java`

## Instrucciones para el servidor
1. Abre el archivo `ServidorCristian.java`.
2. Compila el archivo utilizando Maven:
   ```bash
   mvn clean compile

# Ejemplo 3: Algoritmo de Berkeley

## Archivos involucrados
- `Nodo.java`
- `CoordinadorBerkeley.java`

## Instrucciones
1. Asegúrate de que ambos archivos (`Nodo.java` y `CoordinadorBerkeley.java`) estén en el mismo paquete.
2. Compila los archivos utilizando Maven:
   ```bash
   mvn clean compile
