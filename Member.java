import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Member extends Customer {
    private String id;
    private LocalDate membershipDate;
    private int startBalance;
    private Map<String, CartItem> cart = new HashMap<>();

    public Member(String id, String firstName, String lastName, LocalDate membershipDate, int balance) {
        super(firstName, lastName);
        this.id = id;
        this.membershipDate = membershipDate;
        this.startBalance = balance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean addToCart(Menu menuItem, int qty, String startDate) {
        String key = menuItem.IDMenu + startDate;
        if (cart.containsKey(key)) {
            CartItem cartItem = cart.get(key);
            cartItem.qty += qty;
            return false; // Updated
        } else {
            cart.put(key, new CartItem(menuItem, qty, startDate));
            return true; // New
        }
    }

    @Override
    public Order makeOrder(LocalDate orderDate, LocalDate endDate, double subTotal, double shippingFee, double discount, double total) {
        return new Order(orderDate, endDate, subTotal, shippingFee, discount, total);
    }

    @Override
    void confirmPay(int orderNumber) {
        System.out.println("Confirmation of payment for order " + orderNumber + " by " + getFullName());
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

    public String toString() {
        return "CREATE MEMBER SUCCESS:" + id + " " + getFullName();
    }
}
