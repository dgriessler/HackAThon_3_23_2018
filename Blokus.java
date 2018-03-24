public class Blokus {
    private static final int L = 40;
    private static final int U = 39;
    private static final int R  = 38;
    private static final int D = 37;
    public static DIRECTION check (final DIRECTION keyPress) {
        if (StdDraw.isKeyPressed(D)) {
            return DIRECTION.DOWN;
        } else if (StdDraw.isKeyPressed(R)) {
            return DIRECTION.RIGHT;
        } else if (StdDraw.isKeyPressed(U)) {
            return DIRECTION.UP;
        } else if (StdDraw.isKeyPressed(L)) {
            return DIRECTION.LEFT;
        } else if (StdDraw.isKeyPressed(80)) {
            return DIRECTION.PLACE;
        } else if (StdDraw.isKeyPressed(82)) {
            return DIRECTION.ROTATE;
        } else if (StdDraw.isKeyPressed(70)) {
            return DIRECTION.FLIP;
        } else {
            return keyPress;
        }
    }
    public static void play(Board game) {
        DIRECTION keyPress = null;
        boolean pieceGrabbed = false;
        while (game.play()) {
            StdDraw.clear();
            game.drawBoard();
            StdDraw.text(25, 17, "Welcome to Blokus!");
            if (!pieceGrabbed) {
                StdDraw.text(25, 15, "Pick a shape to place it!");
            } else {
                StdDraw.text(25, 15, "Great! Now use the arrow keys");
                StdDraw.text(25, 14, "to move the shape");
                StdDraw.text(25, 13, "Press 'p' to place it or 'r' to rotate");
            }
            if (!pieceGrabbed && StdDraw.mousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                if (y > 20) {
                    pieceGrabbed = game.grabPiece(x, y);
                }
            }
            if (pieceGrabbed) {
                keyPress = check(keyPress);
                if (keyPress == DIRECTION.PLACE) {
                    pieceGrabbed = game.place();
                } else if (keyPress == DIRECTION.ROTATE) {
                    game.rotate();
                } else if (keyPress == DIRECTION.FLIP) {
                    game.flip();
                }
                if (keyPress != null) {
                    game.move(keyPress);
                }
                keyPress = null;
            }
            StdDraw.show();
            StdDraw.pause(90);
            if (!game.play()) {
                StdDraw.clear();
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(15, 15, "YOU WON");
                StdDraw.show();
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Board game = new Board();
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setScale(0, 30);
        StdDraw.setPenRadius(0.002);
        play(game);
    }
}
