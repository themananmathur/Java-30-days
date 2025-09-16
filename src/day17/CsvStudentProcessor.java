package day17;

import java.io.*;
import java.util.*;

public class CsvStudentProcessor {
    public static void main(String[] args) {
        String fileName = "students.csv";
        List<Double> marksList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1].trim();
                double marks = Double.parseDouble(parts[2].trim());
                marksList.add(marks);

                System.out.println("Student: " + name + ", Marks: " + marks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // calculate average
        if (!marksList.isEmpty()) {
            double sum = 0;
            for (double m : marksList) sum += m;
            double avg = sum / marksList.size();
            System.out.println("Average Marks = " + avg);
        }
    }
}
