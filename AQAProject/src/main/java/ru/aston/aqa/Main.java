package ru.aston.aqa;

import java.awt.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String filename = "data.csv";
        String sep = File.separator;
        String filePath = "src" + sep + "main" + sep + "resources" + sep + filename;

        String[] header = {"value 1", "value 2", "value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        AppData appData = new AppData(header, data);

        appData.save(filePath);

        AppData loadedData = AppData.load(filePath);

    }

}

