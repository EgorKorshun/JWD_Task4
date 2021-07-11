package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.planes.PassengerPlane;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;

public class PassengerPlaneService extends PlaneService  implements Carrying ,HoldingCapacity {
    private  static  final  int WEIGHT_OF_ONE_PERSON = 75;

    @Override
    public int liftingCapacity(int capacity, int emptyAircraftWeight){
        return capacity*WEIGHT_OF_ONE_PERSON+emptyAircraftWeight;
    }


    @Override
    public int holdingCapacity(int capacityOfPeople) {
        if(capacityOfPeople<0){
            return 0;
        }
        return capacityOfPeople+Plane.getCapacityOfCrew();
    }

    public  Plane checkCorrect(PassengerPlane plane) throws ServiceException {
        super.checkCorrect(plane);
        if (plane.getCapacity()<0) {
            throw new ServiceException("not correct plane");
        } else {
            return plane;
        }
    }
}
