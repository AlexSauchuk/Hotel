package by.hotel.builder;

import by.hotel.bean.Discount;
import by.hotel.bean.Reservation;
import by.hotel.bean.User;

import java.util.Date;

public class ReservationBuilder {
    private int id;
    private String dateIn;
    private String dateOut;
    private User user;
    private int costAdditionalServices;
    private Discount discount;

    public ReservationBuilder id(int id){
        this.id = id;
        return this;
    }

    public ReservationBuilder user(User user){
        this.user = user;
        return this;
    }

    public ReservationBuilder dateIn(Date dateIn){
        this.dateIn = dateIn.toString();
        return this;
    }

    public ReservationBuilder dateOut(Date dateOut){
        this.dateOut = dateOut.toString();
        return this;
    }

    public ReservationBuilder costAdditionalServices(int costAdditionalServices){
        this.costAdditionalServices = costAdditionalServices;
        return this;
    }

    public ReservationBuilder discount(Discount discount){
        this.discount = discount;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public User getUser() {
        return user;
    }

    public int getCostAdditionalServices() {
        return costAdditionalServices;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Reservation build(){
        return new Reservation(this);
    }
}
