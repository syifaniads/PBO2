import java.time.LocalDate;
import java.util.Date;

class Member extends Customer {
    private LocalDate membershipDate;

    public Member(String firstName, String lastName, LocalDate membershipDate) {
        super(firstName, lastName);
        this.membershipDate = membershipDate;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public Order makeOrder(LocalDate orderDate, double subTotal, double shippingFee, double discount) {
        return new Order(orderDate, subTotal, shippingFee, discount);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Konfirmasi pembayaran pesanan " + orderNumber + " oleh member " + getFullName());
    }

    public long getMembershipDuration() {
        LocalDate today = LocalDate.now();
        return membershipDate.until(today).getDays();
    }

    public boolean isEligibleForDiscount() {
        LocalDate today = LocalDate.now();
        long membershipDuration = membershipDate.until(today).getDays();
        return membershipDuration > 100;
    }
}

