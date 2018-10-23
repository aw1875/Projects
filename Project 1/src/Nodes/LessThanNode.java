package Nodes;

import Util.SymbolTable;

public class LessThanNode extends BooleanOperatorNode {
    /**
     * Constructor that sets the left/right children and sets the operator to the string <
     *
     * @param left
     * @param right
     */
    public LessThanNode(MerpNode left, MerpNode right) {
        super(left, right, "<");
    }

    /**
     * Evaluates the node to determine its integer value 1 for true, zero for false
     *
     * @param symbolTable
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) + Integer.parseInt(operator) + rightChild.evaluate(symbolTable);
    }

}
