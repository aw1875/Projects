package Nodes;

import Util.SymbolTable;

public interface MerpNode {

    //Test comment
    public enum NodeType {}

    public int evaluate(SymbolTable symbolTable);

    public java.lang.String toPrefixString();

    public java.lang.String toInfixString();

    public java.lang.String toPostfixString();

    public int getPrecedence();

    public boolean isOperation();

    public MerpNode.NodeType getNodeType();
}
