package Processors;

import Nodes.BinaryOperatorNode;
import Nodes.ConstantNode;
import Nodes.MerpNode;
import Nodes.UnaryOperatorNode;

import java.util.*;

public class MerpPrefixProcessor extends MerpProcessor {

    public MerpPrefixProcessor() {

    }

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using prefix notation
     *
     * @param tokens list of IerpNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        Stack<MerpNode> stack = new Stack<>();
        for (int i = tokens.size() - 1; i >= 0; i --) {
            MerpNode currNode = createMerpNode(tokens.get(i));
            if (currNode.getNodeType().equals(MerpNode.NodeType.Constant) || currNode.getNodeType().equals(MerpNode.NodeType.Variable)) {
                stack.push(currNode);
            } else {
                if (currNode instanceof BinaryOperatorNode) {
                    MerpNode left = stack.pop();
                    MerpNode right = stack.pop();
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
     * Helper to recursively construct the parse tree
     * @param tokens
     * @return current root ogf the parse tree
     */
/*    private MerpNode constructTreeHelper(java.util.ArrayList<java.lang.String> tokens) {
        MerpNode newNode = createMerpNode(tokens.get(0));
        tokens.remove(0);

        if (newNode.equals(MerpNode.NodeType.Constant) || newNode.equals(MerpNode.NodeType.Variable)) {
            return newNode;
        } else if (newNode.equals(MerpNode.NodeType.BinaryOperation)) {
            newNode.
        }

    }*/
}
