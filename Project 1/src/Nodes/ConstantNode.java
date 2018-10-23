package Nodes;

import Util.SymbolTable;

public class ConstantNode implements MerpNode {
    private int value;

    /**
     * Constructor that sets the value of this node
     *
     * @param value
     */
    public ConstantNode(int value) {
        this.value = value;
    }

    /**
     * Returns the value of this node
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {

    }

    /**
     * Returns the value of this node in prefix notation
     *
     * @return the integer value of this node
     */
    public java.lang.String toPrefixString() {

    }

    /**
     * Returns the value of this node in infix notation
     *
     * @return the integer value of this node
     */
    public java.lang.String toInfixString() {

    }

    /**
     * Returns the value of this node in postfix notation
     *
     * @return the integer value of this node
     */
    public java.lang.String toPostfixString() {

    }

    /**
     * Returns the precedence of this node
     *
     * @return returns the precedence of CONSTANT
     */
    public int getPrecedence() {

    }

    /**
     * determines if the node is an operation node
     *
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation() {

    }

    /**
     * Determines the node type
     *
     * @return the type of this node
     */
    public MerpNode.NodeType getNodeType() {

    }
}
