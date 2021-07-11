package by.epamtc.task4.korshun.service;

import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.Plane;

import java.util.Set;

public interface FuelParamRange {
    Set<Plane> fuelRange(Airline airline, double lowValue, double highValue);
}
