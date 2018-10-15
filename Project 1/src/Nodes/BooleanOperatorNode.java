package Nodes;

public abstract class BooleanOperatorNode extends BinaryOperatorNode {
    public BooleanOperatorNode(MerpNode left, MerpNode right, java.lang.String operator) {
        super(left,right,Precedence.BOOLEAN,operator);
    }

    public int getPrecedence() {
        return Precedence.BOOLEAN.getPrecedence();
    }
}
