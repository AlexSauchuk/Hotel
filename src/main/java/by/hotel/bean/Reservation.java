package by.hotel.bean;

import by.hotel.builder.ReservationBuilder;

import java.sql.Date;

public class Reservation {
    private int id;
    private Date dateIn;
    private Date dateOut;
    private User user;
    private int costAdditionalServices;
    private Discount discount;

    public Reservation(){super();}

    public Reservation(ReservationBuilder reservationBuilder){
        this.id = reservationBuilder.getId();
        this.dateIn = reservationBuilder.getDateIn();
        this.dateOut = reservationBuilder.getDateOut();
        this.user = reservationBuilder.getUser();
        this.costAdditionalServices = reservationBuilder.getCostAdditionalServices();
        this.discount = reservationBuilder.getDiscount();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getCostAdditionalServices() {
        return costAdditionalServices;
    }

    public void setCostAdditionalServices(int costAdditionalServices) {
        this.costAdditionalServices = costAdditionalServices;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (costAdditionalServices != that.costAdditionalServices) return false;
        if (!dateIn.equals(that.dateIn)) return false;
        if (!dateOut.equals(that.dateOut)) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return discount != null ? discount.equals(that.discount) : that.discount == null;
    }

    @Override
    public int hashCode() {
        int result = dateIn.hashCode();
        result = 31 * result + dateOut.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + costAdditionalServices;
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}
