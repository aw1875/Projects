package Processors;

import Nodes.ConstantNode;
import Nodes.MerpNode;
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
        Stack<MerpNode> op = new Stack<>();
        Stack<MerpNode> val = new Stack<>();
        for (String i : tokens) {
            MerpNode tempNode = createMerpNode(i);
            if (tempNode.getNodeType().equals(MerpNode.NodeType.Constant) || tempNode.getNodeType().equals(MerpNode.NodeType.Variable)) {
                val.push(tempNode);
            } else {
                op.push(tempNode);
            }
        }

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
