package Nodes;

import Util.SymbolTable;

public class GreaterThanNode extends BooleanOperatorNode {
    /**
     * Constructor that sets the left/right children and sets the operator to the string >
     *
     * @param left
     * @param right
     */
    public GreaterThanNode(MerpNode left, MerpNode right) {
        super(left, right, ">");
    }

    /**
     * Evaluates the node to determine its integer value 1 for true, zero for false
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        if (leftChild.evaluate(symbolTable) > rightChild.evaluate(symbolTable)) {
            return 1;
        }
        return 0;
    }
}
