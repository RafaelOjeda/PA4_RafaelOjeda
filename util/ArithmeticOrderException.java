package util;

public class ArithmeticOrderException extends Exception {
    // Exception for when alphabetical order  is found it displays starting index and the alphabetical order string
    private String arithmeticOrderString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return arithmeticOrderString + " is a arithmetic string of order 1 that is found at index " + occurrenceIndex + "!";
    }
    public ArithmeticOrderException(String arithmeticOrderString, int index) {
        this.arithmeticOrderString = arithmeticOrderString;
        occurrenceIndex = index;
    }

}
