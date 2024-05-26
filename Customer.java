import java.time.LocalDate;
import java.util.*;
public abstract class Customer {
    protected String firstName;
    protected String lastName;
//    protected String address;
//    protected String phoneNumber;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public abstract String getFullName();
    public abstract boolean addToCart(Menu menuItem, int qty, String startDate);

    abstract Order makeOrder(LocalDate orderDate, LocalDate endDate, double subTotal, double shippingFee, double discount, double total);

    abstract void confirmPay(int orderNumber);
}
