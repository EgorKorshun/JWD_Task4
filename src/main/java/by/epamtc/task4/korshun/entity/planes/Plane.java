package by.epamtc.task4.korshun.entity.planes;

import java.io.Serializable;
import java.util.Objects;

public  class Plane implements Serializable {
    private String modelName;
    private  double maxSpeed;
    private  int fuelConsumption;
    private  int range;
    private  int emptyAircraftWeight;
    private  static  final int CAPACITY_OF_CREW =5;

    public Plane(){}

    public Plane(String modelName,double maxSpeed,
                 int fuelConsumption, int range, int emptyAircraftWeight){
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.range = range;
        this.emptyAircraftWeight = emptyAircraftWeight;
    }

    public Plane(String modelName,
                 int fuelConsumption, int range){
        this.modelName = modelName;
        this.fuelConsumption = fuelConsumption;
        this.range = range;
    }

    Plane(String modelName){
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public static int getCapacityOfCrew() {
        return CAPACITY_OF_CREW;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getEmptyAircraftWeight() {
        return emptyAircraftWeight;
    }

    public void setEmptyAircraftWeight(int emptyAircraftWeight) {
        this.emptyAircraftWeight = emptyAircraftWeight;
    }

    @Override
    public String toString() {
        return "\n\n"+getClass().getSimpleName() +
                ": model name - " + modelName  +
                ", max speed - " + maxSpeed +
                ", fuel consumption - " + fuelConsumption +
                ",\nrange - " + range+
                ",empty aircraft weight - "+emptyAircraftWeight;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Plane plane = (Plane) o;
            result = Double.compare(plane.maxSpeed, maxSpeed) == 0 && fuelConsumption == plane.fuelConsumption &&
                    range == plane.range && Objects.equals(modelName, plane.modelName);
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = fuelConsumption;
        result = 31*result+(modelName!=null? 31*modelName.hashCode():0);
        result = (int) (31*result + maxSpeed);
        result= 31*result+range;
        return  result;
    }
}
