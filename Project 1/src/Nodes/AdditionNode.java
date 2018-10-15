package Nodes;

import Util.SymbolTable;

public class AdditionNode extends BinaryOperatorNode {
    public AdditionNode(MerpNode left, MerpNode right) {
        super(left,right,Precedence.ADD_SUBTRACT,"+");
    }

    public int evaluate(SymbolTable symbolTable) {
        return leftChild.evaluate(symbolTable) + operator.charAt(0) + rightChild.evaluate(symbolTable);
    }
}
