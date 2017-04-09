package by.hotel.bean;

/**
 * Created by 1 on 06.04.2017.
 */
public class ReservationRoom {
    private Room room;
    private Reservation reservation;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
