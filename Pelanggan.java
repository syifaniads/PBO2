public abstract class Pelanggan {
    String firstName;
    String lastName;
    String address;
    String phoneNumber;

    abstract String getFullName();

    Order makeOrder() {
        return new Order();
    }

    void confirmPay(int orderNumber) {
        // implementasi konfirmasi pembayaran
    }
}
