package com.company;

public class Hole {
    private int address;
    private int size;

    public Hole(int address, int size) {
        this.address=address;
        this.size=size;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "address=" + address +
                ", size=" + size +
                '}';
    }
}
