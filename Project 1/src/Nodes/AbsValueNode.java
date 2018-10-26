package Nodes;

import Util.SymbolTable;

public class AbsValueNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string | The precedence is set to MULT_DIVIDE
     *
     * @param child
     */
    public AbsValueNode(MerpNode child) {
        super(child, Precedence.MULT_DIVIDE, "|");
    }

    /**
     * Evaluates the node to determine its integer value
     *
     * @param symbolTable
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return Math.abs(child.evaluate(symbolTable));
    }
}
