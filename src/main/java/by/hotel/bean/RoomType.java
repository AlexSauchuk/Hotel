package by.hotel.bean;

/**
 * Created by 1 on 04.04.2017.
 */
public class RoomType {
    private int id;
    private int roomsCount;
    private int bedsCount;
    private float costPerDay;
    private String additionalInfo;

    public RoomType() {
    }

    public RoomType(int id, int roomsCount, int bedsCount, float costPerDay, String additionalInfo) {
        this.id = id;
        this.roomsCount = roomsCount;
        this.bedsCount = bedsCount;
        this.costPerDay = costPerDay;
        this.additionalInfo = additionalInfo;
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
}
