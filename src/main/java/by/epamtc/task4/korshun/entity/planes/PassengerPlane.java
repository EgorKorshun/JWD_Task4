package by.epamtc.task4.korshun.entity.planes;

import java.io.Serializable;

public class PassengerPlane extends Plane implements Serializable {
    private  int capacity;


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public PassengerPlane() {
    }

    public  PassengerPlane(String modelName, double maxSpeed,
                           int fuelConsumption, int range,int emptyAircraftWeight ,int capacity){
        super(modelName, maxSpeed,fuelConsumption,range,emptyAircraftWeight);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return   super.toString()+
                ", capacity of people - " + capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane that = (PassengerPlane) o;
        return capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return super.hashCode() +31*capacity;
    }
}
