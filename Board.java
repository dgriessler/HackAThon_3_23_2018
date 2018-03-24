import java.util.ArrayList;

public class Board {
    private boolean[][] gameBoard;
    Pieces playerPieces;
    double[] positionInBoard = new double[] {0.5, 0.5};
    double SQUARE_SIZE = 0.4;
    double[] currentPieceLoc = new double[2];
    int indexOfCurrentPiece = 0;
    int numPlaced = 0;
    public Board() {
        gameBoard = new boolean[20][20];
        playerPieces = new Pieces();
    }
    public void setPosition(double row, double column) {
        positionInBoard[0] = row;
        positionInBoard[1] = column;
    }
    public boolean play() {
        return numPlaced != 15;
    }
    
    public void move(DIRECTION d) {
        double[] move = new double[2];
        move[0] = currentPieceLoc[0];
        move[1] = currentPieceLoc[1];
        switch(d) {
        case UP: move[0] += 1;
                 break;
        case DOWN: move[0] -= 1;
                   break;
        case LEFT: move[1] -= 1;
                   break;
        case RIGHT: move[1] += 1;
                    break;
        default: return;
        }
        ArrayList<Position> drawHere = playerPieces.getPieces()[indexOfCurrentPiece].outline(move);
        if (!verify(drawHere, 20, 20)) {
            return;
        } else {
            currentPieceLoc[0] = move[0];
            currentPieceLoc[1] = move[1];
        }
    }
    
//    public void placeFirst() {
//        currentPieceLoc[0] = 0;
//        currentPieceLoc[1] = 0;
//        boolean adjust;
//        boolean containsBase;
//        do {
//            adjust = false;
//            containsBase = false;
//            ArrayList<Position> drawHere = fixedPositions(playerPieces.getPieces()[indexOfCurrentPiece].outline(currentPieceLoc));
//            for (Position p : drawHere) {
//                if (p.getLocation()[0] < 0 || p.getLocation()[1] < 0) {
//                    adjust = true;
//                    break;
//                } else if ((int)p.getLocation()[0] == 0 && (int)p.getLocation()[1] == 0) {
//                    containsBase = true;
//                }
//            }
//            if (!containsBase) {
//                adjust = true;
//            }
//        } while (adjust);
//        ArrayList<Position> mark = fixedPositions(playerPieces.getPieces()[indexOfCurrentPiece].outline(currentPieceLoc));
//        playerPieces.getPieces()[indexOfCurrentPiece].setLocation(new double[] {currentPieceLoc[0], currentPieceLoc[1]});
//        playerPieces.getPieces()[indexOfCurrentPiece].placed();
//        for (Position p : mark) {
//            gameBoard[(int)p.getLocation()[0]][(int)p.getLocation()[1]] = true;
//        }
//        currentPieceLoc[0] = 0;
//        currentPieceLoc[1] = 0;
//        numPlaced++;
//    }
    
    public boolean place() {
        ArrayList<Position> mark = fixedPositions(playerPieces.getPieces()[indexOfCurrentPiece].outline(currentPieceLoc));
        boolean canBePlaced = false;
        for (int i = 0; i < mark.size(); i++) {
            int x = (int) mark.get(i).getLocation()[0];
            int y = (int) mark.get(i).getLocation()[1];
            if (gameBoard[x][y] == true) {
                return true;
            } 
            if (x - 1 > 0 && gameBoard[x- 1][y] == true) {
                return true;
            } 
            if (x+1 < 20 && gameBoard[x+1][y] == true) {
                return true;
            }
            if (y - 1 > 0 && gameBoard[x][y-1] == true) {
                return true;
            } 
            if (y + 1 < 20 && gameBoard[x][y+1] == true) {
                return true;
            }
            if (x-1>0) {
                if (y - 1 > 0 && gameBoard[x-1][y-1] == true) {
                    canBePlaced = true;
                }
                if (y + 1 < 20 && gameBoard[x-1][y+1] == true) {
                    canBePlaced = true;
                }
            }
            if (x + 1 < 20) {
                if (y - 1 > 0 && gameBoard[x+1][y-1] == true) {
                    canBePlaced = true;
                } 
                if (y + 1 < 20 && gameBoard[x+1][y+1] == true) {
                    canBePlaced = true;
                }
            }
        }
        if (numPlaced != 0 && !canBePlaced) {
            return true;
        }
        playerPieces.getPieces()[indexOfCurrentPiece].setLocation(new double[] {currentPieceLoc[0], currentPieceLoc[1]});
        playerPieces.getPieces()[indexOfCurrentPiece].placed();
        for (Position p : mark) {
            gameBoard[(int)p.getLocation()[0]][(int)p.getLocation()[1]] = true;
        }
        currentPieceLoc[0] = 0;
        currentPieceLoc[1] = 0;
        numPlaced++;
        return false;
    }
    
    public ArrayList<Position> fixedPositions(ArrayList<Position> unmarked) {
        ArrayList<Position> mark = new ArrayList<Position>();
        for (Position p : unmarked) {
            mark.add(new Position(p.getLocation()[0] - 0.5, p.getLocation()[1] - 0.5));
        }
        return mark;
    }
    
    public void rotate() {
        playerPieces.getPieces()[indexOfCurrentPiece].rotateRight();
        ArrayList<Position> test = playerPieces.getPieces()[indexOfCurrentPiece].outline(currentPieceLoc);
        if (!verify(test, 20, 20)) {
            playerPieces.getPieces()[indexOfCurrentPiece].rotateLeft();
        }
    }
    
    public void flip() {
        playerPieces.getPieces()[indexOfCurrentPiece].flip();
        ArrayList<Position> test = playerPieces.getPieces()[indexOfCurrentPiece].outline(currentPieceLoc);
        if (!verify(test, 20, 20)) {
            playerPieces.getPieces()[indexOfCurrentPiece].flip();
        }
    }
    
    public void drawBoard() {
        StdDraw.setPenColor(StdDraw.GRAY);
        double position = 0;
        for (int i = 0; i <= 20; i++) {          //draws outside grid
            StdDraw.line(position, 0, position, 20);
            StdDraw.line(0, position, 20, position);
            position += 1;
        }
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 0; i < playerPieces.getPieces().length; i++) {
            setPosition(playerPieces.getPieces()[i].getLocation()[0], playerPieces.getPieces()[i].getLocation()[1]);
            drawPiece(i);
        }      
    }
    public boolean verify(ArrayList<Position> test, int upperX, int upperY) {
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).getLocation()[0] < 0 || test.get(i).getLocation()[0] > upperX || test.get(i).getLocation()[1] < 0 || test.get(i).getLocation()[1] > upperY) {
                return false;
            }
        }
        return true;
    }
    
    public void drawPiece(int index) {
        ArrayList<Position> drawHere = playerPieces.getPieces()[index].outline(positionInBoard);
        if (!verify(drawHere, 30, 30)) {
            return;
        }
        double[] range = new double[] {positionInBoard[0] - 1, positionInBoard[0] + 1, positionInBoard[1] - 1, positionInBoard[1] + 1};
        for (Position pos : drawHere) {
            StdDraw.filledSquare(pos.getLocation()[0], pos.getLocation()[1], SQUARE_SIZE);
            if (pos.getLocation()[0] < range[0]) {
                range[0] = pos.getLocation()[0] - 1;
            } else if (pos.getLocation()[0] > range[1]) {
                range[1] = pos.getLocation()[0] + 1;
            }
            if (pos.getLocation()[1] < range[2]) {
                range[2] = pos.getLocation()[1] - 1;
            } else if (pos.getLocation()[1] > range[3]) {
                range[3] = pos.getLocation()[1] + 1;
            }
        }
        playerPieces.getPieces()[index].setClickRange(range);
    }
    
    public boolean grabPiece(double x, double y) {
        for (int i = 0; i < playerPieces.getPieces().length; i++) {
//            double[] r = playerPieces.getPieces()[i].getClickRange();
//            System.out.println("index " + i + " " + r[0] + " " + r[1] + " " + r[2] + " " + r[3]);
            if (playerPieces.getPieces()[i].rangeContains(x, y)) {
                indexOfCurrentPiece = i;
                playerPieces.getPieces()[i].flipVisited();
                currentPieceLoc[0] = 5.5;
                currentPieceLoc[1] = 5.5;
                playerPieces.getPieces()[i].setLocation(currentPieceLoc);
//                if (numPlaced == 0) {
//                    placeFirst();
//                }
                return true;
            }
        }
//        System.out.println("click: " + x + " " + y);
        return false;
    }
}
