package by.epamtc.task4.korshun.entity.planes;

import java.io.Serializable;

public class CargoAirplane extends Plane implements Serializable {
    private  int maximumCargoWeight;

    public CargoAirplane() {
    }
    public  CargoAirplane(String modelName, double maxSpeed,
                          int fuelConsumption, int range, int emptyAircraftWeight, int maximumCargoWeight){
        super(modelName, maxSpeed,fuelConsumption,range,emptyAircraftWeight);
        this.maximumCargoWeight = maximumCargoWeight;
    }
    public  CargoAirplane(String modelName){
        super(modelName);
    }

    public int getMaximumCargoWeight() {
        return maximumCargoWeight;
    }

    public void setMaximumCargoWeight(int maximumCargoWeight) {
        this.maximumCargoWeight = maximumCargoWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", maximum cargo weight  - " + maximumCargoWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoAirplane that = (CargoAirplane) o;
        return maximumCargoWeight == that.maximumCargoWeight;
    }

    @Override
    public int hashCode() {
        return super.hashCode() +31*maximumCargoWeight;
    }
}
