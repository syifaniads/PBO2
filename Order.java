import java.util.*;
public class Order {
        Date orderDate;
        int orderNumber;
        double subTotal;
        double shippingFee;
        double discount;
        double total;
        Status status;
        Promotion promotion;

        public Order(Date orderDate, int orderNumber, double subTotal, double shippingFee, double discount) {
                this.orderDate = orderDate;
                this.orderNumber = orderNumber;
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
                System.out.println("Tanggal Pesanan: " + orderDate);
                System.out.println("Nomor Pesanan: " + orderNumber);
                System.out.println("Pesanan:");
//                System.out.println("   - Kendaraan: " + vehicle.getType());
//                System.out.println("   - Kuantitas: " + quantity);
                System.out.println("   - Sub Total: " + subTotal);
                System.out.println("   - Ongkos Kirim: " + shippingFee);
                System.out.println("   - Diskon: " + discount);
                System.out.println("   - Total: " + total);
                if (promotion != null) {
//                        System.out.println("Promosi: " + promotion.getPromoCode());
                }
                else {
                        System.out.println("Promosi: Tidak ada");
                }
        }

        public void applyPromo(Promotion promo) {
                this.promotion = promo;
                try {
                        this.discount = promo.calculateDiscount(this);
                        this.total = subTotal + shippingFee - discount;
                }
                catch (Exception e){
                        System.out.println("Gagal menggunakan promosi.");
                        e.printStackTrace();
                }
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
