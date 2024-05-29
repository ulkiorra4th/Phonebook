package DataProcess;

import java.util.ArrayList;
import java.util.HashMap;

public final class DataParser {
    private static final PhoneNumberFormatter phoneNumberFormatter = new PhoneNumberFormatter();
    private static final int numberIndex = 0;
    private static final int lastNameIndex = 1;
    private static final int firstNameIndex = 2;

    public static HashMap<String, String> parseDataToNumbersAndNames(ArrayList<String> data) {
        HashMap<String, String> numbersAndNames = new HashMap<String, String>();

        for (String str: data) {
            String[] splitStr = str.split(" ");
            String formattedNumber = phoneNumberFormatter.formatToPhoneNumber(splitStr[numberIndex]);
            String name = splitStr[lastNameIndex] + " " + splitStr[firstNameIndex];

            numbersAndNames.put(formattedNumber, name);
        }

        return numbersAndNames;
    }
}
