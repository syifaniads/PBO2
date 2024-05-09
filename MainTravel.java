import java.time.LocalDate;
import java.util.Scanner;

public class MainTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=".repeat(52));
        System.out.println("=".repeat(15) + "FILKOM TRAVEL" + "=".repeat(15));
        System.out.println("=".repeat(52));
        System.out.println("[Type 1] Sign in as member");
        System.out.println("[Type 2] Guest");
        System.out.print("Enter option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.print("Input First Name:  ");
                String firstName = scanner.nextLine();
                System.out.print("Input Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Input membership date (yyyy-MM-dd): ");
                LocalDate membershipDate = LocalDate.parse(scanner.nextLine());
                Member pelanggan = new Member(firstName, lastName, membershipDate);
                System.out.println("=".repeat(52));
                System.out.println("CONTINUE?");
                System.out.println("[Type 1] Yes");
                System.out.println("[Type 2] No");
                System.out.print("Enter option: ");
                int pilihan1 = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (pilihan1 == 1) {
                    System.out.println("What do you want to rent?");
                    System.out.println("[Type 1] Rent a car");
                    System.out.println("[Type 2] Book a travel");
                    System.out.print("Enter option: ");
                    int pilihan3 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (pilihan3 == 1) {
                        System.out.println("Car list: ");
                        AutoMobile mobil = new AutoMobile("Mobil", "N 1234 AAA", 5, true);
                        System.out.println("Car: " + mobil.getBrand() + "\nNumber Plate: " + mobil.getNumberPlat());
                        System.out.println("Available chair:");
                        mobil.displayAvailableChairs();
                        mobil.setChairs();

                        System.out.println("Choose a chair");
                        System.out.print("Row: ");
                        int row = scanner.nextInt();
                        System.out.print("Column: ");
                        int column = scanner.nextInt();
                        scanner.nextLine();
                        if (mobil.isSeatAvailable(row, column)) {
                            mobil.bookSeat(row, column);
                            System.out.println("Kursi " + row + " " + column + " berhasil dipesan.");
                        } else {
                            System.out.println("Kursi " + row + " " + column + " sudah dipesan atau tidak valid.");
                        }

                        System.out.print("Input pick up address: ");
                        String pickUpAddress = scanner.nextLine();
                        System.out.println("=".repeat(52));
                        System.out.println("Customer's name: " + pelanggan.getFullName());
                        System.out.println("Pick up address: " + pickUpAddress);
                        System.out.println("Car: " + mobil.getBrand() + "\nNumber Plate: " + mobil.getNumberPlat());
                        System.out.println("Chair: " + row + " " + column);
                    }
                    else if(pilihan3 == 2){
                        AutoMobile mobil1 = new AutoMobile("Mobil", "N 1234 AAA", 5, true);
                        System.out.println("Choose your destination");
                        System.out.println("1. Surabaya");
                        System.out.println("2. Jogja");
                        System.out.println("3. Bali");
                        System.out.println("4. Solo");
                        System.out.print("Input your destination: ");
                        String destination = scanner.nextLine();

                        System.out.println("Available chair:");
                        mobil1.displayAvailableChairs();
                        mobil1.setChairs();
                        System.out.println("Choose a chair");
                        System.out.print("Row: ");
                        int row = scanner.nextInt();
                        System.out.print("Column: ");
                        int column = scanner.nextInt();
                        scanner.nextLine();
                        if (mobil1.isSeatAvailable(row, column)) {
                            mobil1.bookSeat(row, column);
                            System.out.println("Kursi " + row + " " + column + " berhasil dipesan.");
                        } else {
                            System.out.println("Kursi " + row + " " + column + " sudah dipesan atau tidak valid.");
                        }

                        System.out.print("Input pick up address: ");
                        String pickUpAddress = scanner.nextLine();
                        System.out.println("=".repeat(52));
                        System.out.println("Customer's name: " + pelanggan.getFullName());
                        System.out.println("Destination: " + destination);
                        System.out.println("Pick up address: " + pickUpAddress);
                        System.out.println("Car: " + mobil1.getBrand() + "\nNumber Plat: " + mobil1.getNumberPlat());
                        System.out.println("Chair: " + row + " " + column);
                    }
                } else {
                    System.out.println("Thank you!");
                }
                break;
            case 2:
                System.out.println("=".repeat(52));
                System.out.println("=".repeat(21) + "GUEST" + "=".repeat(21));
                System.out.println("=".repeat(52));
                System.out.print("Input First Name:  ");
                String firstName1 = scanner.nextLine();
                System.out.print("Input Last Name: ");
                String lastName1 = scanner.nextLine();
                Guest tamu = new Guest(firstName1, lastName1);
                System.out.println("=".repeat(52));
                System.out.println("CONTINUE?");
                System.out.println("[Type 1] Yes");
                System.out.println("[Type 2] No");
                System.out.print("Enter option: ");
                int pilihan4 = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (pilihan4 == 1) {
                    System.out.println("What do you want to rent?");
                    System.out.println("[Type 1] Rent a car");
                    System.out.println("[Type 2] Book a travel");
                    System.out.print("Enter option: ");
                    int pilihan6 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (pilihan6 == 1) {
                        System.out.println("Car List:  ");
                        AutoMobile mobil2 = new AutoMobile("Mobil", "N 1234 AAA", 5, true);
                        System.out.println("Available chair:");
                        mobil2.displayAvailableChairs();
                        mobil2.setChairs();
                        System.out.println("Choose a chair");
                        System.out.print("Row: ");
                        int row = scanner.nextInt();
                        System.out.print("Column: ");
                        int column = scanner.nextInt();
                        scanner.nextLine();
                        if (mobil2.isSeatAvailable(row, column)) {
                            mobil2.bookSeat(row, column);
                            System.out.println("Kursi " + row + " " + column + " berhasil dipesan.");
                        } else {
                            System.out.println("Kursi " + row + " " + column + " sudah dipesan atau tidak valid.");
                        }
                        System.out.print("Input pick up address: ");
                        String pickUpAddress = scanner.nextLine();
                        System.out.println("=".repeat(52));
                        System.out.println("Customer's name: " + tamu.getFullName());
                        System.out.println("Pick up address: " + pickUpAddress);
                        System.out.println("Car: " + mobil2.getBrand() + "\nNumber Plate: " + mobil2.getNumberPlat());
                        System.out.println("Chair: " + row + " " + column);
                    }
                    else if(pilihan6 == 2){
                        AutoMobile mobil3 = new AutoMobile("Mobil", "N 1234 AAA", 5, true);
                        System.out.println("Choose your destination");
                        System.out.println("1. Surabaya");
                        System.out.println("2. Jogja");
                        System.out.println("3. Bali");
                        System.out.println("4. Solo");
                        System.out.print("Input your destination: ");
                        String destination1 = scanner.nextLine();

                        System.out.println("Available chair:");
                        mobil3.displayAvailableChairs();
                        mobil3.setChairs();
                        System.out.println("Choose a chair");
                        System.out.print("Row: ");
                        int row = scanner.nextInt();
                        System.out.print("Column: ");
                        int column = scanner.nextInt();
                        scanner.nextLine();
                        if (mobil3.isSeatAvailable(row, column)) {
                            mobil3.bookSeat(row, column);
                            System.out.println("Kursi " + row + " " + column + " berhasil dipesan.");
                        } else {
                            System.out.println("Kursi " + row + " " + column + " sudah dipesan atau tidak valid.");
                        }

                        System.out.print("Input pick up address: ");
                        String pickUpAddress = scanner.nextLine();
                        System.out.println("=".repeat(52));
                        System.out.println("Customer's name: " + tamu.getFullName());
                        System.out.println("Destination: " + destination1);
                        System.out.println("Pick up address: " + pickUpAddress);
                        System.out.println("Car: " + mobil3.getBrand() + "\nNumber Plat: " + mobil3.getNumberPlat());
                        System.out.println("Chair: " + row + " " + column);
                    }
                } else {
                    System.out.println("Thank you!");
                }
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}
