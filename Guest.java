import java.time.LocalDate;
import java.util.Date;

class Guest extends Customer {

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }
    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    Order makeOrder(LocalDate orderDate, double subTotal, double shippingFee, double discount) {
        return new Order(orderDate, subTotal, shippingFee, discount);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Konfirmasi pembayaran pesanan " + orderNumber + " sebagai guest.");
    }
}
