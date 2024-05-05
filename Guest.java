class Guest extends Pelanggan {
    @Override
    String getFullName() {
        return firstName + " " + lastName;
    }
}
