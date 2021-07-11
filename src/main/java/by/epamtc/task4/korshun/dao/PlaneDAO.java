package by.epamtc.task4.korshun.dao;

import by.epamtc.task4.korshun.dao.exception.DaoException;
import by.epamtc.task4.korshun.entity.Airline;
import by.epamtc.task4.korshun.entity.planes.Plane;

import java.util.NavigableSet;
import java.util.Set;

public interface PlaneDAO {
    Set<Plane> readPlanes(String filePath) throws DaoException;
}
