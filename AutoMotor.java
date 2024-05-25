public class AutoMotor {
    private String brand;
    private String numberPlat;
    private int quantity;
    private double price;

    public AutoMotor(String brand, String numberPlat, int quantity, double price) {
        this.brand = brand;
        this.numberPlat = numberPlat;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumberPlat() {
        return numberPlat;
    }
}
