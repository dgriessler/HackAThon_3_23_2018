public class Pieces {
    public Node tPiece = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.RIGHT, DIRECTION.LEFT, DIRECTION.LEFT}, new double[] {1.5, 29.5});
    public Node onePiece = new Node(new double[] {5.5, 29.5});
    public Node twoPiece = new Node(new DIRECTION[] {DIRECTION.DOWN}, new double[] {9.5, 29.5});
    public Node threePiece = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.RIGHT}, new double[] {13.5, 29.5});
    public Node hookSmall = new Node(new DIRECTION[] {DIRECTION.RIGHT, DIRECTION.DOWN, DIRECTION.DOWN}, new double[] {17.5, 29.5});
    public Node zigZag = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.LEFT, DIRECTION.DOWN, DIRECTION.DOWN}, new double[] {21.5, 29.5});
    public Node threeSurprise = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.UP, DIRECTION.LEFT}, new double[] {25.5, 29.5});
    public Node fourSurprise = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.UP, DIRECTION.UP, DIRECTION.LEFT}, new double[] {29.5, 29.5});
    public Node threeTall = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN}, new double[] {1.5, 24.5});
    public Node fourTall = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.DOWN}, new double[] {5.5, 24.5});
    public Node fiveTall = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.DOWN}, new double[]{9.5, 24.5});
    public Node allAround = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.UP, DIRECTION.RIGHT, DIRECTION.LEFT, DIRECTION.LEFT}, new double[] {13.5, 24.5});
    public Node hookBig = new Node(new DIRECTION[] {DIRECTION.RIGHT, DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.DOWN}, new double[] {17.5, 24.5});
    public Node lifeRaft = new Node(new DIRECTION[] {DIRECTION.LEFT, DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.RIGHT}, new double[] {21.5, 24.5});
    public Node upOver = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.RIGHT, DIRECTION.DOWN}, new double[] {25.5, 24.5});
    public Node standOut = new Node(new DIRECTION[] {DIRECTION.DOWN, DIRECTION.DOWN, DIRECTION.RIGHT, DIRECTION.LEFT, DIRECTION.UP, DIRECTION.LEFT}, new double[] {29.5, 24.5});
    private Node[] pieces;
    Pieces() {
        pieces = new Node[] {tPiece, onePiece, twoPiece, threePiece, hookSmall, zigZag, threeSurprise, fourSurprise, threeTall, fourTall, fiveTall, allAround, hookBig, lifeRaft, upOver, standOut}; 
    }
    public Node[] getPieces() {
        return pieces;
    }
//    public Node[] t_Piece = t_piece();
//    public Node[] one_piece = one_piece();
//    public Node[] two_piece = two_piece();
//    public Node[] three_piece = three_piece();
//    public Node[] hook_small = hook_small();
//    public Node[] zig_zag = zig_zag();
//    public Node[] three_suprise = three_surprise();
//    public Node[] four_surprise = four_surprise();
//    public Node[] three_Tall = three_Tall();
//    public Node[] four_Tall = four_Tall();
//    public Node[] five_Tall = five_Tall();
//    public Node[] all_Around = all_Around();
//    public Node[] hook_Big = hook_Big();
//    public Node[] life_Raft = life_Raft();
//    public Node[] up_Over = up_Over();
//    public Node[] stand_Out = stand_Out();
//    
//    /**
//     * T-piece hard-coded constructor. Default is t upside down
//     * @return nodes linked together in t shape
//     */
//    private Node[] t_piece() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //upside down t, top node
//        nodes[1] = new Node(2); //upside down t, middle node
//        nodes[2] = new Node(3); //upside down t, t in center on bottom
//        nodes[3] = new Node(1); //upside down t, bottom right node
//        nodes[4] = new Node(1); //upside down t, bottom left node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point down from top node  to middle node
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point up from middle node to top node
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //point down from middle node to center bottom node
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //point up from center bottom node to middle node
//        nodes[2].setPointer(1, nodes[3], DIRECTION.RIGHT);   //point right from center bottom to bottom right
//        nodes[2].setPointer(2, nodes[4], DIRECTION.LEFT);   //point left from center bottom to bottom left
//        nodes[3].setPointer(0, nodes[2], DIRECTION.LEFT);   //point left from bottom right node to center bottom
//        nodes[4].setPointer(0, nodes[2], DIRECTION.RIGHT);   //point right from bottom left node to center bottom
//        return nodes;
//    }
//    /**
//     * 1-Piece hard-coded constructor.
//     * @return one node
//     */
//    private Node[] one_piece() {
//        Node[] nodes = new Node[1];
//        nodes[0] = new Node(0); //only one node
//        return nodes;
//    }
//    /**
//     * 2-Piece hard-coded constructor. Default is vertical
//     * @return nodes linked together for 2-piece
//     */
//    private Node[] two_piece() {
//        Node[] nodes = new Node[2];
//        nodes[0] = new Node(1); //top node
//        nodes[1] = new Node(1); //bottom node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point down from top node to bottom node
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point up from bottom node to top node
//        return nodes;
//    }
//    /**
//     * 3-Piece hard-coded constructor. Default is L shape
//     * @return nodes linked together
//     */
//    private Node[] three_piece() {
//        Node[] nodes = new Node[3];
//        nodes[0] = new Node(1); //top node
//        nodes[1] = new Node(2); //middle node
//        nodes[2] = new Node(2); //right-bottom node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point from top node to middle node
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point from middle node to top node
//        nodes[1].setPointer(1, nodes[2], DIRECTION.RIGHT);   //point from middle node to right node
//        nodes[2].setPointer(0, nodes[1], DIRECTION.LEFT);   //point from right node to middle node
//        return nodes;
//    }
//    /**
//     * Hook piece hard-coded constructor. Default is hook up and to the left.
//     * @return nodes linked together
//     */
//    private Node[] hook_small() {
//        Node[] nodes = new Node[4];
//        nodes[0] = new Node(1); //hook top
//        nodes[1] = new Node(2); //top node
//        nodes[2] = new Node(2); //middle node
//        nodes[3] = new Node(1); //bottom node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.RIGHT);   //point from hook to top node
//        nodes[1].setPointer(0, nodes[2], DIRECTION.DOWN);   //point from top node down to middle node
//        nodes[1].setPointer(1, nodes[0], DIRECTION.LEFT);   //point from top node left to hook
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //point from middle node up to top node
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //point from middle node down to bottom node
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //point from bottom node up to middle node
//        return nodes;
//    }
//    /**
//     * Zig_Zag piece.  Default is zig to the left and vertical
//     * @return nodes linked together
//     */
//    private Node[] zig_zag() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //top node
//        nodes[1] = new Node(2); //middle right node
//        nodes[2] = new Node(2); //middle left node
//        nodes[3] = new Node(2); //second_from_bottom node
//        nodes[4] = new Node(1); //bottom node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point from top node down to middle right
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point from middle right to top node
//        nodes[1].setPointer(1, nodes[2], DIRECTION.LEFT);   //point from middle right to middle left
//        nodes[2].setPointer(0, nodes[1], DIRECTION.RIGHT);   //point from middle left to middle right
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //point from middle left to second_from_bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //point from second_from_bottom to middle 
//        nodes[3].setPointer(1, nodes[4], DIRECTION.DOWN);   //point from second_from_bottom to bottom
//        nodes[4].setPointer(0, nodes[3], DIRECTION.UP);   //point from bottom to second_from_bottom
//        return nodes;
//    }
//    /**
//     * Three tall piece with piece out of the middle. Default is sticking out to the left and vertical.
//     * @return nodes linked together
//     */
//    private Node[] three_surprise() {
//        Node[] nodes = new Node[4];
//        nodes[0] = new Node(1); //top node
//        nodes[1] = new Node(3); //middle node
//        nodes[2] = new Node(1); //extrusion from middle node
//        nodes[3] = new Node(1); //bottom node
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point from top to middle
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point from middle to top
//        nodes[1].setPointer(1, nodes[3], DIRECTION.DOWN);   //point from middle to bottom
//        nodes[1].setPointer(2, nodes[2], DIRECTION.LEFT);   //point from middle to extrusion
//        nodes[2].setPointer(0, nodes[1], DIRECTION.RIGHT);   //point from extrusion to middle
//        nodes[3].setPointer(0, nodes[1], DIRECTION.UP);   //point from bottom to middle
//        return nodes;
//    }
//    /**
//     * Four tall piece with extrusion from second top. Default is verticle with extrusion to the left
//     * @return nodes linked together
//     */
//    private Node[] four_surprise() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //top node
//        nodes[1] = new Node(3); //second top
//        nodes[2] = new Node(2); //second_bottom
//        nodes[3] = new Node(2); //bottom node
//        nodes[4] = new Node(1); //extrusion to left from second top
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point from top to second top
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point from second top to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //point from second top to second_bottom
//        nodes[1].setPointer(2, nodes[4], DIRECTION.LEFT);   //point from second top to extrusion
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //point from second_bottom to second_top
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //point from second_bottom to bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //point from bottom to second_bottom
//        nodes[4].setPointer(0, nodes[1], DIRECTION.RIGHT);   //point from extrusion to second top
//        return nodes;
//    }
//    /**
//     * Three tall vertical piece. Default: vertical
//     * @return nodes linked together
//     */
//    private Node[] three_Tall() {
//        Node[] nodes = new Node[3];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(2); //middle
//        nodes[2] = new Node(1); //bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //point from top to middle
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //point from middle to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //point from middle to bottom
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //point from bottom to middle
//        return nodes;
//    }
//    /**
//     * Four tall vertical piece. Default: vertical
//     * @return nodes linked together
//     */
//    private Node[] four_Tall() {
//        Node[] nodes = new Node[4];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(2); //second_top
//        nodes[2] = new Node(2); //second_bottom
//        nodes[3] = new Node(1); //bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //top to second_top
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //second_top to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //second_top to second_bottom
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //second_bottom to second_top
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //second_bottom to bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //bottom to second_bottom
//        return nodes;
//    }
//    /**
//     * Five tall vertical piece. Default: vertical
//     * @return nodes linked together
//     */
//    private Node[] five_Tall() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(2); //second_top
//        nodes[2] = new Node(2); //middle
//        nodes[3] = new Node(2); //second_bottom
//        nodes[4] = new Node(1); //bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //top to second_top
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //second_top to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //second_top to middle
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //middle to second_top
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //middle to second_bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //second_bottom to middle
//        nodes[3].setPointer(1, nodes[4], DIRECTION.DOWN);   //second_bottom to bottom
//        nodes[4].setPointer(0, nodes[3], DIRECTION.UP);   //bottom to second_bottom
//        return nodes;
//    }
//    /**
//     * Orientation doesn't matter, it looks the same. One center all surrounded
//     * @return nodes linked together
//     */
//    private Node[] all_Around() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(4); //middle
//        nodes[2] = new Node(1); //bottom
//        nodes[3] = new Node(1); //right
//        nodes[4] = new Node(1); //left
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //top to middle
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //middle to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //middle to bottom
//        nodes[1].setPointer(2, nodes[3], DIRECTION.RIGHT);   //middle to right
//        nodes[1].setPointer(3, nodes[4], DIRECTION.LEFT);   //middle to left
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //bottom to middle
//        nodes[3].setPointer(0, nodes[1], DIRECTION.LEFT);   //right to middle
//        nodes[4].setPointer(0, nodes[1], DIRECTION.RIGHT);   //left to middle
//        return nodes;
//    }
//    /**
//     * Big hook, 4 tall. Default: hook to the left and vertical
//     * @return nodes linked together
//     */
//    private Node[] hook_Big() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //hook 
//        nodes[1] = new Node(2); //top
//        nodes[2] = new Node(2); //second_top
//        nodes[3] = new Node(2); //second_bottom
//        nodes[4] = new Node(1); //bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.RIGHT);   //hook to top
//        nodes[1].setPointer(0, nodes[2], DIRECTION.DOWN);   //top to second_top
//        nodes[1].setPointer(1, nodes[0], DIRECTION.LEFT);   //top to hook
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //second_top to top
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //second_top to second_bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //second_bottom to second_top
//        nodes[3].setPointer(1, nodes[4], DIRECTION.DOWN);   //second_bottom to bottom
//        nodes[4].setPointer(0, nodes[3], DIRECTION.UP);   //bottom to second_bottom
//        return nodes;
//    }
//    /**
//     * Life raft, two extrusion from three piece. Default: sideways, extrusions to the right
//     * @return nodes linked together
//     */
//    private Node[] life_Raft() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //extrusion top
//        nodes[1] = new Node(2); //top
//        nodes[2] = new Node(2); //middle
//        nodes[3] = new Node(2); //bottom
//        nodes[4] = new Node(1); //extrusion bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.LEFT);   //extrusion top to top
//        nodes[1].setPointer(0, nodes[2], DIRECTION.DOWN);   //top to middle
//        nodes[1].setPointer(1, nodes[0], DIRECTION.RIGHT);   //top to extrusion top
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //middle to top
//        nodes[2].setPointer(1, nodes[3], DIRECTION.DOWN);   //middle to bottom
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //bottom to middle
//        nodes[3].setPointer(1, nodes[4], DIRECTION.RIGHT);   //bottom to extrusion bottom
//        nodes[4].setPointer(0, nodes[3], DIRECTION.LEFT);   //extrusion bottom to bottom
//        return nodes;
//    }
//    /**
//     * Small zig-zag. Default: vertical, zig to the right
//     * @return nodes linked together
//     */
//    private Node[] up_Over() {
//        Node[] nodes = new Node[4];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(2); //middle left
//        nodes[2] = new Node(2); //middle right
//        nodes[3] = new Node(1); //bottom
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //top to middle left
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //middle left to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.RIGHT);   //middle left to middle right
//        nodes[2].setPointer(0, nodes[3], DIRECTION.DOWN);   //middle right to bottom
//        nodes[2].setPointer(1, nodes[1], DIRECTION.LEFT);   //middle right to middle left
//        nodes[3].setPointer(0, nodes[2], DIRECTION.UP);   //bottom to middle right
//        return nodes;
//    }
//    private Node[] stand_Out() {
//        Node[] nodes = new Node[5];
//        nodes[0] = new Node(1); //top
//        nodes[1] = new Node(3); //middle
//        nodes[2] = new Node(2); //bottom
//        nodes[3] = new Node(1); //extrusion left
//        nodes[4] = new Node(1); //extrusion right
//        nodes[0].setPointer(0, nodes[1], DIRECTION.DOWN);   //top to middle
//        nodes[1].setPointer(0, nodes[0], DIRECTION.UP);   //middle to top
//        nodes[1].setPointer(1, nodes[2], DIRECTION.DOWN);   //middle to bottom
//        nodes[1].setPointer(2, nodes[3], DIRECTION.LEFT);   //middle to extrusion left
//        nodes[2].setPointer(0, nodes[1], DIRECTION.UP);   //bottom to middle
//        nodes[2].setPointer(1, nodes[4], DIRECTION.RIGHT);   //bottom to extrusion right
//        nodes[3].setPointer(0, nodes[1], DIRECTION.RIGHT);   //extrusion left to middle
//        nodes[4].setPointer(0, nodes[2], DIRECTION.LEFT);   //extrusion right to bottom
//        return nodes;
//    }
}
