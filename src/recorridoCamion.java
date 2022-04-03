import java.util.ArrayList;
import java.util.Scanner;

public class recorridoCamion {

    public static void menu() {
        System.out.println("Por favor ingrese el número de su opción deseada:");
        System.out.println("1. Calcular ruta del día.");
        System.out.println("2. Salir.");
    }

    public recorridoCamion(Grafo matrizAdy, int valorInicialX, int[] necesidadEstaciones) {
        int posActual;
        int valorActual = valorInicialX;
        int mayor = -1;
        ArrayList recorrido = new ArrayList();
        boolean[] estacionRecorrida = new boolean[necesidadEstaciones.length];
        int siguiente = 0;
        while ((valorActual - necesidadEstaciones[siguiente] >= 0 && siguiente != -1 && !estacionRecorrida[siguiente])) {
            recorrido.add(siguiente);
            valorActual = valorActual - necesidadEstaciones[siguiente];
            estacionRecorrida[siguiente] = true;
            posActual = siguiente;
            siguiente = avanzar(matrizAdy, posActual, necesidadEstaciones, mayor, valorActual, estacionRecorrida);
        }
        System.out.println("El recorrido del día es el siguiente:");
        for (Object o : recorrido) {
            System.out.println(o);
        }
        System.out.println("El material restante al terminar el recorrido es: " + valorActual + "\n");
    }

    public static ArrayList adyacentes(Grafo matrizAdy, int v) {
        ArrayList list = new ArrayList<>();
        if (!matrizAdy.tieneAdyacentes(v)) {
            return null;
        } else {
            int aux = matrizAdy.obtenerPrimerAdy(v);
            //System.out.println("Lista: ");
            while (aux != -1) {
                //System.out.print(" " + aux);
                list.add(aux);
                aux = matrizAdy.sgteAdyacente(v, aux);
            }
        }
        return list;
    }

    public static int avanzar(Grafo matrizAdy, int posActual, int[] necesidadEstaciones, int mayor, int valorActual, boolean[] estacionRecorrida) {
        ArrayList adyacentes = adyacentes(matrizAdy, posActual);
        if (!adyacentes.isEmpty()) {
            for (Object adyacente : adyacentes) {
                if (necesidadEstaciones[(int) adyacente] > mayor && valorActual >= necesidadEstaciones[(int) adyacente] && !estacionRecorrida[(int) adyacente]) {
                    posActual = (int) adyacente;
                    mayor = necesidadEstaciones[posActual];
                }
            }
        } else {
            posActual = -1;
        }
        return posActual;
    }


    public static void main(String[] args) {
        int opcion;
        Grafo g = new Grafo(11);
        g.insertarArista(0, 2);
        g.insertarArista(2, 3);
        g.insertarArista(3, 4);
        g.insertarArista(4, 5);
        g.insertarArista(5, 9);
        g.insertarArista(3, 6);
        g.insertarArista(6, 8);
        g.insertarArista(6, 7);
        g.insertarArista(7, 1);
        g.insertarArista(1, 10);
        g.insertarArista(2, 7);
        g.insertarArista(10, 7);
        g.insertarArista(10, 8);
        g.insertarArista(2, 8);
        g.imprimirGrafo();

        int[] necesidadEstaciones = new int[11];
        necesidadEstaciones[1] = 100;
        necesidadEstaciones[2] = 250;
        necesidadEstaciones[3] = 300;
        necesidadEstaciones[4] = 200;
        necesidadEstaciones[5] = 50;
        necesidadEstaciones[6] = 20;
        necesidadEstaciones[7] = 50;
        necesidadEstaciones[8] = 400;
        necesidadEstaciones[9] = 300;
        necesidadEstaciones[10] = 800;

        do {
            menu();
            System.out.println("Ingrese una opcion:");
            Scanner in = new Scanner(System.in);
            opcion = in.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la cantidad inicial de materia prima:");
                    int valorInicialX = in.nextInt();
                    new recorridoCamion(g, valorInicialX, necesidadEstaciones);
                }
                case 2 -> System.out.println("Nos alegra haberte ayudado, ¡Ten un feliz día! :)");
                default -> System.out.println("Incorrect option");
            }
        } while (opcion != 2);
    }
}
