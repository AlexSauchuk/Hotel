package by.hotel.bean;

import by.hotel.builder.RoomTypeBuilder;

public class RoomType {
    private int id;
    private int roomsCount;
    private int bedsCount;
    private int bathroomsCount;
    private int size;
    private float costPerDay;
    private String additionalInfo;

    public RoomType() {super();
    }

    public RoomType(RoomTypeBuilder roomTypeBuilder){
        this.id = roomTypeBuilder.getId();
        this.roomsCount = roomTypeBuilder.getRoomsCount();
        this.bedsCount = roomTypeBuilder.getBedsCount();
        this.costPerDay = roomTypeBuilder.getCostPerDay();
        this.additionalInfo = roomTypeBuilder.getAdditionalInfo();
        this.bathroomsCount = roomTypeBuilder.getBathroomsCount();
        this.size = roomTypeBuilder.getSize();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public float getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(float costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getBathroomsCount() {
        return bathroomsCount;
    }

    public void setBathroomsCount(int bathroomsCount) {
        this.bathroomsCount = bathroomsCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
