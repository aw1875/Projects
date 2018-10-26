package Processors;


import Nodes.*;

import java.util.*;

public class MerpInfixProcessor extends MerpProcessor {

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     *
     * @param tokens list of IerpNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        Stack<MerpNode> op = new Stack<>();
        Stack<MerpNode> val = new Stack<>();

        for (String i : tokens) {
            MerpNode currNode = createMerpNode(i);
            if (currNode.getNodeType().equals(MerpNode.NodeType.Constant) || currNode.getNodeType().equals(MerpNode.NodeType.Variable)) {
                val.push(currNode);
            } else {
                while ((!op.empty()) && (op.peek().getPrecedence() <= currNode.getPrecedence())) {
                    MerpNode operator = op.pop();
                    if (operator instanceof BinaryOperatorNode) {
                        MerpNode left = val.pop();
                        MerpNode right = val.pop();
                        ((BinaryOperatorNode) operator).setLeftChild(left);
                        ((BinaryOperatorNode) operator).setRightChild(right);
                        val.push(operator);
                    } else if (operator instanceof UnaryOperatorNode) {
                        MerpNode child = val.pop();
                        ((UnaryOperatorNode) operator).setChild(child);
                        val.push(operator);
                    }
                }
                op.push(currNode);
            }
        }
        while (!(op.empty())) {
            MerpNode operator = op.pop();
            if (operator instanceof BinaryOperatorNode) {
                MerpNode right = val.pop();
                MerpNode left = val.pop();
                ((BinaryOperatorNode) operator).setLeftChild(left);
                ((BinaryOperatorNode) operator).setRightChild(right);
                val.push(operator);
            } else if (operator instanceof UnaryOperatorNode) {
                MerpNode child = val.pop();
                ((UnaryOperatorNode) operator).setChild(child);
                val.push(operator);
            }
        }
        tree = val.pop();
    }
}
