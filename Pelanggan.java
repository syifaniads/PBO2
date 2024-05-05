import java.util.*;
public abstract class Pelanggan {
    protected String firstName;
    protected String lastName;
//    protected String address;
//    protected String phoneNumber;

    public Pelanggan(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    abstract String getFullName();

    abstract Order makeOrder(Date orderDate, int orderNumber, double subTotal, double shippingFee, double discount);

    abstract void confirmPay(int orderNumber);
}
