import java.util.*;

class Member extends Pelanggan {
    private Date membershipDate;

    public Member(String firstName, String lastName, Date membershipDate) {
        super(firstName, lastName);
        this.membershipDate = membershipDate;
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
        System.out.println("Konfirmasi pembayaran pesanan " + orderNumber + " oleh member " + getFullName());
    }

    public long getMembershipDuration() {
        Date today = new Date();
        long diffInMillies = Math.abs(today.getTime() - membershipDate.getTime());
        return diffInMillies / (1000 * 60 * 60 * 24); // Konversi dari milisecond ke hari
    }

}
