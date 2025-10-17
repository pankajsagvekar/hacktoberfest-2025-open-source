package basic_java;
public class StringExample {
    public static void main(String[] args) {
        String message = "Hello, World!";
        String message2 = " Welcome to Java programming.";
        System.out.println(message);

        // ChartAt() function
        char result = message.charAt(7);
        System.out.println("Character at index 7: " + result);

        // CodePointAt() function
        int codePoint = message.codePointAt(7);
        System.out.println("Unicode code point at index 7: " + codePoint);

        // codePointBefore() function
        int codePointBefore = message.codePointBefore(7);
        System.out.println("Unicode code point before index 7: " + codePointBefore);

        // codePointCount() function
        int codePointCount = message.codePointCount(0, message.length());
        System.out.println("Total Unicode code points in the string: " + codePointCount);

        // compareTo() function
        /*
         * The comparison is based on the Unicode value of each character in the strings. The method returns 0 if the string is equal to the other string. A value less than 0 is returned if the string is less than the other string (less characters) and a value greater than 0 if the string is greater than the other string (more characters).
         *
         */
        System.out.println("Comparing message with message2: " + message.compareTo(message2));
    }
}
