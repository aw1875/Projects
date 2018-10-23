package Nodes;

public abstract class BinaryOperatorNode implements MerpNode {
    protected MerpNode leftChild;
    protected String operator;
    protected Precedence precedence;
    protected MerpNode rightChild;

    /**
     * Binary Node Constructor
     *
     * @param leftChild
     * @param rightChild
     * @param precedence
     * @param operator
     */
    public BinaryOperatorNode(MerpNode leftChild, MerpNode rightChild, Precedence precedence, String operator) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.precedence = precedence;
        this.operator = operator;
    }

    /**
     * Setter for left child
     *
     * @param leftChild
     */
    public void setLeftChild(MerpNode leftChild) {

        this.leftChild = leftChild;
    }

    /**
     * Setter for right child
     *
     * @param rightChild
     */
    public void setRightChild(MerpNode rightChild) {

        this.rightChild = rightChild;
    }

    /**
     * Displays this node as prefix notation expression string
     *
     * @return string representing the node as prefix notation
     */
    public String toPrefixString() {

        return operator + " " + leftChild + " " + rightChild;
    }

    /**
     * Displays this node as infix notation expression string
     *
     * @return string representing the node as infix notation
     */
    public String toInfixString() {

        return leftChild + " " + operator + " " + rightChild;
    }

    /**
     * Displays this node as postfix notation expression string
     *
     * @return string representing the node as postfix notation
     */
    public String toPostfixString() {

        return leftChild + " " + rightChild + " " + operator;
    }

    /**
     * Returns the precedence of this node
     *
     * @return returns the precedence of this node as an int value
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

        return this.getNodeType();
    }


}
