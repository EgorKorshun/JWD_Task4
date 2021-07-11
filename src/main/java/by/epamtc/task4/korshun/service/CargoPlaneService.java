package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.planes.CargoAirplane;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;

public class CargoPlaneService extends  PlaneService implements Carrying, HoldingCapacity {

    @Override
    public int liftingCapacity(int maximumCargoWeight, int emptyAircraftWeight){
        if(maximumCargoWeight<0||emptyAircraftWeight<0){
            return 0;
        }
        return  maximumCargoWeight+emptyAircraftWeight;
    }

    @Override
    public int holdingCapacity(int capacity) {
        capacity=0;
        return capacity+ Plane.getCapacityOfCrew();
    }
    public   Plane checkCorrect(CargoAirplane plane) throws ServiceException {
        super.checkCorrect(plane);
        if (plane.getMaximumCargoWeight()<0) {
            throw new ServiceException("not correct plane");
        } else {
            return plane;
        }
    }
}
