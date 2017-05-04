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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomType roomType = (RoomType) o;

        if (roomsCount != roomType.roomsCount) return false;
        if (bedsCount != roomType.bedsCount) return false;
        if (bathroomsCount != roomType.bathroomsCount) return false;
        if (size != roomType.size) return false;
        if (Float.compare(roomType.costPerDay, costPerDay) != 0) return false;
        return additionalInfo.equals(roomType.additionalInfo);
    }

    @Override
    public int hashCode() {
        int result = roomsCount;
        result = 31 * result + bedsCount;
        result = 31 * result + bathroomsCount;
        result = 31 * result + size;
        result = 31 * result + (costPerDay != +0.0f ? Float.floatToIntBits(costPerDay) : 0);
        result = 31 * result + additionalInfo.hashCode();
        return result;
    }
}
