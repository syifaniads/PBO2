import java.util.*;
public abstract class Costumer {
    protected String firstName;
    protected String lastName;
//    protected String address;
//    protected String phoneNumber;

    public Costumer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public abstract String getFullName();

    abstract Order makeOrder(Date orderDate, double subTotal, double shippingFee, double discount);

    abstract void confirmPay(int orderNumber);
}
