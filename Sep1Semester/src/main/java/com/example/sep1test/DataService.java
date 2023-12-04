package com.example.sep1test;

import com.example.sep1test.Projects.Residential;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataService {

    public static void saveData(List<Residential> data, String filePath) {
        // Convert ObservableList to a serializable ArrayList
        List<Residential> serializableData = new ArrayList<>(data);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializableData);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Residential> loadData(String filePath) {
        List<Residential> data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            data = (List<Residential>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void exportToJson(List<Residential> data, String filePath) {
        try {
            // Create Gson instance with pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convert list of Residential objects to JSON
            String jsonData = gson.toJson(data);

            // Write JSON to file
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(jsonData);
            }

            System.out.println("Data exported to JSON successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
