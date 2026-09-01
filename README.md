# TP Grupal OO2 2026 - Sistema de Gestión "Epicentro Gourmet"

Trabajo práctico grupal de la materia Orientación a Objetos II (UNLa) - Hito 1: Hibernate.

## Grupo

**Grupo 10**

| Nombre y Apellido | Usuario GitHub |
|---|---|
| _completar_ | _completar_ |
| _completar_ | _completar_ |
| _completar_ | _completar_ |
| _completar_ | _completar_ |

## Casos de Uso (Hito 1)

| Caso de Uso | Responsable | Estado |
|---|---|---|
| FoodTrucks de un festival con la cantidad de platos que ofrece cada uno (Herencia: FoodTruck · Uno a Muchos: UnidadVenta→Plato) | _completar_ | ✅ |
| Staff (Cocineros/Cajeros) asignado a una Unidad de Venta, con sueldo calculado (Herencia: Cocinero/Cajero · Uno a Muchos: UnidadVenta→Personal) | _completar_ | pendiente |
| Puestos Desarmables de un festival, con cantidad de carpas y superficie total (Herencia: PuestoDesarmable · Uno a Muchos: Festival→UnidadVenta) | _completar_ | pendiente |
| Total facturado por cada FoodTruck de un festival (Herencia: FoodTruck · Uno a Muchos: Pedido→DetallesPedido) | _completar_ | pendiente |

## Stack

- Java 21 (JDK)
- Hibernate 5.4.11 (mapeo por XML `.hbm.xml`, sin JPA)
- MySQL 8

## Cómo levantar el proyecto (Eclipse)

1. Clonar el repo e importarlo en Eclipse: **File → Open Projects from File System...** → seleccionar la carpeta del repo.
2. Crear la base en MySQL: `CREATE DATABASE epicentro_gourmet CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;`
3. Copiar `src/hibernate.cfg.xml.template` a `src/hibernate.cfg.xml` y completar `connection.password` con tu contraseña local de MySQL (ese archivo no se sube al repo, cada uno tiene el suyo).
4. Verificar en **Properties → Java Build Path → Libraries** que los jars de `lib/` estén bajo **Classpath**, no bajo **Modulepath** (si Eclipse los pone en Modulepath tira un `NoClassDefFoundError` con byte-buddy al arrancar Hibernate). Si hace falta, seleccionarlos, Remove, y volver a agregarlos con "Add JARs..." teniendo el nodo Classpath seleccionado.
5. Correr `test/TestCargarDatosPrueba.java` una vez para crear las tablas (via `hbm2ddl.auto=update`) y cargar datos de prueba.
6. Correr cualquier clase de `test/` para probar un caso de uso.

## Estructura

- `datos/` - POJOs del modelo
- `mapeos/` - mapeos Hibernate `.hbm.xml`
- `dao/` - acceso a datos (`HibernateUtil` + un Dao por entidad)
- `negocio/` - capa de negocio (ABM por entidad)
- `test/` - clases de prueba con `main()`
