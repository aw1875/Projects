package Nodes;

public class UnaryOperatorNode {
    protected MerpNode child;
    protected java.lang.String operater;
    protected Precedence precedence;

    public UnaryOperatorNode(MerpNode child, Precedence precedence, java.lang.String operater) {

    }

    public void setChild(MerpNode child) {
        this.child = child;
    }

    public java.lang.String toPrefixString() {
        java.lang.String test = "";
        return test;
    }
}
