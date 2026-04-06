#  Taller Patrones de Diseño - AutoCar

##  Descripción

Este proyecto implementa una solución para la gestión de vehículos y contratos de alquiler de la empresa **AutoCar**, utilizando patrones de diseño creacionales en Java.

---

##  Patrones utilizados

###  Factory Method

Se utilizó para la creación de vehículos (Auto, Van, Camión) sin depender directamente de clases concretas.

✔ Permite agregar nuevos tipos de vehículos fácilmente
✔ Evita el uso excesivo de `if` o `switch`

---

###  Builder

Se utilizó para la construcción de contratos de alquiler.

✔ Permite construir objetos paso a paso
✔ Maneja atributos opcionales como GPS y seguro
✔ Evita errores en la creación de contratos

---

##  Funcionalidades

* Crear vehículos usando Factory Method
* Agregar vehículos a un inventario (array de objetos)
* Buscar vehículos por placa
* Ordenar vehículos por autonomía
* Crear contratos con Builder

---

##  Tecnologías

* Java

---

##  Cómo ejecutar

1. Abrir el archivo `Main.java`
2. Compilar:

   ```bash
   javac Main.java
   ```
3. Ejecutar:

   ```bash
   java Main
   ```

---

##  Autor

* Estudiantes: Anderson Garcia Amu - 
              Ferney Mauricio Montes - 
              Exenover Diaz

---

##  Conclusión

El uso de los patrones Factory Method y Builder permitió desarrollar un sistema flexible, organizado y fácil de mantener.
