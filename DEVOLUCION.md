# Devolucion de Correccion

## Grupo Delta

Repositorio corregido sobre la rama `Parcial2`.

## Observaciones del Parcial 1

### 1. Endpoint distinto al pedido

En [src/main/java/unlar/edu/ar/TP_4/controller/AlquilerController.java](src/main/java/unlar/edu/ar/TP_4/controller/AlquilerController.java) la ruta base declarada es:

- linea 10: `@RequestMapping("/api/alquiler")`
- linea 16: `@PostMapping("/desbloquear")`

La consigna pedia el endpoint `/api/alquileres/desbloquear`, por lo que faltaba el segmento `alquileres`.

### 2. UML fuera de la raiz del repositorio

El diagrama se encuentra en:

- [Diagrama/WhatsApp Image 2026-05-23 at 11.38.44.jpeg](Diagrama/WhatsApp%20Image%202026-05-23%20at%2011.38.44.jpeg)

La consigna del primer parcial lo pedia en la raiz del repositorio, no dentro de una carpeta.

### 3. Uso de Lombok fuera de consigna

En [pom.xml](pom.xml):

- lineas 38 a 42: dependencia `org.projectlombok:lombok`
- lineas 55 a 60 y 75 a 95: configuracion del compilador y annotation processor para Lombok

Eso fue marcado en la correccion porque no era necesario para la entrega.

### 4. Compilacion con configuracion inconsistente

En [pom.xml](pom.xml):

- linea 8: `spring-boot-starter-parent` version `4.0.6`
- linea 30: `java.version` configurado en `25`

La consigna trabajaba con Spring Boot 3 y Java 21. Esa configuracion aumenta el riesgo de incompatibilidades al compilar y ejecutar.

## Observaciones del Parcial 2

### 1. El patron State aparece empezado, pero no queda integrado al flujo principal

Se detectan clases de estado:

- [src/main/java/unlar/edu/ar/TP_4/state/EstadoVehiculo.java](src/main/java/unlar/edu/ar/TP_4/state/EstadoVehiculo.java)
- [src/main/java/unlar/edu/ar/TP_4/state/EstadoEnEspera.java](src/main/java/unlar/edu/ar/TP_4/state/EstadoEnEspera.java)
- [src/main/java/unlar/edu/ar/TP_4/state/EstadoEnViaje.java](src/main/java/unlar/edu/ar/TP_4/state/EstadoEnViaje.java)
- [src/main/java/unlar/edu/ar/TP_4/state/EstadoEnReparacion.java](src/main/java/unlar/edu/ar/TP_4/state/EstadoEnReparacion.java)

Y el modelo tiene estado:

- [src/main/java/unlar/edu/ar/TP_4/model/Vehiculos.java](src/main/java/unlar/edu/ar/TP_4/model/Vehiculos.java), lineas 12 a 21 y 44 a 53

Pero en [src/main/java/unlar/edu/ar/TP_4/service/AlquilerService.java](src/main/java/unlar/edu/ar/TP_4/service/AlquilerService.java) no se usa ese ciclo de vida para decidir si el vehiculo puede o no avanzar en el flujo:

- lineas 45 a 53: solo se valida por patente y bateria
- no se invoca `iniciarViaje()`, `finalizarViaje()` ni `enviarAReparacion()`

Por eso la resolucion del ciclo de vida quedo incompleta respecto de la consigna.

### 2. El patron Strategy existe, pero no se aprovecha de forma dinamica

Se detectan estrategias:

- [src/main/java/unlar/edu/ar/TP_4/strategy/TarifaStrategy.java](src/main/java/unlar/edu/ar/TP_4/strategy/TarifaStrategy.java)
- [src/main/java/unlar/edu/ar/TP_4/strategy/TarifaBase.java](src/main/java/unlar/edu/ar/TP_4/strategy/TarifaBase.java)
- [src/main/java/unlar/edu/ar/TP_4/strategy/TarifaHoraPico.java](src/main/java/unlar/edu/ar/TP_4/strategy/TarifaHoraPico.java)
- [src/main/java/unlar/edu/ar/TP_4/strategy/TarifaClima.java](src/main/java/unlar/edu/ar/TP_4/strategy/TarifaClima.java)

Pero en [src/main/java/unlar/edu/ar/TP_4/service/AlquilerService.java](src/main/java/unlar/edu/ar/TP_4/service/AlquilerService.java):

- linea 69: se fija siempre `TarifaBase`
- no hay cambio dinamico de estrategia en tiempo de ejecucion

Eso hace que la parte de tarifa adaptativa no quede resuelta completamente.

### 3. Se mejoro la busqueda por patente, pero falta cerrar la parte de API profesional

Como punto positivo:

- [src/main/java/unlar/edu/ar/TP_4/repository/VehiculoRepository.java](src/main/java/unlar/edu/ar/TP_4/repository/VehiculoRepository.java), lineas 8 a 15

ahi se usa `HashMap<String, Vehiculos>` y la busqueda por patente ya no es lineal.

Sin embargo, en la API siguen faltando partes pedidas por la consigna:

- [src/main/java/unlar/edu/ar/TP_4/controller/AlquilerController.java](src/main/java/unlar/edu/ar/TP_4/controller/AlquilerController.java): solo existe `desbloquear`
- no existe endpoint `finalizar`
- la respuesta del controlador sigue siendo `String` en vez de un DTO de respuesta

### 4. Falta la integracion de deduplicacion GPS dentro de un flujo visible

Se detecta la idea correcta en:

- [src/main/java/unlar/edu/ar/TP_4/service/ReporteGpsService.java](src/main/java/unlar/edu/ar/TP_4/service/ReporteGpsService.java), lineas 17 a 26

ahi se usa `HashSet` para eliminar duplicados en una pasada.

El problema es que esa solucion queda aislada y no aparece conectada a un endpoint o a una prueba funcional clara dentro del flujo principal del parcial.

### 5. El controlador nuevo no compila por una dependencia faltante

En [src/main/java/unlar/edu/ar/TP_4/controller/VehiculoController.java](src/main/java/unlar/edu/ar/TP_4/controller/VehiculoController.java):

- linea 11: se importa `unlar.edu.ar.TP_4.service.VehiculoService`
- lineas 16 y 17: se inyecta `VehiculoService`

Pero esa clase no existe en el repositorio, por lo que el proyecto queda inconsistente y con riesgo de no compilar.

### 6. Faltan el anexo tecnico y el UML avanzado en la ubicacion esperada

No se encontro:

- `README.md` o `PERFORMANCE.md` en la raiz justificando rendimiento
- UML avanzado en la raiz

El archivo de imagen agregado en el segundo parcial aparece dentro de codigo fuente:

- [src/main/java/unlar/edu/ar/TP_4/IMG-20260619-WA0055.jpg](src/main/java/unlar/edu/ar/TP_4/IMG-20260619-WA0055.jpg)

Ese no es un lugar adecuado para documentacion.

## Resumen

Lo que estuvo mejor resuelto:

- uso de `HashMap` para busqueda por patente
- presencia de clases para `State`
- presencia de clases para `Strategy`
- uso de `HashSet` para deduplicacion de GPS

Lo que quedo pendiente o incompleto:

- integrar de verdad los estados al flujo de alquiler
- cambiar la estrategia de tarifa en tiempo de ejecucion
- agregar `finalizar` y devolver DTOs de respuesta
- corregir referencias a clases faltantes
- mover/documentar UML y anexo tecnico en la raiz del repositorio
