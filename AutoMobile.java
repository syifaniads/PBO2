public class AutoMobile {
    private String brand;
    private String numberPlat;
    private boolean airConditioner;
    private int quantity;
    private boolean[][] chairs;

    public AutoMobile(String brand, String numberPlat, int quantity, boolean airConditioner) {
        this.brand = brand;
        this.numberPlat = numberPlat;
        this.quantity = quantity;
        this.airConditioner = airConditioner;
        setChairs();
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

    private void setChairs() {
        int rows = (quantity - 1) / 3 + 1;
        chairs = new boolean[rows][3];
        for (boolean[] row : chairs) {
            for (int j = 0; j < row.length; j++) {
                row[j] = false;
            }
        }
    }
}
        
