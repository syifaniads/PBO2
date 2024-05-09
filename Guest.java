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
    Order makeOrder(LocalDate orderDate, LocalDate endDate, double subTotal, double shippingFee, double discount, double total) {
        return new Order(orderDate, endDate, subTotal, shippingFee, discount, total);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Confirmation of payment for order " + orderNumber + " as a guest.");
    }
}
