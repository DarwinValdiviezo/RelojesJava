package org.example;

// La clase Nodo representa un nodo en el sistema distribuido. Cada nodo tiene un reloj local
// y puede ajustarlo. Hereda de Thread para simular múltiples nodos en ejecución simultánea.
public class Nodo extends Thread {
    // Identificador único del nodo
    private int id;

    // Valor del reloj local del nodo
    private long reloj;

    // Constructor: inicializa el nodo con su identificador y el valor inicial del reloj
    public Nodo(int id, long reloj) {
        this.id = id;
        this.reloj = reloj;
    }

    // Método para obtener el valor actual del reloj del nodo
    public long getReloj() {
        return reloj;
    }

    // Método para ajustar el reloj del nodo añadiendo un valor al actual
    public void ajustarReloj(long ajuste) {
        this.reloj += ajuste;
    }

    // Método para obtener el identificador del nodo
    public int getIdNodo() {
        return id;
    }

    // Método run: se ejecuta cuando el nodo inicia como un hilo
    @Override
    public void run() {
        // Imprime el tiempo inicial del nodo
        System.out.println("Nodo " + id + " tiempo inicial: " + reloj);
    }
}
