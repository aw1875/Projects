package Processors;


import Nodes.*;
import Util.SymbolTable;

import java.util.*;

public class MerpInfixProcessor extends MerpProcessor {

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     * @param tokens list of IerpNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        Stack<MerpNode> op = new Stack<>();
        Stack<MerpNode> val = new Stack<>();

        for (String i : tokens) {
            MerpNode tempNode = createMerpNode(i);
            if (tempNode.getNodeType().equals(MerpNode.NodeType.Constant) || tempNode.getNodeType().equals(MerpNode.NodeType.Variable)) {
                val.push(tempNode);
            } else {
                op.push(tempNode);
            }
            while ((!op.empty()) && (op.peek().getPrecedence() >= tempNode.getPrecedence())) {
                val.push(op.pop());
            }
        }
        System.out.println(val.peek().getNodeType());
        /*if (val.peek().getNodeType().equals(MerpNode.NodeType.BinaryOperation)) {
            MerpNode left = val.pop();
            MerpNode operator = val.pop();
            MerpNode right = val.pop();
            BinaryOperatorNode n1 = new BinaryOperatorNode(left, right, , operator) {
                @Override
                public int evaluate(SymbolTable symbolTable) {
                    return 0;
                }
            };
            val.push(n1);
        } else {
            MerpNode child = val.pop();
            val.pop();
            MerpNode n1 = new UnaryOperatorNode(null, null, null) {
                @Override
                public int evaluate(SymbolTable symbolTable) {
                    return 0;
                }
            };
            ((UnaryOperatorNode) n1).setChild(child);
            val.push(n1);
        }
        tree = val.pop();*/
    }

    /**
     * Processes an stack of IerpNodes to create a Ierp Parse Tree
     * @param stack
     * @return the root of the parse tree
     */
/*    private MerpNode processStack(java.util.Stack<MerpNode> stack) {

    }*/
}
