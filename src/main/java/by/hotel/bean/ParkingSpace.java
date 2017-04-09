package by.hotel.bean;

/**
 * Created by 1 on 06.04.2017.
 */
public class ParkingSpace {
    private int id;
    private int level;
    private boolean isReserved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
