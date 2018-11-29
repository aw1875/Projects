package Processors;

import Nodes.BinaryOperatorNode;
import Nodes.MerpNode;
import Nodes.UnaryOperatorNode;

import java.util.Stack;

public class MerpPostfixProcessor extends MerpProcessor {

    public MerpPostfixProcessor() {

    }

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using postfix notation
     * @param tokens list of IerpNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        Stack<MerpNode> stack = new Stack<>();
        for (String i : tokens) {
            MerpNode currNode = createMerpNode(i);
            if (currNode.getNodeType().equals(MerpNode.NodeType.Constant) || currNode.getNodeType().equals(MerpNode.NodeType.Variable)) {
                stack.push(currNode);
            } else {
                if (currNode instanceof BinaryOperatorNode) {
                    MerpNode right = stack.pop();
                    MerpNode left = stack.pop();
                    ((BinaryOperatorNode) currNode).setLeftChild(left);
                    ((BinaryOperatorNode) currNode).setRightChild(right);
                    stack.push(currNode);
                } else if (currNode instanceof UnaryOperatorNode) {
                    MerpNode child = stack.pop();
                    ((UnaryOperatorNode) currNode).setChild(child);
                    stack.push(currNode);
                }
            }
        }
        tree = stack.pop();
    }

    /**
     * Helper to recursively contstruct the parse tree
     * @param tokens
     * @return current root ogf the parse tree
     */
/*    private MerpNode constructTreeHelper(java.util.ArrayList<java.lang.String> tokens) {

    }*/
}
