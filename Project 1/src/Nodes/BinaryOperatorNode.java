package Nodes;

public abstract class BinaryOperatorNode implements MerpNode {
    protected MerpNode leftChild;
    protected String operator;
    protected Precedence precedence;
    protected MerpNode rightChild;

    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild, Precedence precedence, String operator) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    public MerpNode.NodeType getNodeType() {
        return this.getNodeType();
    }

    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }

    public boolean isOperation() {
        if (this.operator != null) {
            return true;
        }
        return false;
    }

    public void setLeftChild(MerpNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(MerpNode rightChild) {
        this.rightChild = rightChild;
    }

    public String toInfixString() {
        return leftChild + " " + operator + " " + rightChild;
    }

    public String toPostfixString() {
        return leftChild + " " + rightChild + " " + operator;
    }

    public String toPrefixString() {
        return operator + " " + leftChild + " " + rightChild;
    }
}
