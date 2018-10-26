package Processors;

import Nodes.MerpNode;
import Util.SymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquationProcessor {

    private java.util.ArrayList<java.lang.String> equations;
    private MerpProcessor processor;
    private SymbolTable symbolTable;

    /**
     * Constructor to create an Equation Processor. Creates an empty SymbolTable.
     *
     * @param equations
     * @param processor
     */
    public EquationProcessor(java.util.ArrayList<java.lang.String> equations, MerpProcessor processor) {
        this.equations = equations;
        this.processor = processor;
        this.symbolTable = new SymbolTable();
    }

    /**
     * Processes the provided list of statements using the provided Merp Processor and Symbol Table.
     */
    public void processEquations() {
        for (String input : equations) {
            ArrayList<String> equation = new ArrayList<String>(Arrays.asList(input.split("=")));
            if (equation.size() > 1) {
                String left = equation.get(0).trim();
                ArrayList<String> eq = new ArrayList<String>(Arrays.asList(equation.get(1).trim().split(" ")));
                this.processor.constructTree(eq);
                int right = processor.evaluateTree(symbolTable);
                symbolTable.put(left, right);
            }
        }
    }

    /**
     * Process equation from given input
     * @param eq
     */
/*    private void processEquation(java.lang.String eq) {

    }*/
}
