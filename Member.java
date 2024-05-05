import java.util.*;

class Member extends Pelanggan {
    Date membershipDate;

    @Override
    String getFullName() {
        return firstName + " " + lastName;
    }

    long getMembershipDuration() {
        // hitung durasi keanggotaan
        return 0;
    }

}
