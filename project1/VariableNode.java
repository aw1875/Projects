package Nodes;

import Util.SymbolTable;

public class VariableNode implements MerpNode {
    private java.lang.String name;

    /**
     * Variable Node Constructor
     *
     * @param name
     */
    public VariableNode(java.lang.String name) {
        this.name = name;
    }

    /**
     * Evaluates the node to determine its integer value
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return symbolTable.get(this.name);
    }

    /**
     * Displays this node as prefix notation expression string
     *
     * @return string representing the node as prefix notation
     */
    public java.lang.String toPrefixString() {
        return this.name;
    }

    /**
     * Displays this node as infix notation expression string
     *
     * @return string representing the node as infix notation
     */
    public java.lang.String toInfixString() {
        return this.name;
    }

    /**
     * Displays this node as postfix notation expression string
     *
     * @return string representing the node as postfix notation
     */
    public java.lang.String toPostfixString() {
        return this.name;
    }

    /**
     * Returns the precedence of this node
     *
     * @return returns the precedence of CONSTANT, which is 3.
     */
    public int getPrecedence() {
        return 3;
    }

    /**
     * determines if the node is an operation node
     *
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation() {
        return false;
    }

    /**
     * Determines the node type
     *
     * @return the type of this node
     */
    public MerpNode.NodeType getNodeType() {
        return NodeType.Variable;
    }
}
