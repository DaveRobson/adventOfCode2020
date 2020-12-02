package uk.co.robson.adventofcode2020.day2.domain;

public class PasswordData {
    private int startRange;
    private int endRange;
    private String policy;
    private String value;

    public PasswordData(int startRange, int endRange, String policy, String value) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.policy = policy;
        this.value = value;
    }

    public int getStartRange() {
        return startRange;
    }

    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
