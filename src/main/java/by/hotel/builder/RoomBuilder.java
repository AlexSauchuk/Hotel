package by.hotel.builder;

import by.hotel.bean.Room;
import by.hotel.bean.RoomType;

public class RoomBuilder {
    private int id;
    private int floor;
    private String phone;
    private RoomType roomType;

    public RoomBuilder id(int id){
        this.id = id;
        return this;
    }

    public RoomBuilder floor(int floor){
        this.floor = floor;
        return this;
    }

    public RoomBuilder phone(String phone){
        this.phone = phone;
        return this;
    }

    public RoomBuilder roomType(RoomType roomType){
        this.roomType = roomType;
        return this;
    }

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public String getPhone() {
        return phone;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Room build(){
        return new Room(this);
    }
}