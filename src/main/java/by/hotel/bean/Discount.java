package by.hotel.bean;

/**
 * Created by 1 on 04.04.2017.
 */
public class Discount {
    private int id;
    private DiscountType discountType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
