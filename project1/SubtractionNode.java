package Nodes;

import Util.SymbolTable;

public class SubtractionNode extends BinaryOperatorNode {

    /**
     * Constructor that sets the left/right children and sets the operator to the string - The precedence is set to ADD_SUBTRACT
     *
     * @param left
     * @param right
     */
    public SubtractionNode(MerpNode left, MerpNode right) {
        super(left, right, Precedence.ADD_SUBTRACT, "-");
    }

    /**
     * Evaluates the node to determine its integer value
     *
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) - rightChild.evaluate(symbolTable);
    }

}
