package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;

import java.util.Comparator;

public class FuelConsumptionRangeComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane plane1, Plane plane2) {
        if(plane1==null||plane2==null){
            try {
                throw new ServiceException("plane is null");
            } catch (ServiceException e) {

            }
        }
        return plane1.getFuelConsumption()-plane2.getFuelConsumption();
    }
}
