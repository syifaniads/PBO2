public class Car {
    private String merek;
    private String noPlat;
    private boolean AC;
    private int kuantitas;
    boolean kursi[][];

    public Car(String merek, String noPlat, int kuantitas, boolean AC) {
        this.merek = merek;
        this.noPlat = noPlat;
        this.kuantitas = kuantitas;
        this.AC = AC;
        setkursi();
    }
    public void setkursi() {
        int row = (kuantitas - 1) / 3;
        kursi = new boolean[row + 1][3];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                kursi[i][j] = false;
            }
        }
    }
    public String getmerek() {
        return merek;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public void availablekursi() {
        int row = (kuantitas - 1) / 3;
        System.out.println("| " + (kursi[0][0] ? 1 : 0) + " |");
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("| %s |", (kursi[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }
}
