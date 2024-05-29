package DataReceive;

import CLI.ConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class DataReader {
    public static ArrayList<String> readDataFromFile(String filePath) {
        ArrayList<String> data = new ArrayList<String>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            ConsoleOutput.showException(e);
        }

        return data;
    }
}
