import java.util.Date;

class Guest extends Pelanggan {

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }
    @Override
    String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    Order makeOrder(Date orderDate, int orderNumber, double subTotal, double shippingFee, double discount) {
        return new Order(orderDate, orderNumber, subTotal, shippingFee, discount);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Konfirmasi pembayaran pesanan " + orderNumber + " sebagai guest.");
    }
}
