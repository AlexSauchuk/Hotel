package by.hotel.bean;

import by.hotel.builder.ReservationRoomBuilder;

public class ReservationRoom {
    private Room room;
    private Reservation reservation;

    public ReservationRoom(){super();}

    public ReservationRoom(ReservationRoomBuilder reservationRoomBuilder){
        this.room = reservationRoomBuilder.getRoom();
        this.reservation = reservationRoomBuilder.getReservation();
    }

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
