package util;

public class PalindromeException extends Exception {
    // Exception for when palindrome is found it displays starting index and the palindrome
    private String palindromeString;

    private int occurrenceIndex;

    @Override
    public String getMessage() {
        // This exception shows what the palindrome is and where it starts
        return palindromeString + " is a palindrome string that is found at index " + occurrenceIndex + "!";
    }

    public PalindromeException (String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }


}
