package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;

import java.util.ArrayList;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class AirlineService implements FuelParamRange{
    @Override
    public NavigableSet<Plane> fuelRange(Airline airline, double lowValue, double highValue) {
        if (lowValue > highValue) {
            return null;
        } else {
            NavigableSet<Plane> planesOnRange = new TreeSet<>(new FuelConsumptionRangeComparator());
            Set<Plane> planesAll = airline.getPlanes();
            for (Plane somePlane : planesAll) {
                double fuel = somePlane.getFuelConsumption();
                if (fuel >= lowValue && fuel <= highValue)
                    planesOnRange.add(somePlane);
            }
            return planesOnRange;
        }
    }
}
