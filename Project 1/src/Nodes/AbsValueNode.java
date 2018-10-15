package Nodes;

import Util.SymbolTable;

public class AbsValueNode extends UnaryOperatorNode {

    public AbsValueNode(MerpNode child) {
        super(child, precedence.MULT_DIVIDE, "|");
    }

    public int evaluate(SymbolTable symbolTable) {
        return Math.abs(child.evaluate(symbolTable));
    }
}
