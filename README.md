# Parcial3Logica3-2021-2
 
<a name="br1"></a> 

**Tercer parcial de Lógica y Programación III**

**Valor: 15%**

**Profesor: Alejandro Escobar**

<br>
<br>

**Introducción**

El metro de Bogotá está próximo a construirse y la compañía constructora quiere comenzar a

enviar materia prima entra las estaciones saliendo desde la base que IDENTIFICADA como 0

( id Cero).

De esta manera un camión saldrá con una cantidad X de materia prima y se moverá siempre

a la siguiente estación que necesite la mayor cantidad de material y que el camión aún tenga

disponible para entregar.

Todos los días en la mañana se cuenta con una tabla de las cantidades necesitadas por las

estaciones y se carga el camión con la cantidad X y de esta forma se calcula la ruta a seguir

por el camión.

El grafo está representado como una matriz de adyacencia de los id de las estaciones.

La tabla de necesidades es un arreglo donde la posición indica el id de la estación.

<br>
<br>

**Problema**

Todos los días en la mañana se debe ejecutar el programa recorridoCamion, este programa entrega

el recorrido a realizar por el camión según las reglas entregadas anteriormente.

El programa se ejecuta de esta forma, recibe los parametros y entrega un mensaje así.

<br>

**String recorridoCamion ( int[ ] [ ] matrizAdy, int valorInicialX, int [ ] necesidadEstaciones )**

matrizAdy, es una matriz que representa la matriz de adyacencia del grafo.



<a name="br2"></a> 

valorInicialX, es la cantidad con la que se carga el camion en la mañana cuando va a salir de la

estación con id = 0. Es decir, siempre se sale del vertice con Id = 0.

necesidadEstaciones, es un arreglo donde cada posición tiene la cantidad de material necesitado por

la estacion, la posición en el arreglo es la correspondiente id de estación. La posición 0 representa el

Id 1 y siempre tiene una necesidad de 0 (cero) material.

<br>

**Salida:** Es una cadena que dice el recorrido del camion.

