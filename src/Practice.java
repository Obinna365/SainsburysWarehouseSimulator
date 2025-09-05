import java.io.PrintWriter;
import java.util.*;

public class Practice {
    public List<HashMap<String, Integer>> generatePallets(){
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
    public ArrayList<String> GenerateGoodsIn(){
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
    List<HashMap<String,Integer>> palletsInWarehouse = generatePallets();
    public HashMap<String,Integer> pickPallet(int index){
        HashMap<String, Integer> singlepallet = new HashMap<>();
        System.out.println("Pick a Pallet");
        for (int num = 0; num < palletsInWarehouse.size(); num++) {
            System.out.println(num + " : " + palletsInWarehouse.get(num));
        }
        if(index >= palletsInWarehouse.size()){
            System.out.println("Pallet invalid");
            return null;
        }
        singlepallet.putAll(palletsInWarehouse.get(index));
        palletsInWarehouse.remove(index);

        return singlepallet;
    }




    private void sortGrid(HashMap<String, Integer> singlepallet){
        String nameofproduct = singlepallet.toString();
       String lowercaseproduct =  nameofproduct.toLowerCase();
        if (lowercaseproduct.contains("ready meal")){
            System.out.println("Go to grid 2");
        }
        if (lowercaseproduct.contains("yogurt")){
            System.out.println("Go to grid 1");
        }
        if (lowercaseproduct.contains("bread")||lowercaseproduct.contains("bagels")||lowercaseproduct.contains("vienese biscuits")||lowercaseproduct.contains("cranberry pie")){
            System.out.println("Go to grid 3");

        } else if (lowercaseproduct.equals(null)) {
            System.out.println("Pallet is not working");

        }
    }
    public ArrayList<Integer> chooseStores(){
        ArrayList <Integer> listofstores = new ArrayList<>();
        ArrayList <Integer> usednumbers = new ArrayList<>();
        ArrayList <Integer> usednumbers4queue = new ArrayList<>();
        ArrayList <Integer> numofproductperstore = new ArrayList<>();

        int count = (int) (Math.random()* 84) + 1;
        for (int i = 0; i < count; i ++){
            int stores = (int) (Math.random()*84) + 1;
            if (!usednumbers.contains(stores)){
                listofstores.add(stores);
                usednumbers.add(stores);}
            }
            Collections.sort(listofstores);
        return listofstores;

        }
    public HashMap<Integer, Integer> distributeProducts(HashMap<String,Integer> pallet) {
        int totalProducts = pallet.values().iterator().next();
        ArrayList<Integer> stores = chooseStores();
        LinkedHashMap<Integer, Integer> distribution = new LinkedHashMap<>();

        Random rand = new Random();

        // Start with total products left
        int remaining = totalProducts;

        for (int i = 0; i < stores.size(); i++) {
            int store = stores.get(i);

            // If last store → give it all leftovers
            if (i == stores.size() - 1) {
                distribution.put(store, remaining);
            } else {
                // Random split between 1 and remaining
                int amount = rand.nextInt(remaining - (stores.size() - i - 1)) + 1;
                distribution.put(store, amount);
                remaining -= amount;
            }
        }

        return distribution;
    }



    private void insideGrid1(HashMap<String, Integer> pallet){
        String nameofpallet = pallet.keySet().iterator().next();
        int numofproducts = pallet.values().iterator().next();
        Queue<Integer> pallet1 = new LinkedList<>();
        pallet1.add(numofproducts);


    }

    public void picking(){

    }


    public static void main(String[] args) {
        HashMap<String, Integer> Product = new HashMap<String, Integer>();
        Product.put("Ready Meal: Toad in the hole", 10);
        Practice main = new Practice();
        //main.chooseStores();
        //System.out.println(main.generatePallets());
        HashMap<String,Integer> UserPallet = main.pickPallet(8);
        //System.out.println(main.pickPallet(8));
        System.out.println(main.distributeProducts(UserPallet));
        //main.sortGrid(Product);
}}
