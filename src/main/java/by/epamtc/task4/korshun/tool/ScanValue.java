package by.epamtc.task4.korshun.tool;

import java.util.Scanner;

public class ScanValue {

    public static double ScanValueOfDouble(){
        return  getScanner().nextDouble();
    }
    public  static Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return  scanner;
    }
}
