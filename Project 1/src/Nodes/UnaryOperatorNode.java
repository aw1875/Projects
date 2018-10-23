package Nodes;

public abstract class UnaryOperatorNode implements MerpNode {
    protected MerpNode child;
    protected java.lang.String operater;
    protected Precedence precedence;

    /**
     * Unary Node Constructor
     *
     * @param child
     * @param precedence
     * @param operater
     */
    public UnaryOperatorNode(MerpNode child, Precedence precedence, java.lang.String operater) {
        this.child = child;
        this.precedence = precedence;
        this.operater = operater;
    }

    /**
     * Sets the child of this node
     *
     * @param child
     */
    public void setChild(MerpNode child) {
        this.child = child;
    }

    /**
     * Displays this node as prefix notation expression string
     *
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString() {
        return operater + " " + child;
    }

    /**
     * Displays this node as infix notation expression string
     *
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString() {
        return child + " " + operater;
    }

    /**
     * Displays this node as postfix notation expression string
     *
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString() {
        return child + " " + operater;
    }

    /**
     * Returns the precedence of this node
     *
     * @return returns the precedence as an int value
     */
    public int getPrecedence() {
        return this.precedence.getPrecedence();
    }

    /**
     * determines if the node is an operation node
     *
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation() {
        if (this.operater != null) {
            return true;
        }
        return false;
    }

    /**
     * Determines the node type
     *
     * @return the type of this node
     */
    public MerpNode.NodeType getNodeType() {
        return this.getNodeType();
    }

}