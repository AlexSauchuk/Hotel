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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationParkingSpace that = (ReservationParkingSpace) o;

        if (reservation != null ? !reservation.equals(that.reservation) : that.reservation != null) return false;
        return parkingSpace != null ? parkingSpace.equals(that.parkingSpace) : that.parkingSpace == null;
    }

    @Override
    public int hashCode() {
        int result = reservation != null ? reservation.hashCode() : 0;
        result = 31 * result + (parkingSpace != null ? parkingSpace.hashCode() : 0);
        return result;
    }
}
