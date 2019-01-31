package Main;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8989));
            socket.close();
        } catch (Exception e) {
            System.err.println("Не удалось установить соединение с сервером " + e);
        }
    }
}
