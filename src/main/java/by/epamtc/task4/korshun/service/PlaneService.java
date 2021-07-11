package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;

public class PlaneService implements HoldingCapacity {
    public  Plane checkCorrect(Plane plane) throws ServiceException {
        if (plane.getFuelConsumption() < 0 || plane.getEmptyAircraftWeight() < 0 ||
                plane.getMaxSpeed() < 0 || plane.getRange() < 0 || plane.getModelName() == null) {
            throw new ServiceException("not correct plane");
        } else {
            return plane;
        }
    }

    @Override
    public int holdingCapacity(int capacity) {
        return 0;
    }
}
