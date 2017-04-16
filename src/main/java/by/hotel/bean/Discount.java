package by.hotel.bean;

import by.hotel.builder.DiscountBuilder;

public class Discount {
    private int id;
    private String name;

    public Discount(){super();}

    public Discount(DiscountBuilder discountBuilder){
        this.id = discountBuilder.getId();
        this.name = discountBuilder.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
