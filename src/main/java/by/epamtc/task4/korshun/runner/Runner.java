package by.epamtc.task4.korshun.runner;

import by.epamtc.task4.korshun.dao.exception.DaoException;
import by.epamtc.task4.korshun.dao.impliments.FilePlaneDAO;
import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.exception.ServiceException;
import by.epamtc.task4.korshun.service.AirlineService;
import by.epamtc.task4.korshun.service.PlaneService;
import by.epamtc.task4.korshun.tool.ScanValue;

import java.util.*;

public class Runner {
    public static void main(String... args) throws ServiceException, DaoException {
        Airline airline = new Airline();
        FilePlaneDAO fpDAO = new FilePlaneDAO();
        airline.setPlanes((NavigableSet<Plane>) fpDAO.readPlanes("src/main/resources/aircraft_list.txt"));

        AirlineService airlineService=new AirlineService();
        System.out.println("enter the range of values for the fuel consumption parameters");
        System.out.println(airlineService.fuelRange(airline, ScanValue.ScanValueOfDouble(),
                ScanValue.ScanValueOfDouble()));
        System.out.println("\n");
        PlaneService planeService= new PlaneService();
        for (Plane anyPlane : airline.getPlanes()) {
            planeService.checkCorrect(anyPlane);
        }
        System.out.println(airline);
    }
}
