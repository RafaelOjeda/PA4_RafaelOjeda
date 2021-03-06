package util;

public class ArithmeticReverseOrderException extends Exception {
    // Exception for when reverse alphabetical order  is found it displays starting index and the reverse alphabetical order string
    private String arithmeticReverseOrderString;

    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return arithmeticReverseOrderString + " is a arithmetic string of reverse order 1 that is found at index " + occurrenceIndex + "!";
    }

    public ArithmeticReverseOrderException (String arithmeticReverseOrderString, int index) {
        this.arithmeticReverseOrderString = arithmeticReverseOrderString;
        occurrenceIndex = index;
    }

}
