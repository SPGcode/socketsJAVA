import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    public static void main(String[] args) throws SocketException {

        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];


        try {

            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "hello world from client";

            buffer = mensaje.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            System.out.println("datagrama sended");
            socketUDP.send(pregunta);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);
            System.out.println("receive petition");

            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            socketUDP.close();


        } catch (SocketException | UnknownHostException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
