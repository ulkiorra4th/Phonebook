package DataProcess;

public final class PhoneNumberFormatter {
    public String formatToPhoneNumber(String str) {
        StringBuilder sb = new StringBuilder(str);

        if (str.startsWith("8")) {
            sb.deleteCharAt(0);
            sb.insert(0, "+7");
        }

        if (str.contains("-")) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '-') {
                    sb.deleteCharAt(i--);
                }
            }
        }

        return sb.toString();
    }
}
