package Processors;

import Util.SymbolTable;

import java.util.ArrayList;
import java.util.Arrays;

public class EquationProcessor {

    private java.util.ArrayList<java.lang.String> equations;
    private MerpProcessor processor;
    private SymbolTable symbolTable;

    /**
     * Constructor to create an Equation Processor. Creates an empty SymbolTable.
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
            processEquation(input);
        }
    }

    /**
     * Process equation from given input
     * @param eq
     */
    private void processEquation(java.lang.String eq) {
        String equation[] = eq.split(" = ");
        if (equation.length < 2) {
            String left[] = equation[0].trim().split(" ");
            ArrayList<String> tokens = new ArrayList<>();
            for (String i : left) {
                tokens.add(i);
            }
            MerpInfixProcessor mip = new MerpInfixProcessor();
            mip.constructTree(tokens);
        } else {
            String left = equation[0].trim();
            String right[] = equation[1].trim().split(" ");
            ArrayList<String> tokens = new ArrayList<>();
            for (String i : right) {
                tokens.add(i);
            }
            MerpInfixProcessor mip = new MerpInfixProcessor();
            mip.constructTree(tokens);
        }
        //ArrayList<String> equation = new ArrayList<>(Arrays.asList(eq.split(" ")));


    }
}
