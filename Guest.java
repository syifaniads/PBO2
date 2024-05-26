import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Guest extends Customer {
    private String id;
    private int startBalance;
    private Map<String, CartItem> cart = new HashMap<>();

    public Guest(String id, int balance) {
        super("GUEST", "");
        this.id = id;
        this.startBalance = balance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return "Guest";
    }

    @Override
    public boolean addToCart(Menu menuItem, int qty, String startDate) {
        String key = menuItem.IDMenu + startDate;
        if (cart.containsKey(key)) {
            CartItem cartItem = cart.get(key);
            cartItem.qty += qty;
            return false; // Updated
        } else {
            cart.put(key, new CartItem(menuItem, qty, startDate));
            return true; // New
        }
    }

    @Override
    Order makeOrder(LocalDate orderDate, LocalDate endDate, double subTotal, double shippingFee, double discount, double total) {
        return new Order(orderDate, endDate, subTotal, shippingFee, discount, total);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Confirmation of payment for order " + orderNumber + " as a guest.");
    }

    public String toString() {
        return "CREATE GUEST SUCCESS: " + id;
    }
}
