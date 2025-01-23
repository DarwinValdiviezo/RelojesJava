package org.example;

// Importamos las clases necesarias para manejar conexiones de red y fechas
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Esta clase representa el servidor que implementa el Algoritmo de Cristian
public class ServidorCristian {
    public static void main(String[] args) {
        // Utilizamos un bloque try-with-resources para crear el servidor en el puerto 5000
        // El try-with-resources asegura que el recurso (ServerSocket) se cierre automáticamente
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor escuchando en el puerto 5000...");

            // El servidor entra en un bucle infinito para aceptar conexiones entrantes
            while (true) {
                // Cada vez que un cliente se conecta, el servidor maneja la solicitud
                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    // Enviar la hora actual al cliente
                    // La clase Date se usa para obtener la hora actual en el servidor
                    outputStream.writeObject(new Date());

                } catch (Exception e) {
                    // En caso de error al procesar la conexión del cliente, se imprime un mensaje
                    System.err.println("Error en la conexión con el cliente: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // En caso de error al inicializar el servidor (por ejemplo, si el puerto está ocupado),
            // se imprime un mensaje de error
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
