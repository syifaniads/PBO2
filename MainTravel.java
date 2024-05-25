/*
* 235150201111062 LATIFA ANGGIA FITRIANA
* 235150201111060 MAULIA DWI ANTHESA SUGEHA
* 235150207111052 SYIFANI ADILLAH SALSABILA
* 215150207111031 KUSUMA ANISA ANGGRANI
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=".repeat(52));
        System.out.println("=".repeat(20) + "FILKOM TRAVEL" + "=".repeat(19));
        System.out.println("=".repeat(52));
        System.out.println("[Type 1] Sign in as member");
        System.out.println("[Type 2] Guest");
        System.out.print("Enter option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:         //member
                handleMember(scanner);
            case 2:         //guest
                handleGuest(scanner);
            default:
                System.out.println("Invalid option.");
                break;
        }
        scanner.close();
    }

    private static void handleMember(Scanner scanner){
        String input = scanner.nextLine();
        Member pelanggan = null;
        if(input.startsWith("CREATE MEMBER ")) {
            String[] part = input.substring(13).split("\\|");
            if(part.length == 4){
                String id = part[0];
                String name = part[1];
                LocalDate membershipDate = LocalDate.parse(part[2], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                int startBalance = Integer.parseInt(part[3]);

                if(!isMemberExist(id)) {
                    String[] fullname = name.split(" ");
                    String firstName = fullname[0];
                    String lastName = fullname.length > 1 ? fullname[1] : "";
                    pelanggan = new Member(id, firstName, lastName, membershipDate, startBalance);
                    System.out.println(pelanggan);
                }
                else System.out.println("CREATE MEMBER FAILED: " + id + " IS EXISTS");
            }
            else System.out.println("Invalid input format. Please use: CREATE MEMBER IDAnggota|Nama|TanggalDaftar|SaldoAwal");
        }
        else System.out.println("Invalid input. Please start with 'CREATE MEMBER '");

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
                System.out.print("Rent date (yyyy-MM-dd): ");
                LocalDate rentDateMember = LocalDate.parse(scanner.nextLine());
                System.out.print("Rental end date (yyyy-MM-dd): ");
                LocalDate endDateMember = LocalDate.parse(scanner.nextLine());
                System.out.println("Car list: ");
                AutoMobile mobil = new AutoMobile("Avanza", "N 1234 AAA", 5, true, 800000);
                System.out.println("Car: " + mobil.getBrand() + "\nLicense Plate: " + mobil.getNumberPlat());

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
                    System.out.println("Chair " + row + " " + column + " is successfully booked.");
                }
                else {
                    System.out.println("Chair " + row + " " + column + " is reserved or invalid.");
                }

                System.out.print("Input address: ");
                String pickUpAddress = scanner.nextLine();
                double subTotalMember = mobil.getPrice();
                double shipFeeMember;
                double discountMember = 0;
                System.out.println("Choose your rental service: ");
                System.out.println("[Type 1] Deliver the car to your address");
                System.out.println("[Type 2] Pick up yourself");
                System.out.print("Enter option: ");
                int serviceOption = scanner.nextInt();
                if(serviceOption == 1){
                    String[] rangeService= {" 5Km <= range <= 10Km: Rp 10000",
                            " 11Km <= range <= 20Km: Rp 25000 ",
                            "range >= 30Km: Rp 50000"};
                    for (int i=0; i < rangeService.length; i++){
                        System.out.println((i+1)+". "+ rangeService[i]);
                    }
                    System.out.print("Set a range (Km): ");
                    int inputRange= scanner.nextInt();
                    if (inputRange >= 5 && inputRange <= 10){
                        shipFeeMember = 10000;
                    }
                    else if(inputRange >=11 && inputRange <=20){
                        shipFeeMember = 25000;
                    }
                    else if(inputRange >= 30){
                        shipFeeMember = 50000;
                    }
                    else{
                        shipFeeMember = 0;
                    }
                }
                else {
                    shipFeeMember = 0;
                }
                if (pelanggan.isEligibleForDiscount()) {

                    // Jika member memenuhi syarat untuk diskon 20%
                    // Lakukan pengurangan 20% dari total pembayaran

                    discountMember = subTotalMember * 0.20;
//                            subTotalMember -= discountMember;
                    System.out.println("Member eligible for 20% discount!");
                }
                else {
                    discountMember = 0;
                }
                double totalRentMember = 0;
                PercentOffPromo percentOffPromo = new PercentOffPromo();
                CashbackPromo cashbackPromo = new CashbackPromo();
                FreeShippingPromo freeShippingPromo = new FreeShippingPromo();
//                        double discountMember = percentOffPromo() + cashbackPromo() + freeShippingPromo();
                Order order = new Order(rentDateMember, endDateMember, subTotalMember, shipFeeMember, discountMember, totalRentMember);

                // nota
                System.out.println("=".repeat(52));
                System.out.println("Customer's name: " + pelanggan.getFullName());
                System.out.println("Pick up address: " + pickUpAddress);
                System.out.println("Car: " + mobil.getBrand() + "\nLicense Plate: " + mobil.getNumberPlat());
                System.out.println("Chair: " + row + " " + column);

                // Terapkan promosi ke dalam pesanan
//                        order.applyPromo(percentOffPromo); // Terapkan promo diskon persentase
//                        order.applyPromo(cashbackPromo); // Terapkan promo cashback
//                        order.applyPromo(freeShippingPromo); // Terapkan promo gratis pengiriman
                order.printDetails();
//                        try {
//                            // Hitung total pembayaran setelah promosi
//                            double totalPayment = order.applyPromo(cashbackPromo);
//                            System.out.println("Total payment after promotion: " + totalPayment);
//                        } catch (Exception e) {
//                            System.out.println("Failed to calculate the total payment: " + e.getMessage());
//                        }
                System.out.println("=".repeat(52));
                order.checkOut();
                pelanggan.confirmPay(order.orderNumber);
                order.pay();
            }
            else if(pilihan3 == 2){
                AutoMobile mobil1 = new AutoMobile("Avanza", "N 1234 AAA", 5, true, 800000);
                double shipFeeTravel1;
                System.out.print("Rent date (yyyy-MM-dd): ");
                LocalDate rentDateMember = LocalDate.parse(scanner.nextLine());
                System.out.print("Rental end date (yyyy-MM-dd): ");
                LocalDate endDateMember = LocalDate.parse(scanner.nextLine());
                System.out.println("Choose your destination");
                System.out.println("1. Surabaya");
                System.out.println("2. Jogja");
                System.out.println("3. Bali");
                System.out.println("4. Solo");
                System.out.print("Input your destination: ");
                String destination = scanner.nextLine();
                System.out.println("Choose your rental service: ");
                System.out.println("[Type 1] We pick you up");
                System.out.println("[Type 2] Come to the meeting place");
                System.out.print("Enter option: ");
                int serviceOption = scanner.nextInt();
                if(serviceOption == 1){
                    String[] rangeService= {" 5Km <= range <= 10Km: Rp 10000", " 11Km <= range <= 20Km: Rp 25000 ", "range >= 30Km: Rp 50000"};
                    for (int i=0; i < rangeService.length; i++){
                        System.out.println((i+1)+". "+ rangeService[i]);
                    }
                    System.out.print("Set a range (Km): ");
                    int inputRange= scanner.nextInt();
                    if (inputRange >= 5 && inputRange <= 10 ){
                        shipFeeTravel1 = 10000;
                    }
                    else if(inputRange >=11 && inputRange <=20){
                        shipFeeTravel1 = 25000;
                    }
                    else if(inputRange>= 30){
                        shipFeeTravel1= 500000;
                    }
                    else{
                        shipFeeTravel1 = 0;
                    }
                }
                else {
                    shipFeeTravel1 = 0;
                }

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
                    System.out.println("Chair " + row + " " + column + " is successfully booked.");
                } else {
                    System.out.println("Chair " + row + " " + column + " is reserved or invalid.");
                }

                System.out.print("Input pick up address: ");
                String pickUpAddress = scanner.nextLine();
                double subTotalTravel1;
                if(destination.equals("Surabaya")){
                    subTotalTravel1 = 150000;
                } else if (destination.equals("Jogja")) {
                    subTotalTravel1 = 250000;
                } else if (destination.equals("Bali")) {
                    subTotalTravel1 = 600000;
                } else if (destination.equals("Solo")) {
                    subTotalTravel1 = 230000;
                }
                else{
                    subTotalTravel1 = 0;
                }
                double discountTravel1 = 0;
                if (pelanggan.isEligibleForDiscount()) {
                    discountTravel1 += subTotalTravel1 * 0.20;
//                            subTotalTravel1 -= discountTravel1;
                    System.out.println("Member eligible for 20% discount!");
                }
                else{
                    discountTravel1 = 0;
                }
                double totalTravel1=0;
                Order order = new Order(rentDateMember, endDateMember, subTotalTravel1, shipFeeTravel1, discountTravel1, totalTravel1);
                System.out.println("=".repeat(52));
                System.out.println("Customer's name: " + pelanggan.getFullName());
                System.out.println("Destination: " + destination);
                System.out.println("Pick up address: " + pickUpAddress);
                System.out.println("Car: " + mobil1.getBrand() + "\nLicense Plate: " + mobil1.getNumberPlat());
                System.out.println("Chair: " + row + " " + column);
                order.printDetails();
                System.out.println("=".repeat(52));
                order.checkOut();
                pelanggan.confirmPay(order.orderNumber);
                order.pay();
            }
        }
        else System.out.println("Thank you!");
    }

    private static void handleGuest(Scanner scanner) {
//        System.out.println("=".repeat(52));
//        System.out.println("=".repeat(21) + "GUEST" + "=".repeat(21));
//        System.out.println("=".repeat(52));
        String input = scanner.nextLine();
        Guest tamu = null;
        if(input.startsWith("CREATE GUEST ")) {
            String[] part = input.substring(13).split("\\|");
            if(part.length == 2) {
                String id = part[0];
                int startBalance = Integer.parseInt(part[1]);
                if(!isGuestExist(id)) {
                    tamu = new Guest(id, startBalance);
                    System.out.println(tamu);
                }
                else System.out.println("CREATE GUEST FAILED:" + id + " IS EXISTS");
            }
            else System.out.println("Invalid input format. Please use: CREATE GUEST IDTamu|SaldoAwal");
        }
        else System.out.println("Invalid input. Please start with 'CREATE GUEST '");

//        System.out.print("Input First Name:  ");
//        String firstName1 = scanner.nextLine();
//        System.out.print("Input Last Name: ");
//        String lastName1 = scanner.nextLine();
//        Guest tamu = new Guest(firstName1, lastName1);
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
                System.out.print("Rent date (yyyy-MM-dd): ");
                LocalDate rentDateGuest = LocalDate.parse(scanner.nextLine());
                System.out.print("Rental end date (yyyy-MM-dd): ");
                LocalDate endDateGuest = LocalDate.parse(scanner.nextLine());
                System.out.println("Car List:  ");
                AutoMobile mobil2 = new AutoMobile("Avanza", "N 1234 AAA", 5, true, 800000);
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
                    System.out.println("Chair " + row + " " + column + " is successfully booked.");
                } else {
                    System.out.println("Chair " + row + " " + column + " is reserved or invalid.");
                }
                System.out.print("Input address: ");
                String pickUpAddress = scanner.nextLine();
                double subTotalGuest = mobil2.getPrice();
                double shipFeeGuest;
                double discountGuest = 0;
                double totalRentGuest = 0;
                System.out.println("Choose your rental service: ");
                System.out.println("[Type 1] Deliver the car to your address");
                System.out.println("[Type 2] Pick up yourself");
                System.out.print("Enter option: ");
                int serviceOption = scanner.nextInt();
                if(serviceOption == 1){
                    String[] rangeService= {" 5Km <= range <= 10Km: Rp 10000", " 11Km <= range <= 20Km: Rp 25000 ", "range >= 30Km: Rp 50000"};
                    for (int i=0; i < rangeService.length; i++){
                        System.out.println((i+1)+". "+ rangeService[i]);
                    }
                    System.out.print("Set a range (Km): ");
                    int inputRange= scanner.nextInt();
                    if (inputRange >= 5 && inputRange <= 10 ){
                        shipFeeGuest = 10000;
                    }
                    else if(inputRange >=11 && inputRange <=20){
                        shipFeeGuest = 25000;
                    }
                    else if(inputRange >= 30){
                        shipFeeGuest = 500000;
                    }
                    else{
                        shipFeeGuest =0;
                    }
                }
                else {
                    shipFeeGuest = 0;
                }
                Order order = new Order(rentDateGuest, endDateGuest, subTotalGuest, shipFeeGuest, discountGuest, totalRentGuest);
                System.out.println("=".repeat(52));
                System.out.println("Customer's name: " + tamu.getFullName());
                System.out.println("Pick up address: " + pickUpAddress);
                System.out.println("Car: " + mobil2.getBrand() + "\nLicense Plate: " + mobil2.getNumberPlat());
                System.out.println("Chair: " + row + " " + column);
                order.printDetails();
                System.out.println("=".repeat(52));
                order.checkOut();
                tamu.confirmPay(order.orderNumber);
                order.pay();
            }
            else if(pilihan6 == 2){
                double shippingFeeTravel2;
                AutoMobile mobil3 = new AutoMobile("Avanza", "N 1234 AAA", 5, true, 800000);
                System.out.println("Rent date (yyyy-MM-dd): ");
                LocalDate rentDateGuest = LocalDate.parse(scanner.nextLine());
                System.out.print("Rental end date (yyyy-MM-dd): ");
                LocalDate endDateGuest = LocalDate.parse(scanner.nextLine());
                System.out.println("Choose your destination");
                System.out.println("1. Surabaya");
                System.out.println("2. Jogja");
                System.out.println("3. Bali");
                System.out.println("4. Solo");
                System.out.print("Input your destination: ");
                String destination1 = scanner.nextLine();
                System.out.println("Choose your rental service: ");
                System.out.println("[Type 1] We pick you up");
                System.out.println("[Type 2] Come to the meeting place");
                System.out.print("Enter option: ");
                int serviceOption = scanner.nextInt();
                if(serviceOption == 1){
                    String[] rangeService= {" 5Km <= range <= 10Km: Rp 10000", " 11Km <= range <= 20Km: Rp 25000 ", "range >= 30Km: Rp 50000"};
                    for (int i=0; i < rangeService.length; i++){
                        System.out.println((i+1)+". "+ rangeService[i]);
                    }
                    System.out.print("Set a range (Km): ");
                    int inputRange= scanner.nextInt();
                    if (inputRange >= 5 && inputRange <= 10 ){
                        shippingFeeTravel2 = 10000;
                    }
                    else if(inputRange >=11 && inputRange <=20){
                        shippingFeeTravel2 = 25000;
                    }
                    else if(inputRange >= 30){
                        shippingFeeTravel2= 500000;
                    }
                    else{
                        shippingFeeTravel2 = 0;
                    }
                }
                else {
                    shippingFeeTravel2 = 0;
                }

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
                    System.out.println("Chair " + row + " " + column + " is successfully booked.");
                } else {
                    System.out.println("Chair " + row + " " + column + " is reserved or invalid.");
                }

                System.out.print("Input pick up address: ");
                String pickUpAddress = scanner.nextLine();
                double subTotalGuest = mobil3.getPrice();
                double subTotalTravel2;
                if(destination1.equals("Surabaya")){
                    subTotalTravel2 = 150000;
                } else if (destination1.equals("Jogja")) {
                    subTotalTravel2 = 250000;
                } else if (destination1.equals("Bali")) {
                    subTotalTravel2 = 600000;
                } else if (destination1.equals("Solo")) {
                    subTotalTravel2 = 230000;
                }
                else {
                    subTotalTravel2 = 0;
                }
                double discountGuest = 0;
                double totalGuest = subTotalGuest + subTotalTravel2;
                double totalTravel2 = 0;
                Order order = new Order(rentDateGuest, endDateGuest, totalGuest, shippingFeeTravel2, discountGuest, totalTravel2);
                System.out.println("=".repeat(52));
                System.out.println("Customer's name: " + tamu.getFullName());
                System.out.println("Destination: " + destination1);
                System.out.println("Pick up address: " + pickUpAddress);
                System.out.println("Car: " + mobil3.getBrand() + "\nLicense Plate: " + mobil3.getNumberPlat());
                System.out.println("Chair: " + row + " " + column);
                order.printDetails();
                System.out.println("=".repeat(52));
                order.checkOut();
                tamu.confirmPay(order.orderNumber);
                order.pay();
            }
        }
        else System.out.println("Thank you!");
    }

    private static boolean isMemberExist(String id) {
        //dummy apakah member udah ada di database belum gtw gmn kodenya
        return false;
    }

    public static boolean isGuestExist(String id) {
        //dummy apakah guest udah ada di database belum gtw gmn kodenya
        return false;
    }
}
