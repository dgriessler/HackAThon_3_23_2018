import java.util.ArrayList;

public class Node {
    private DIRECTION[] directions;
    private boolean visited;
    private double[] clickRange = new double[4];
    private double[] location;
    private boolean placed;
    Node(double[] loc) {
        directions = null;
        visited = false;
        location = loc;
        placed = false;
    }
    Node (DIRECTION[] d, double[] loc) {
        directions = d;
        visited = false;
        location = loc;
    }
    public double[] getLocation() {
        return location;
    }
    public void setLocation(double[] loc) {
        location = loc;
    }
    public double[] getClickRange() {
        return clickRange;
    }
    public void setClickRange(double[] range) {
        clickRange = range;
    }
    public boolean isPlaced() {
        return placed;
    }
    public void placed() {
        placed = true;
    }
    public boolean rangeContains(double x, double y) {
        return x > clickRange[0] && x < clickRange[1] && y > clickRange[2] && y < clickRange[3];
    }
    public boolean isVisited() {
        return visited;
    }
    public void flipVisited() {
        if (visited) {
            visited = false;
        }
        visited = true;
    }
    
    public ArrayList<Position> outline(double[] start) {
        ArrayList<Position> positions = new ArrayList<Position>();
        positions.add(new Position(start[0], start[1]));
        if (directions == null) {
            return positions;
        }
        Position move = new Position(start[0], start[1]);
        for (int i = 0; i < directions.length; i++) {
            move = follow(directions[i], move);
            if (!positions.contains(move)) {
                positions.add(move);
            }
        }
        return positions;
    }
    private Position follow (DIRECTION d, Position start) {
        Position destination = new Position(start.getLocation()[0], start.getLocation()[1]);
        switch (d) {
        case LEFT: destination.decrementRow(1);
              break;
        case RIGHT: destination.incrementRow(1);
               break;
        case DOWN: destination.decrementColumn(1);
              break;
        case UP: destination.incrementColumn(1);
            break;
        default: break;
        }
        return destination;
    }
    
    public void rotateRight() {
        DIRECTION[] newDirections = new DIRECTION[directions.length];
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
            case UP: newDirections[i] = DIRECTION.RIGHT;
                     break;
            case DOWN: newDirections[i] = DIRECTION.LEFT;
                       break;
            case LEFT: newDirections[i] = DIRECTION.UP;
                           break;
            case RIGHT: newDirections[i] = DIRECTION.DOWN;
                            break;
            default: break;
            }
        }
        directions = newDirections;
    }
    
    public void rotateLeft() {
        DIRECTION[] newDirections = new DIRECTION[directions.length];
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
            case UP: newDirections[i] = DIRECTION.LEFT;
                     break;
            case DOWN: newDirections[i] = DIRECTION.RIGHT;
                       break;
            case LEFT: newDirections[i] = DIRECTION.DOWN;
                           break;
            case RIGHT: newDirections[i] = DIRECTION.UP;
                            break;
            default: break;
            }
        }
        directions = newDirections;
    }
    
    public void flip() {
        DIRECTION[] newDirections = new DIRECTION[directions.length];
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
            case RIGHT: newDirections[i] = DIRECTION.LEFT;
                        break;
            case LEFT: newDirections[i] = DIRECTION.RIGHT;
                       break;
            default: newDirections[i] = directions[i];
                     break;
            }
        }
        directions = newDirections;
    }
}
