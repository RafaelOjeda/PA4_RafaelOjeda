package util;

public class PalindromeException extends Exception {

    private String palindromeString;

    private int occurrenceIndex;

    @Override
    public String getMessage() {
        // This exception shows what the palindrome is and where it starts
        return palindromeString + " is a balanced tripartite string that is found at index " + occurrenceIndex + "!";
    }

    public PalindromeException (String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }


}
