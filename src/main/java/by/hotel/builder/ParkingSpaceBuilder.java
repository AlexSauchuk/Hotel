package by.hotel.builder;

import by.hotel.bean.ParkingSpace;

public class ParkingSpaceBuilder {
    private int id;
    private int level;
    private boolean isReserved;

    public ParkingSpaceBuilder id(int id){
        this.id = id;
        return this;
    }

    public ParkingSpaceBuilder level(int level){
        this.level = level;
        return this;
    }

    public ParkingSpaceBuilder isReserved(boolean isReserved){
        this.isReserved = isReserved;
        return this;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public ParkingSpace build(){
        return new ParkingSpace(this);
    }
}
