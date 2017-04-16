package by.hotel.bean;

import by.hotel.builder.ReservationParkingSpaceBuilder;

public class ReservationParkingSpace {
    private Reservation reservation;
    private ParkingSpace parkingSpace;

    public ReservationParkingSpace(){super();}

    public ReservationParkingSpace(ReservationParkingSpaceBuilder reservationParkingSpaceBuilder){
        this.reservation = reservationParkingSpaceBuilder.getReservation();
        this.parkingSpace = reservationParkingSpaceBuilder.getParkingSpace();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}
