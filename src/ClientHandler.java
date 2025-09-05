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
                LinkedHashMap <String, Integer> UsersPallet = pickPallet(Pallet,out, payrollnumber);
                out.println(UsersPallet);
                Picking(out, UsersPallet);

                break outerlabel;
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
            }


    }
    private static List<LinkedHashMap<String, Integer>> generatePallets(){
        ArrayList<String> Goods = GenerateGoodsIn();
        List<LinkedHashMap<String, Integer>> pallet = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            int amount = (int)(Math.random() * 150) + 1;
            String item = Goods.get(new Random().nextInt(Goods.size()));
            LinkedHashMap<String, Integer> Product = new LinkedHashMap<>();
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
    private static List<LinkedHashMap<String,Integer>> palletsInWarehouse = Collections.synchronizedList(generatePallets());
    private void displayAllPalletes(PrintWriter out){
        for (int num = 0; num < palletsInWarehouse.size(); num++) {
            out.println(num + " : " + palletsInWarehouse.get(num));
        }
    }

    private LinkedHashMap<String,Integer> pickPallet(int index, PrintWriter out, int payrollnumber){
        LinkedHashMap<String, Integer> singlepallet = new LinkedHashMap<>();

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
    private int sortGrid(LinkedHashMap<String, Integer> singlepallet, PrintWriter out){
        String nameofproduct = singlepallet.toString();
        String lowercaseproduct =  nameofproduct.toLowerCase();
        if (lowercaseproduct.contains("ready meal")){
            out.println("Go to grid 2");
            return 1;
        }
        if (lowercaseproduct.contains("yogurt")){
            out.println("Go to grid 1");
            return 0;
        }
        if (lowercaseproduct.contains("bread")||lowercaseproduct.contains("bagels")||lowercaseproduct.contains("vienese biscuits")||lowercaseproduct.contains("cranberry pie")){
            out.println("Go to grid 3");
        return 2;}
        return -1;


    }
    /*private Queue turnHashMaptoQueue(HashMap<String, Integer> pallet){
        String nameofpallet = pallet.keySet().iterator().next();
        int numofproducts = pallet.values().iterator().next();
        Queue<Integer> pallet1 = new LinkedList<>();
        pallet1.add(numofproducts);
        return pallet1;}*/


    private static final List<ArrayList<int[]>> warehousecages = cagesInWarehouse();
    private static List<ArrayList<int[]>> cagesInWarehouse(){
        List<ArrayList<int[]>> cagesinwarehouse = new ArrayList<>();
        for (int grids = 0; grids < 3; grids++){
            ArrayList<int[]> cages = new ArrayList<>();
            cagesinwarehouse.add(cages);
            for (int i = 0; i < 84; i++){
            int[] cage = new int[50];
            cages.add(cage);

            }}
        return cagesinwarehouse;
    }


    public void Picking (PrintWriter out,LinkedHashMap<String, Integer> pallet){
       int gridassigner = sortGrid(pallet,out);
        ArrayList<int[]> chosengrid = warehousecages.get(gridassigner);
    }

    }



