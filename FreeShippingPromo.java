public class FreeShippingPromo extends Promotion {
    @Override
    double calculateDiscount(Order order) {
        // hitung potongan ongkos kirim
        return 0;
    }

    @Override
    public int compareTo(Promotion o) {
        return 0;
    }

    @Override
    public boolean isCustomerEligible(Pelanggan customer) {
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
        return 0;
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
