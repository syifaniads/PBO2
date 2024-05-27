import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Customer {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int balance;
    protected Map<Menu, CartItem> cart;

    public Customer(String id, String firstName, String lastName, int initialBalance) {
        this.id = id;
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
    public abstract Map<Menu, CartItem> getCart();
    abstract void confirmPay(int orderNumber);
    public void printOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Kode Pemesan: " + id);
        System.out.println("Nama: " + getFullName());

        List<CartItem> menusToPrint = new ArrayList<>(cart.values());

        menusToPrint.sort(Comparator.comparing((CartItem c) -> LocalDate.parse(c.startDate, formatter)).thenComparingDouble(c -> c.menuItem.Harga));

        System.out.println("No | Menu                                 |  Qty  | Subtotal      ");
        System.out.println("=================================");
        int no = 1;
        double subtotal = 0;
        for (CartItem cartItem : menusToPrint) {
            double itemSubtotal = cartItem.qty * cartItem.menuItem.Harga;
            System.out.printf("%2d  | %-30s | %4d  | %.3f      \n", no++, cartItem.menuItem.NamaMenu + " " + cartItem.menuItem.PlatNomor, cartItem.qty, itemSubtotal);
            System.out.printf("       %s\n", cartItem.startDate);
            subtotal += itemSubtotal;
        }
        System.out.println("=================================");
        System.out.printf("SubTotal                                    :            %.3f\n", subtotal);
        System.out.println("=================================");
        System.out.printf("Total                                          :            %.3f\n", subtotal);
        System.out.printf("Saldo                                         :            %.3f\n", (double)balance);
    }
}
