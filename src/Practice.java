import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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


    public static void main(String[] args) {
        HashMap<String, Integer> Product = new HashMap<String, Integer>();
        Product.put("Ready Meal: Toad in the hole", 10);
        Practice main = new Practice();
        //System.out.println(main.generatePallets());
        //System.out.println(main.pickPallet(8));
        main.sortGrid(Product);
}}
