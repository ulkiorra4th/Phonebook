import CLI.ConsoleOutput;
import Data.PhoneBook;
import DataProcess.DataParser;
import DataReceive.DataReader;
import QueryProcess.QueryHandler;

import java.util.ArrayList;

public class Main {
    public static final String filePath = "src/DataReceive/data_source.txt";

    public static void main(String[] args) {
        ConsoleOutput.showWelcomeMessage();

        ArrayList<String> data = DataReader.readDataFromFile(filePath);

        PhoneBook phoneBook = new PhoneBook(DataParser.parseDataToNumbersAndNames(data));
        QueryHandler queryHandler = new QueryHandler(phoneBook);

        queryHandler.listen();
    }
}