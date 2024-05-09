public class AutoMobile {
    private String brand;
    private String numberPlat;
    private boolean airConditioner;
    private int quantity;
    private boolean[][] chairs;
    private double price;

    public AutoMobile(String brand, String numberPlat, int quantity, boolean airConditioner, double price) {
        this.brand = brand;
        this.numberPlat = numberPlat;
        this.quantity = quantity;
        this.airConditioner = airConditioner;
        this.price = price;
        setChairs();
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
    public void displayAvailableChairs() {
        System.out.print("| ");
        System.out.print(chairs[0][0] ? 1 : 0);
        System.out.println(" |");
        for (int i = 1; i < chairs.length; i++) {
            for (int j = 0; j < chairs[i].length; j++) {
                System.out.print("| ");
                System.out.printf("%s ", chairs[i][j] ? 1 : 0);
            }
            System.out.println("|");
        }
    }

    public void setChairs() {
        int rows = (quantity - 1) / 3 + 1;
        chairs = new boolean[rows][3];
        for (boolean[] row : chairs) {
            for (int j = 0; j < row.length; j++) {
                row[j] = false;
            }
        }
    }

    public boolean isSeatAvailable(int row, int column) {
        if (row >= 0 && row < chairs.length && column >= 0 && column < chairs[row].length) {
            return !chairs[row][column];
        }
        return false;
    }

    public void bookSeat(int row, int column) {
        if (row >= 0 && row < chairs.length && column >= 0 && column < chairs[row].length) {
            chairs[row][column] = true;
        }
    }
}
