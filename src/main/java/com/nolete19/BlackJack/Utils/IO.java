package com.nolete19.BlackJack.Utils;

import com.nolete19.BlackJack.Exceptions.NotANumber;
import com.nolete19.BlackJack.Exceptions.NotInRange;

import java.util.Scanner;

public class IO {

    private final Scanner scanner;

    public IO(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prints a message to the console
     * @param message Message to print
     * @param newLine Whether to print a new line after the message
     */
    public void print(String message, boolean newLine) {
        System.out.print(message + (newLine ? "\n" : ""));
    }

    /**
     * Reads an int from the console
     * @param message Message to print before reading
     * @param newLine Whether to print a new line after the message
     * @return The read int
     * @throws NotANumber If the read string is not a number
     */
    public int readInt(String message, boolean newLine) throws NotANumber {
        System.out.print(message + (newLine ? "\n" : ""));
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NotANumber("Not a number");
        }
    }

    /**
     * Reads an int from the console and checks if it is in the range [min, max]
     * @param message Message to print before reading
     * @param min Minimum value
     * @param max Maximum value
     * @param newLine Whether to print a new line after the message
     * @return The read int
     * @throws NotANumber If the read string is not a number
     * @throws NotInRange If the read number is not in the range [min, max]
     */
    public int readLimitedInt(String message, int min, int max, boolean newLine) throws NotANumber, NotInRange {
        int number = readInt(message, newLine);
        if (number < min || number > max) {
            throw new NotInRange("Number not in range [" + min + ", " + max + "]");
        }
        return number;
    }

    /**
     * Reads an int from the console and checks if it has at most maxDigits digits
     * @param message Message to print before reading
     * @param maxDigits Maximum number of digits
     * @param newLine Whether to print a new line after the message
     * @return The read int
     * @throws NotANumber If the read string is not a number
     * @throws NotInRange If the read number has more than maxDigits digits
     */
    public int readDigitLimitedInt(String message, int maxDigits, boolean newLine) throws NotANumber, NotInRange {
        int number = readInt(message, newLine);
        if (number < 0 || number > Math.pow(10, maxDigits) - 1) {
            throw new NotInRange("Number not in range: Number must be " + maxDigits + " digits or less");
        }
        return number;
    }

    /**
     * Reads an int from the console and checks if it has at least minDigits digits and at most maxDigits digits
     * @param message Message to print before reading
     * @param minDigits Minimum number of digits
     * @param maxDigits Maximum number of digits
     * @param newLine Whether to print a new line after the message
     * @return The read int
     * @throws NotANumber If the read string is not a number
     * @throws NotInRange If the read number has less than minDigits digits or more than maxDigits digits
     */
    public int readDigitLimitedInt(String message, int minDigits, int maxDigits, boolean newLine) throws NotANumber, NotInRange {
        int number = readInt(message, newLine);
        if (number < Math.pow(10, minDigits) || number > Math.pow(10, maxDigits) - 1) {
            throw new NotInRange("Number not in range: Number must be between " + minDigits + " and " + maxDigits + " digits");
        }
        return number;
    }

    /**
     * Reads a string from the console
     * @param message Message to print before reading
     * @param newLine Whether to print a new line after the message
     * @return The read string
     */
    public String readString(String message, boolean newLine) {
        System.out.print(message + (newLine ? "\n" : ""));
        String res = scanner.next();
        scanner.nextLine();
        return res;
    }

    /**
     * Reads a string from the console and checks if it is in the array of valid strings
     * 
     * The read string is converted to lowercase before checking, so valid
     * strings should be lowercase. The returned string is also lowercase.
     * @param message Message to print before reading
     * @param newLine Whether to print a new line after the message
     * @param validStrings Array of valid strings
     * @return The read string
     */
    public String readString(String message, boolean newLine, String[] validStrings) {
        while (true) {
            String orgString = readString(message, newLine);
            String string = orgString.toLowerCase();
            for (String validString : validStrings) {
                if (string.equals(validString)) {
                    return string;
                }
            }

            System.out.println("Invalid string");
        }
    }

    public void close() {
        scanner.close();
    }

}
