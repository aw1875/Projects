package Nodes;

import Util.SymbolTable;

public class NegationNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string _ The precedence is set to MULT_DIVIDE
     *
     * @param child
     */
    public NegationNode(MerpNode child) {
        super(child, Precedence.MULT_DIVIDE, "_");
    }

    /**
     * Evaluates the node to determine its integer value
     *
     * @param symbolTable
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return Integer.parseInt("-") + child.evaluate(symbolTable);
    }
}
