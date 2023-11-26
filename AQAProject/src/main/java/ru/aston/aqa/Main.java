package ru.aston.aqa;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        String[] header = {"value 1", "value 2", "value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData appData = new AppData(header, data);
        appData.save("/Volumes/Mac/Test/data.csv");

        AppData loadedData = AppData.load("/Volumes/Mac/Test/data.csv");

    }

}

