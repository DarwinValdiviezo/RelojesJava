package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoordinadorBerkeley {
    public static void main(String[] args) {
        // Crear una lista de nodos con tiempos iniciales distintos
        List<Nodo> nodos = new ArrayList<>();
        nodos.add(new Nodo(1, 1000));
        nodos.add(new Nodo(2, 2000));
        nodos.add(new Nodo(3, 3000));

        // Iniciar todos los nodos
        for (Nodo nodo : nodos) {
            nodo.start();
        }

        // Esperar a que los nodos terminen de imprimir su tiempo inicial
        for (Nodo nodo : nodos) {
            try {
                nodo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calcular el promedio de los tiempos de los nodos
        long suma = 0;
        for (Nodo nodo : nodos) {
            suma += nodo.getReloj();
        }
        long promedio = suma / nodos.size();

        // Ajustar el reloj de cada nodo al tiempo promedio
        for (Nodo nodo : nodos) {
            long ajuste = promedio - nodo.getReloj();
            nodo.ajustarReloj(ajuste);
            System.out.println("Nodo " + nodo.getIdNodo() + " ajustado a: " + nodo.getReloj());
        }
    }
}
