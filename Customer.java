import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Customer {
    protected String firstName;
    protected String lastName;
    protected int balance;
    protected Map<Menu, Integer> cart;

    public Customer(String firstName, String lastName, int initialBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = initialBalance;
        this.cart = new HashMap<>();
    }
    public abstract String getFullName();
    public abstract int getBalance();
    public abstract void topUp(int amount);
    public abstract boolean addToCart(Menu menuItem, int qty, String startDate);
    public abstract boolean removeFromCart(Menu menuItem, int qty, String startDate);
    abstract Order makeOrder(LocalDate orderDate, LocalDate endDate, double subTotal, double shippingFee, double discount, double total);
    public abstract Map<Menu, Integer> getCart();
    abstract void confirmPay(int orderNumber);
}
