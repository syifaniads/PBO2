import java.util.Date;

class Guest extends Costumer {

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }
    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    Order makeOrder(Date orderDate, double subTotal, double shippingFee, double discount) {
        return new Order(orderDate, subTotal, shippingFee, discount);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Konfirmasi pembayaran pesanan " + orderNumber + " sebagai guest.");
    }
}

