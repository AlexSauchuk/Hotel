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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationRoom that = (ReservationRoom) o;

        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return reservation != null ? reservation.equals(that.reservation) : that.reservation == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }
}
