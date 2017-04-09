package by.hotel.bean;

/**
 * Created by SK on 16.02.2017.
 */
public class Room {
    private int id;
    private int floor, roomsCount, bedsCount;
    private String phone;
    private float costPerDay;
    private String additionalInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "id=" + id + ", floor=" + floor + ", roomsCount=" + roomsCount + ", bedsCount=" + bedsCount +
                ", phone=" + phone + ", costPerDay=" + costPerDay + ", additionalInfo=" + additionalInfo;
    }
}
