import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

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
    private List<HashMap<String, Integer>> generatePallets(){
        ArrayList<String> Goods = GenerateGoodsIn();
        List<HashMap<String, Integer>> pallet = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            int amount = (int)(Math.random() * 150) + 1;
            String item = Goods.get(new Random().nextInt(Goods.size()));
            HashMap<String, Integer> Product = new HashMap<>();
            Product.put(item,amount);
            pallet.add(Product);
        }
        return pallet;

    }

    private ArrayList<String> GenerateGoodsIn(){
        ArrayList<String> food = new ArrayList<>();
        food.add("Yogurt");
        food.add("Bread");
        food.add("Bagels");
        food.add("Ready Meal: Pasta Bolognese");
        food.add("Ready Meal: Fish and Chips");
        food.add("Ready Meal: Chicken Pie");
        food.add("Ready Meal: Toad in the hole");
        food.add("Vienese Biscuits");
        food.add("Cranberry Pie");
        return food;

    }
}

