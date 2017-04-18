package by.hotel.bean;

import by.hotel.builder.ParkingSpaceBuilder;

public class ParkingSpace {
    private int id;
    private int level;
    private boolean isReserved;

    public ParkingSpace(){super();}

    public ParkingSpace(ParkingSpaceBuilder parkingSpaceBuilder){
        this.id = parkingSpaceBuilder.getId();
        this.level = parkingSpaceBuilder.getLevel();
        this.isReserved = parkingSpaceBuilder.getIsReserved();
    }

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
