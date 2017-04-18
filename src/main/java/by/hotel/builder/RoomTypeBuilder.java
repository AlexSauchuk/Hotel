package by.hotel.builder;

import by.hotel.bean.RoomType;

public class RoomTypeBuilder {
    private int id;
    private int roomsCount;
    private int bedsCount;
    private float costPerDay;
    private String additionalInfo;

    public RoomTypeBuilder id(int id){
        this.id = id;
        return this;
    }

    public RoomTypeBuilder roomsCount(int roomsCount){
        this.roomsCount = roomsCount;
        return this;
    }

    public RoomTypeBuilder bedsCount(int bedsCount){
        this.bedsCount = bedsCount;
        return this;
    }

    public RoomTypeBuilder costPerDay(float costPerDay){
        this.costPerDay = costPerDay;
        return this;
    }

    public RoomTypeBuilder additionalInfo(String additionalInfo){
        this.additionalInfo = additionalInfo;
        return this;
    }

    public int getId() {
        return id;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public float getCostPerDay() {
        return costPerDay;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public RoomType build(){
        return new RoomType(this);
    }
}