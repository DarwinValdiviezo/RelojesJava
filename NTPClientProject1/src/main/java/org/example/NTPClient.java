package org.example;

// Importamos las clases necesarias de la biblioteca Apache Commons Net y las clases estándar de Java
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;

// Esta clase representa un cliente NTP que se conecta a un servidor de tiempo para obtener la hora actual
public class NTPClient {
    public static void main(String[] args) {
        // Nombre del servidor NTP al que queremos conectarnos
        String ntpServer = "time.google.com";

        try {
            // Creamos una instancia de NTPUDPClient para realizar la consulta NTP
            NTPUDPClient client = new NTPUDPClient();

            // Configuramos un tiempo de espera de 10 segundos para la conexión
            client.setDefaultTimeout(10000);

            // Obtenemos la dirección del servidor NTP
            InetAddress hostAddr = InetAddress.getByName(ntpServer);

            // Enviamos una consulta NTP al servidor y obtenemos la información de tiempo
            TimeInfo info = client.getTime(hostAddr);

            // Extraemos la marca de tiempo transmitida por el servidor
            long returnTime = info.getMessage().getTransmitTimeStamp().getTime();

            // Mostramos la hora sincronizada en la consola
            System.out.println("Hora sincronizada: " + new java.util.Date(returnTime));

            // Cerramos el cliente para liberar los recursos
            client.close();
        } catch (Exception e) {
            // En caso de error, imprimimos un mensaje de error
            System.err.println("Error: " + e.getMessage());
        }
    }
}
