package util;

public class BalancedTripartiteException extends Exception{
    // Exception for when tripartite is found it displays starting index and the tripartite
    private String balancedTripartiteString;

    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return balancedTripartiteString + " is a balanced tripartite string that is found at index " + occurrenceIndex + "!";
    }

    public BalancedTripartiteException (String balancedTripartiteString, int index) {
        this.balancedTripartiteString = balancedTripartiteString;
        occurrenceIndex = index;
    }

}
