import java.time.LocalDate;
import java.util.*;
public class Order {
        LocalDate orderDate;
        int orderNumber;
        double subTotal;
        double shippingFee;
        double discount;
        double total;
        Status status;
        Promotion promotion;

        public Order(LocalDate orderDate, double subTotal, double shippingFee, double discount) {
                this.orderDate = orderDate;
//                this.orderNumber = orderNumber;
                this.subTotal = subTotal;
                this.shippingFee = shippingFee;
                this.discount = discount;
                this.total = subTotal + shippingFee - discount;
//                this.vehicle = vehicle;
//                this.quantity = quantity;
        }

        // class Pelanggan harus diisi dari constructor
        public void checkOut() {
            if(status == Status.UNPAID){
                    status = Status.SUCCESSFUL;
            }
            else {
                    System.out.println("Pesanan telah dibayar atau dibatalkan.");
            }
        }

        public void printDetails() {
                System.out.println("Order Date: " + orderDate);
                System.out.println("Order Number: " + orderNumber);
                System.out.println("Order:");
//                System.out.println("   - Kendaraan: " + vehicle.getType());
//                System.out.println("   - Kuantitas: " + quantity);
                System.out.println("   - Sub Total: " + subTotal);
                System.out.println("   - Fee Shipping: " + shippingFee);
                System.out.println("   - Diskon: " + discount);
                System.out.println("   - Total: " + total);
                if (promotion != null) {
                        System.out.println("Promosi: " + promotion.getPromoCode());
                }
                else {
                        System.out.println("Promosi: Tidak ada");
                }
        }

        public double applyPromo(Promotion promo) {
                this.promotion = promo;
                try {
                        this.discount = promo.calculateTotalDiscount(this);
                        this.total = subTotal + shippingFee - discount;
                }
                catch (Exception e){
                        System.out.println("Gagal menggunakan promosi.");
                        e.printStackTrace();
                }
                return 0;
        }

        public void pay() {
            if(status == Status.SUCCESSFUL){
                    System.out.println("Pembayaran berhasil.");
                    status = Status.SUCCESSFUL;
            }
            else {
                    System.out.println("Pesanan belum dibayar.");
            }
        }
    }
