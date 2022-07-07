package util;

public class BalancedBipartiteException extends Exception {

    private String balancedBipartiteString;

    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return balancedBipartiteString + " is a balanced bipartite string that is found at index " + occurrenceIndex + "!";
    }

    public BalancedBipartiteException (String balancedBipartiteString, int index) {
        this.balancedBipartiteString = balancedBipartiteString;
        occurrenceIndex = index;
    }

}
