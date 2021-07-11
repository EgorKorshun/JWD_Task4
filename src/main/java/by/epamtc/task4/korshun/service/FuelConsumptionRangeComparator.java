package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.planes.Plane;

import java.util.Comparator;

public class FuelConsumptionRangeComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane plane1, Plane plane2) {
        return plane1.getFuelConsumption()-plane2.getFuelConsumption();
    }
}
