public abstract class Pelanggan {
    String firstName;
    String lastName;

    abstract String getFullName();

    Order makeOrder() {
        return new Order();
    }

    void confirmPay(int orderNumber) {
        // implementasi konfirmasi pembayaran
    }
}
