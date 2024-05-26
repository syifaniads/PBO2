import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Member extends Customer {
    private String id;
    private LocalDate membershipDate;
    private int startBalance;
    private Map<String, CartItem> cart = new HashMap<>();
    private Map<Menu, Integer> cartCO;
    public Member(String id, String firstName, String lastName, LocalDate membershipDate, int balance) {
        super(firstName, lastName, balance);
        this.id = id;
        this.membershipDate = membershipDate;
        this.startBalance = balance;
    }

    public Map<Menu, Integer> getCart() {
        return cartCO;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int getBalance() {
        return startBalance;
    }

    @Override
    public void topUp(int amount) {
        startBalance += amount;
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
    public boolean removeFromCart(Menu menuItem, int qty, String startDate) {
         String key = menuItem.IDMenu + (startDate != null ? startDate : "");
         if (!cart.containsKey(key)) {
             return false;
         }

         CartItem cartItem = cart.get(key);
         cartItem.qty -= qty;
         if (cartItem.qty <= 0) {
             cart.remove(key);
             System.out.println("REMOVE_FROM_CART SUCCESS: " + cartItem.menuItem.NamaMenu + " IS REMOVED");
         } else {
             System.out.println("REMOVE_FROM_CART SUCCESS: " + cartItem.menuItem.NamaMenu + " QUANTITY IS DECREMENTED");
         }
         return true;
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
