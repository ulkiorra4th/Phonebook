package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;

public final class PhoneBook {
    private static final int numberLength = 12;
    private static final int firstDigitIndex = 1;
    private static final int lastNameIndex = 0;

    private final HashMap<String, String> phoneBook;

    public PhoneBook(HashMap<String, String> data) {
        phoneBook = data;
    }

    public void write(String number, String name) {
        phoneBook.put(number, name);
    }

    public ArrayList<String> getAllNumbers() {
        return new ArrayList<String>(phoneBook.keySet());
    }

    public ArrayList<String> getAllNames() {
        return new ArrayList<String>(phoneBook.values());
    }

    public ArrayList<String> getNumbersByLastName(String lastName) {
        ArrayList<String> result = new ArrayList<>();

        for (String number: phoneBook.keySet()) {
            if (getLastName(phoneBook.get(number)).equalsIgnoreCase(lastName)){
                result.add(number);
            }
        }

        return result;
    }

    public ArrayList<String> getNumbersBySum(int sum) {
        ArrayList<String> result = new ArrayList<>();

        for (String number: phoneBook.keySet()) {
            if (countSumOfDigitsInNumber(number) == sum) {
                result.add(number);
            }
        }

        return result;
    }

    private int countSumOfDigitsInNumber(String number) {
        int sum = 0;

        for (int i = firstDigitIndex; i < numberLength; i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        return sum;
    }

    private String getLastName(String name) {
        return name.split(" ")[lastNameIndex];
    }
}
