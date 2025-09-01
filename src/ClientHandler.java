import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            outerlabel:
            for(;;) {
                String input = in.readLine();
                out.println("Enter Payroll Number:");
                while (input != null){
                    System.out.println("Picker says: " + in);
                }
                break outerlabel;
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
            }


    }
}
