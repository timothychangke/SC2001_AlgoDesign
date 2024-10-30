package Project1_v4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writeCSV {

    static void writeArrayToCSV1(long[][] arrCSV, String fileName) {
        // change file name to your desired file directory
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Size,ExecutionTime,Comparisons,sizeofS");
            for (int i = 0; i < arrCSV[0].length; i++) {
                // Write each row to the CSV file
                for (int j = 0; j < arrCSV.length; j++) {
                    writer.print(arrCSV[j][i]);
                    if (j < arrCSV.length - 1) {
                        writer.print(",");
                    } else {
                        writer.println(); // Start a new line for the next row
                    }
                }
            }
            System.out.println("CSV file " + fileName + " created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeArrayToCSV2(long[][] arrCSV, String fileName) {
        // change file name to your desired file directory
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(",Mersertion,,Merge");
            writer.println("Size,ExecutionTime1,Comparisons1,ExecutionTime2,Comparisons2");
            for (int i = 0; i < arrCSV[0].length; i++) {
                // Write each row to the CSV file
                for (int j = 0; j < arrCSV.length; j++) {
                    writer.print(arrCSV[j][i]);
                    if (j < arrCSV.length - 1) {
                        writer.print(",");
                    } else {
                        writer.println(); // Start a new line for the next row
                    }
                }
            }

            System.out.println("CSV file " + fileName + " created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void writeArrayToCSV3(long[][] arrCSV, String fileName) {
        // change file name to your desired file directory
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(",,Insertion_sort,,Merge_sort");
        	writer.println("Size,ExecutionTime1,Comparisons1,ExecutionTime2,Comparisons2");
            for (int i = 0; i < arrCSV[0].length; i++) {
                // Write each row to the CSV file
                for (int j = 0; j < arrCSV.length; j++) {
                    writer.print(arrCSV[j][i]);
                    if (j < arrCSV.length - 1) {
                        writer.print(",");
                    } else {
                        writer.println(); // Start a new line for the next row
                    }
                }
            }
            System.out.println("CSV file " + fileName + " created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
