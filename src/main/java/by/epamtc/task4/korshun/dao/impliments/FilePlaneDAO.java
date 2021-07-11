package by.epamtc.task4.korshun.dao.impliments;

import by.epamtc.task4.korshun.dao.PlaneDAO;
import by.epamtc.task4.korshun.dao.exception.DaoException;
import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.CargoAirplane;
import by.epamtc.task4.korshun.entity.planes.PassengerPlane;
import by.epamtc.task4.korshun.entity.planes.Plane;
import by.epamtc.task4.korshun.service.FuelConsumptionRangeComparator;

import java.io.*;
import java.util.*;

public class FilePlaneDAO implements PlaneDAO {

    private static Set<Plane> planes = new TreeSet<>(new FuelConsumptionRangeComparator());

    @Override
    public Set<Plane> readPlanes(String filePath) throws DaoException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String temp = "";
            int buf;
            String modelName;
            double maxSpeed;
            int fuelConsumption;
            int range;
            int emptyAircraftWeight;
            int maximumCargoWeight;
            int capacity;
            boolean isCargo;
            while ((buf = reader.read()) != -1) {
                if (buf == '#')
                    reader.readLine();
                else if (buf != ';') {
                    temp += (char) buf;
                } else {
                    String[] splitResult = temp.split(",");
                    if (Integer.parseInt(splitResult[6]) == 0) {
                        isCargo = false;
                    } else isCargo = true;
                    modelName = splitResult[0];
                    maxSpeed = Double.parseDouble(splitResult[1]);
                    fuelConsumption = Integer.parseInt(splitResult[2]);
                    range = Integer.parseInt(splitResult[3]);
                    emptyAircraftWeight = Integer.parseInt(splitResult[4]);
                    if (isCargo == false) {
                        capacity = Integer.parseInt(splitResult[5]);
                        planes.add(new PassengerPlane(modelName, maxSpeed, fuelConsumption, range, emptyAircraftWeight, capacity));

                    } else {
                        maximumCargoWeight = Integer.parseInt(splitResult[5]);
                        planes.add(new CargoAirplane(modelName, maxSpeed, fuelConsumption, range, emptyAircraftWeight, maximumCargoWeight));
                    }
                    temp = "";
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planes;
    }
}
