package by.hotel.bean;

/**
 * Created by 1 on 06.04.2017.
 */
public class Payment {
    private int id;
    private int count_paid_days;
    private int sum;
    private Discount discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount_paid_days() {
        return count_paid_days;
    }

    public void setCount_paid_days(int count_paid_days) {
        this.count_paid_days = count_paid_days;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
