package by.hotel.builder;

import by.hotel.bean.Discount;

public class DiscountBuilder {
    private int id;
    private String name;

    public DiscountBuilder id(int id){
        this.id = id;
        return this;
    }

    public DiscountBuilder name(String name){
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Discount build(){
        return new Discount(this);

    }
}
