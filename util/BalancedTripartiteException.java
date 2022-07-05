package util;

public class BalancedTripartiteException extends Exception{

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
