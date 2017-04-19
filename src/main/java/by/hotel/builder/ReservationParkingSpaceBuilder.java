package by.hotel.builder;

import by.hotel.bean.ParkingSpace;
import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationParkingSpace;

public class ReservationParkingSpaceBuilder {
    private Reservation reservation;
    private ParkingSpace parkingSpace;

    public ReservationParkingSpaceBuilder reservation(Reservation reservation){
        this.reservation = reservation;
        return this;
    }

    public ReservationParkingSpaceBuilder parkingSpace(ParkingSpace parkingSpace){
        this.parkingSpace = parkingSpace;
        return this;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public ReservationParkingSpace build(){
        return new ReservationParkingSpace(this);
    }
}
