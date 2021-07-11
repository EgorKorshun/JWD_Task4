package by.epamtc.task4.korshun.runner;

import by.epamtc.task4.korshun.dao.exception.DaoException;
import by.epamtc.task4.korshun.dao.impliments.FilePlaneDAO;
import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.CargoAirplane;
import by.epamtc.task4.korshun.entity.planes.PassengerPlane;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;
import by.epamtc.task4.korshun.service.AirlineService;
import by.epamtc.task4.korshun.service.CargoPlaneService;
import by.epamtc.task4.korshun.service.PassengerPlaneService;
import by.epamtc.task4.korshun.service.PlaneService;
import by.epamtc.task4.korshun.tool.ScanValue;

import java.util.*;

public class Runner {
    public static void main(String... args) throws ServiceException, DaoException {
        Airline airline = new Airline();
        String filepath = "src/main/resources/aircraft_list.txt";
        FilePlaneDAO fpDAO = new FilePlaneDAO();
        airline.setPlanes((NavigableSet<Plane>) fpDAO.readPlanes(filepath));

        AirlineService airlineService=new AirlineService();
        System.out.println("enter the range of values for the fuel consumption parameters");
        System.out.println(airlineService.fuelRange(airline, ScanValue.ScanValueOfDouble(),
                ScanValue.ScanValueOfDouble()));
        System.out.println("\n");
        PlaneService planeService= new PlaneService();
        for (Plane anyPlane : airline.getPlanes()) {
            planeService.checkCorrect(anyPlane);
        }
       Plane [] planes=  fpDAO.readPlanes(filepath).toArray(new Plane[airline.getPlanes().size()]);
        PassengerPlaneService passengerPlaneService = new PassengerPlaneService();
        CargoPlaneService cargoPlaneService = new CargoPlaneService();
        int summaryAircraftWeight = 0;
        int holdingCapacity=0;
        for (int i = 0; i < planes.length; i++) {
            int emptyAircraftWeight =planes[i].getEmptyAircraftWeight();
           if(planes[i].getClass().getSimpleName()== String.valueOf(PassengerPlane.class)){
               PassengerPlane passengerPlane = (PassengerPlane) planes[i];
               int capacity = passengerPlane.getCapacity();
               holdingCapacity+=passengerPlaneService.holdingCapacity(capacity);
               summaryAircraftWeight+=passengerPlaneService.liftingCapacity(capacity,emptyAircraftWeight);
           }
           else if(planes[i].getClass().getSimpleName()==String.valueOf(CargoAirplane.class)){
               CargoAirplane cargoPlane = (CargoAirplane) planes[i];
               int maximumCargoWeight=cargoPlane.getMaximumCargoWeight();
               summaryAircraftWeight+=cargoPlaneService.liftingCapacity(maximumCargoWeight,emptyAircraftWeight);
               holdingCapacity+=cargoPlaneService.holdingCapacity(Plane.getCapacityOfCrew());
           }

        }
        System.out.println(airline);
        System.out.println("\ntotal weight of aircraft without load "+summaryAircraftWeight+"\nhilding capacity - "+holdingCapacity);
    }
}
