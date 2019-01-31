package Main;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ParsingServer(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Не удалось установить соединение с клиентом: " + e);
        }
    }
}

class ParsingServer implements Runnable {
    private Socket socket;
    private Timer timer = new Timer();

    ParsingServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        timer.schedule(new News().timerTask, 0, 20000);
    }
}


