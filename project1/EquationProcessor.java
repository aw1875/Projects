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
            processEquation(input);
        }
    }

    /**
     * Process equation from given input
     *
     * @param eq
     */
    private void processEquation(java.lang.String eq) {
        if (eq.contains("if")) {
            eq = eq.substring(4, eq.length() - 1);
            ArrayList<String> equation = new ArrayList<String>(Arrays.asList(eq.split(",")));
            ArrayList<String> cond = new ArrayList<String>(Arrays.asList(equation.get(0).split(" ")));
            String statement1 = equation.get(1).trim();
            String statement2 = equation.get(2).trim();
            this.processor.constructTree(cond);
            int result = processor.evaluateTree(symbolTable);
            if (result == 1) {
                processEquation(statement1);
            } else {
                processEquation(statement2);
            }
        } else if (eq.contains("while")) {
            eq = eq.substring(7, eq.length() - 1);
            ArrayList<String> equation = new ArrayList<String>(Arrays.asList(eq.split(",")));
            ArrayList<String> cond = new ArrayList<String>(Arrays.asList(equation.get(0).split(" ")));
            ArrayList<String> statements = new ArrayList<String>(Arrays.asList(equation.get(1).split(";")));
            String statement1 = statements.get(0).trim();
            String statement2 = statements.get(1).trim();
            this.processor.constructTree(cond);
            int condition = processor.evaluateTree(symbolTable);
            while (condition != 0) {
                processEquation(statement1);
                processEquation(statement2);
                condition = processor.evaluateTree(symbolTable);
            }
            processEquation(statement1);
        } else {
            if (eq.contains("=")) {
                ArrayList<String> equation = new ArrayList<String>(Arrays.asList(eq.split("=")));
                if (equation.size() > 1) {
                    String left = equation.get(0).trim();
                    ArrayList<String> test = new ArrayList<String>(Arrays.asList(equation.get(1).trim().split(" ")));
                    this.processor.constructTree(test);
                    int right = processor.evaluateTree(symbolTable);
                    symbolTable.put(left, right);
                }
            } else {
                eq = eq.replaceAll("[()]", " ");
                ArrayList<String> equation = new ArrayList<String>(Arrays.asList(eq.split(" ")));
                switch (equation.get(0)) {
                    case "print":
                        System.out.println(symbolTable.get(equation.get(1)));
                        break;
                    case "printVariables":
                        symbolTable.dump();
                        break;
                }
            }
        }
    }
}
