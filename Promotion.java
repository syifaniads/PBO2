import java.util.Date;

abstract class Promotion implements Applicable, Comparable<Promotion> {
    String promoCode;
    Date startDate;
    Date endDate;

    abstract double calculateDiscount(Order order);
}
