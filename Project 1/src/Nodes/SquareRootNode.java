package Nodes;

import Util.SymbolTable;

public class SquareRootNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string @ The precedence is set to POWER
     *
     * @param child
     */
    public SquareRootNode(MerpNode child) {
        super(child, Precedence.POWER, "@");
    }

    /**
     * Evaluates the node to determine its integer value Errors if the child evaluates to a negative number
     *
     * @param symbolTable
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return (int)Math.sqrt(child.evaluate(symbolTable));
    }

}
