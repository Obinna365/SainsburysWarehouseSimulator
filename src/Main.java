import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int Port = 12345;

    public static void main(String[] args) {
        System.out.println("::: Warehouse Server Running on Port " + Port + " :::");
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(Port)) {
            while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Picker Connected");
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            threadPool.submit(clientHandler);}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}