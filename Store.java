import java.util.ArrayList;

public class Store {
    String name;
    ShoppingCart cart = new ShoppingCart();

    public Store(String n){
        name = n;
    }

    public static void main(String[] args) {
        Store store_test = new Store("Macy's");

        Item versace = new Item("Versace Shoes", 1, 200.34);
        Item belt = new Item("Dress Belt", 1, 35.99);
        Item jacket = new Item("Overcoat", 1, 350.01);
        Item hat = new Item("Sun Hat", 1, 50.67);
        Item sunglasses = new Item("Ray Ban's - Brown", 2, 200.34);

        store_test.cart.addToCart(versace);
        store_test.cart.addToCart(belt);
        store_test.cart.addToCart(jacket);
        store_test.cart.addToCart(hat);
        store_test.cart.addToCart(sunglasses);

        System.out.println("\nTotal Price: $"+ store_test.cart.totalPrice);
        System.out.println("Total Items: "+ store_test.cart.itemCount + "\n");
        store_test.cart.getItems();

    }
}

class ShoppingCart {
    // number of items in the cart
    int itemCount = 0;
    // total cart price
    double totalPrice = 0.00;
    // ArrayList to hold all the items dynamically
    public ArrayList<Item> items = new ArrayList<Item>();

    // method to add to cart:
    //      - updates totalItems
    //      - calls updateTotal
    public void addToCart(Item item) {
        items.add(item);
        itemCount += item.getQuantity();
        updateTotal();
    }

    // method to update totalPrice
    //      - using a for in loop to iterate through the array list
    public void updateTotal() {
        totalPrice = 0;
        for (Item item: items) {
            totalPrice += (item.getPrice()) * item.getQuantity();
        }
    }

    public void getItems() {
        for (Item item: items) {
            System.out.println("Item: " + item.getItem() + "\nCount: " + item.getQuantity());
        }
    }

}

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item (String n, int q, double p){
        name = n;
        quantity = q;
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void updateQuantity(int num) {
        quantity = num;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItem() {
        return name;
    }
}