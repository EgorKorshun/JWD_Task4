package by.epamtc.task4.korshun.entity;

import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.service.FuelConsumptionRangeComparator;

import java.io.Serializable;
import java.util.*;

public class Airline implements Serializable {
    private NavigableSet<Plane> planes;

    public Airline(){
        planes = new TreeSet<>(new FuelConsumptionRangeComparator());
    }

    public NavigableSet<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(NavigableSet<Plane> planes) {
        this.planes = planes;
    }

    public Airline(NavigableSet<Plane> planes) {
        this.planes = new TreeSet<>(new FuelConsumptionRangeComparator());
    }

    public void   addPlane(Plane plane) {
        if(plane!=null){
            planes.add(plane);
        }
    }
    public boolean  addAllPlanes(NavigableSet<Plane> planes){
        boolean flag = true;
        if(planes == null)
            flag = false;
        for(Plane somePlane : planes)
            if(planes == null) {
                flag = false;
            }
        this.planes.addAll(planes);
        return  flag;
    }
    public  void  removePlane(Plane plane){
        planes.remove(plane);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+
                "planes :" + planes;
    }
    @Override
    public  int  hashCode(){
        return 31*planes.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(planes, airline.planes);
    }
}
