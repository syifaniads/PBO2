import java.util.Date;

abstract class Promotion implements Applicable, Comparable<Promotion> {
    String promoCode;
    Date startDate;
    Date endDate;

    @Override
    public boolean isCustomerEligible(Customer customer) {
        // Umur akun lebih dari 30 hari
        if (customer instanceof Guest) {
            return false; // Guest tidak berlaku
        } else if (customer instanceof Member) {
            long membershipDuration = ((Member) customer).getMembershipDuration();
            return membershipDuration > 30;
        }
        return false;
    }
    @Override
    public abstract boolean isMinimumPriceEligible(Order order);

    @Override
    public abstract boolean isShippingFeeEligible(Order order);

    @Override
    public abstract double calculateTotalDiscount(Order order) throws Exception;

    @Override
    public abstract double calculateTotalCashback(Order order) throws Exception;

    @Override
    public abstract double calculateTotalShippingFeeDiscount(Order order) throws Exception;

    public int compareTo(Promotion o) {
        // Implementasi perbandingan berdasarkan tanggal mulai
        return this.startDate.compareTo(o.startDate);
    }
}
