package org.example;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

public class ClienteCristian {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            long t0 = System.currentTimeMillis(); // Tiempo antes de enviar la solicitud

            // Recibe la hora del servidor
            Date serverTime = (Date) inputStream.readObject();

            long t1 = System.currentTimeMillis(); // Tiempo después de recibir la respuesta

            // Calcula la latencia de red
            long networkDelay = t1 - t0;

            // Ajusta la hora del servidor con la mitad de la latencia
            long estimatedServerTime = serverTime.getTime() + (networkDelay / 2);

            // Muestra la hora estimada considerando la latencia
            System.out.println("Hora estimada considerando la latencia: " + new Date(estimatedServerTime));

        } catch (Exception e) {
            System.err.println("Error al conectarse al servidor: " + e.getMessage());
        }
    }
}
