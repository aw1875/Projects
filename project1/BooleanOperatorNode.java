package Nodes;

public abstract class BooleanOperatorNode extends BinaryOperatorNode {
    /**
     * Constructor for Boolean operation nodes The precedence is set to BOOLEAN
     *
     * @param left
     * @param right
     * @param operator
     */
    public BooleanOperatorNode(MerpNode left, MerpNode right, java.lang.String operator) {
        super(left, right, Precedence.BOOLEAN, operator);
    }

    /**
     * Returns the precedence of this node
     *
     * @return returns the precedence of BOOLEAN
     */
    public int getPrecedence() {
        return precedence.getPrecedence();
    }
}
