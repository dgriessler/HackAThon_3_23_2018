
public class Position {
    private double[] location;
    Position(double row, double column) {
        location = new double[] {row, column};
    }
    public double[] getLocation() {
        return location;
    }
    public void decrementRow(double amount) {
        location[0] -= amount;
    }
    public void decrementColumn(double amount) {
        location[1] -= amount;
    }
    public void incrementRow(double amount) {
        location[0] += amount;
    }
    public void incrementColumn(double amount) {
        location[1] += amount;
    }
    @Override
    public boolean equals(Object other) {
        Position o = (Position)other;
        return this.location[0] == o.location[0] && this.location[1] == o.location[1];
    }
}
