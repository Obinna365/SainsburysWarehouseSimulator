import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Picker {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Auto-flush enabled
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the Warehouse Server!");

            Thread serverListener = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Warehouse Server: " + message); // Print server response
                    }
                } catch (IOException e) {
                    System.err.println("Error reading server messages: " + e.getMessage());
                }
            });
            serverListener.start();

            String name = userInput.readLine();
            out.println(name);

            String command;
            while ((command = userInput.readLine()) != null) {
                out.println(command);
            }
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
