package by.hotel.bean;

/**
 * Created by 1 on 06.04.2017.
 */
public class ReservationParkingSpace {
    private Reservation reservation;
    private ParkingSpace parkingSpace;

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
