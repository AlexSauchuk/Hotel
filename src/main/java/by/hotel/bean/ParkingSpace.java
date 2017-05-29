package by.hotel.bean;

import by.hotel.builder.ParkingSpaceBuilder;

public class ParkingSpace {
    private int id;
    private int level;
    private byte reserved;

    public ParkingSpace(){super();}

    public ParkingSpace(ParkingSpaceBuilder parkingSpaceBuilder){
        this.id = parkingSpaceBuilder.getId();
        this.level = parkingSpaceBuilder.getLevel();
        this.reserved = parkingSpaceBuilder.getReserved();
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

    public byte getReserved() {
        return reserved;
    }

    public void setReserved(byte reserved) {
        reserved = reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingSpace that = (ParkingSpace) o;

        if (level != that.level) return false;
        return reserved == that.reserved;
    }

    @Override
    public int hashCode() {
        int result = level;
        result = 31 * result + (int) reserved;
        return result;
    }
}
