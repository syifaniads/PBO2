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

    abstract Order makeOrder(LocalDate orderDate, double subTotal, double shippingFee, double discount, double total);

    abstract void confirmPay(int orderNumber);
}
