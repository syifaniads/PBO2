public class FreeShippingPromo extends Promotion {
    double shippingFeeDiscount;
//    @Override
//    double calculateDiscount(Order order) {
//        // hitung potongan ongkos kirim
//        return 0;
//    }

    @Override
    public int compareTo(Promotion o) {
        return 0;
    }

    @Override
    public String getPromoCode() {
        return this.promoCode;
    }

    @Override
    public boolean isCustomerEligible(Customer customer) {
        return false;
    }

    @Override
    public boolean isMinimumPriceEligible(Order order) {
        return false;
    }

    @Override
    public boolean isShippingFeeEligible(Order order) {
        return false;
    }

    @Override
    public double calculateTotalDiscount(Order order) throws Exception {
        double totalDiscount = order.shippingFee - shippingFeeDiscount ;
        return totalDiscount;
    }

    @Override
    public double calculateTotalCashback(Order order) throws Exception {
        return 0;
    }

    @Override
    public double calculateTotalShippingFeeDiscount(Order order) throws Exception {
        return 0;
    }
}
