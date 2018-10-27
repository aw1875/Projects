package Nodes;

public abstract class UnaryOperatorNode implements MerpNode {
    protected MerpNode child;
    protected java.lang.String operator;
    protected Precedence precedence;

    /**
     * Unary Node Constructor
     *
     * @param child
     * @param precedence
     * @param operator
     */
    public UnaryOperatorNode(MerpNode child, Precedence precedence, java.lang.String operator) {
        this.child = child;
        this.precedence = precedence;
        this.operator = operator;
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
        return operator + " " + child.toPrefixString();
    }

    /**
     * Displays this node as infix notation expression string
     *
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString() {
        return "(" + operator + " " + child.toInfixString() + ")";
    }

    /**
     * Displays this node as postfix notation expression string
     *
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString() {
        return child.toPostfixString() + " " + operator;
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
        if (this.operator != null) {
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
        return NodeType.UnaryOperation;
    }

}