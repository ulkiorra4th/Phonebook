package QueryProcess;

import CLI.ConsoleInput;
import CLI.ConsoleOutput;
import Data.PhoneBook;

import java.util.ArrayList;

public class QueryHandler {
    private static final int argumentIndex = 4;
    private final PhoneBook phoneBook;

    public QueryHandler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void listen() {
        while (true) {
            String query = ConsoleInput.read();

            try {
                ArrayList<String> response;

                switch (defineQueryType(query)) {
                    case getBySumQuery -> {
                        String queryArgument = query.split(" ")[argumentIndex];
                        response = phoneBook.getNumbersBySum(Integer.parseInt(queryArgument));
                    }

                    case getByLastNameQuery -> {
                        String queryArgument = query.split(" ")[argumentIndex];
                        response = phoneBook.getNumbersByLastName(queryArgument);
                    }

                    case getAllNamesQuery -> response = phoneBook.getAllNames();
                    case getAllNumbersQuery -> response = phoneBook.getAllNumbers();

                    default -> response = new ArrayList<String>();
                }

                if (response.isEmpty()) ConsoleOutput.showEmptyResponseMessage();
                else ConsoleOutput.showResponse(response);

            } catch (Exception e) {
                ConsoleOutput.showException(e);
            }
        }
    }

    private QueryType defineQueryType(String query) throws Exception {
        String[] queryElements = query.split(" ");

        // query validation
        if (!(queryElements[0].equals("SELECT") && queryElements[1].equals("WHERE") && queryElements[3].equals("IS") &&
                queryElements.length == 5)
                && !(queryElements[0].equals("SELECT") && queryElements[1].equals("ALL") && queryElements.length == 3))
            throw new Exception("INCORRECT QUERY");

        if (queryElements[1].equals("ALL"))
            if (queryElements[2].equals("NUMBERS"))
                return QueryType.getAllNumbersQuery;
            else if (queryElements[2].equals("NAMES"))
                return QueryType.getAllNamesQuery;

        if (queryElements[2].equals("LASTNAME"))
            return QueryType.getByLastNameQuery;

        if (queryElements[2].equals("SUM"))
            return QueryType.getBySumQuery;

        throw new Exception("INCORRECT QUERY");
    }
}
