package Entities;

public class SessaoItem {
    private int id;
    private String displayValue;

    public SessaoItem(int id, String displayValue) {
        this.id = id;
        this.displayValue = displayValue;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
