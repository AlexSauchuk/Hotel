package by.hotel.builder;

import by.hotel.bean.Discount;
import by.hotel.bean.Reservation;
import by.hotel.bean.User;

import java.sql.Date;

public class ReservationBuilder {
    private int id;
    private Date dateIn;
    private Date dateOut;
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
        this.dateIn = dateIn;
        return this;
    }

    public ReservationBuilder dateOut(Date dateOut){
        this.dateOut = dateOut;
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

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
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
