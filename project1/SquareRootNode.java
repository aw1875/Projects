package Nodes;

import Util.Errors;
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
        if (child.evaluate(symbolTable) < 0) {
            Util.Errors.error("Taking the square root of a negative number would result in an imaginary number", null); // Get error if number is a negative number.
        }
        return (int)Math.sqrt(child.evaluate(symbolTable));
    }

}
