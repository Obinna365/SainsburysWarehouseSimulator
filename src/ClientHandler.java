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
                out.println("Enter Payroll Number:");
                String input = in.readLine();
                int payrollnumber = Integer.parseInt(input);
                if (input.matches("\\d{6}")) {
                    out.println("Payroll number accepted.");
                    System.out.println(payrollnumber + " Has Logged in");
                } else {
                    out.println("Invalid payroll number. Try again.");
                }

                System.out.println(payrollnumber + " Is available to pick");
                out.println("Please choose a pallet to pick");
                displayAllPalletes(out);
                int Pallet = Integer.parseInt(in.readLine());
                HashMap <String, Integer> UsersPallet = pickPallet(Pallet,out, payrollnumber);
                out.println(UsersPallet);
               sortGrid(UsersPallet, out);

                break outerlabel;
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
            }


    }
    private static List<HashMap<String, Integer>> generatePallets(){
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

    private static ArrayList<String> GenerateGoodsIn(){
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
    private static List<HashMap<String,Integer>> palletsInWarehouse = Collections.synchronizedList(generatePallets());
    private void displayAllPalletes(PrintWriter out){
        for (int num = 0; num < palletsInWarehouse.size(); num++) {
            out.println(num + " : " + palletsInWarehouse.get(num));
        }
    }

    private HashMap<String,Integer> pickPallet(int index, PrintWriter out, int payrollnumber){
        HashMap<String, Integer> singlepallet = new HashMap<>();

        if(index >= palletsInWarehouse.size()){
           out.println("Pallet invalid");
            return null;
        }
        singlepallet.putAll(palletsInWarehouse.get(index));
        palletsInWarehouse.remove(index);
        System.out.println(payrollnumber + " Has chosen a pallet " + singlepallet);
        System.out.println("There are " + palletsInWarehouse.size() + " pallets left");

        return singlepallet;
    }
    private void sortGrid(HashMap<String, Integer> singlepallet, PrintWriter out){
        String nameofproduct = singlepallet.toString();
        String lowercaseproduct =  nameofproduct.toLowerCase();
        if (lowercaseproduct.contains("ready meal")){
            out.println("Go to grid 2");
            insideGrid1(singlepallet, out);
        }
        if (lowercaseproduct.contains("yogurt")){
            out.println("Go to grid 1");
            insideGrid1(singlepallet, out);
        }
        if (lowercaseproduct.contains("bread")||lowercaseproduct.contains("bagels")||lowercaseproduct.contains("vienese biscuits")||lowercaseproduct.contains("cranberry pie")){
            out.println("Go to grid 3");

        } else if (lowercaseproduct.equals(null)) {
            out.println("Pallet is not working");

        }
    }
    private void insideGrid1(HashMap<String, Integer> pallet,PrintWriter out){
        String nameofpallet = pallet.keySet().iterator().next();
        int numofproducts = pallet.values().iterator().next();
        Queue<Integer> pallet1 = new LinkedList<>();
        pallet1.add(numofproducts);


    }

    }



