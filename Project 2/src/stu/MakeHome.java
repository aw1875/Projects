/**
 * file: MakeHome.java
 * language: java
 * author: Adam Wolf
 */

package stu;

import backtracking.Configuration;

import java.util.*;

public class MakeHome implements Configuration {
    private Map<Integer, Transportation> m;
    private String start;
    private String end;
    private int currCost;
    private int maxCost;

    /**
     * Constructor
     *
     * @param m       - an instance of the map created
     * @param start   - the name of the starting location
     * @param end     - the name of the ending location
     * @param maxCost - the maximum cost of the trip
     */
    public MakeHome(Map<Integer, Transportation> m, String start, String end, int maxCost) {
        this.m = m;
        this.start = start;
        this.end = end;
        this.currCost = 0;
        this.maxCost = maxCost;
    }

    /**
     * Copy constructor
     *
     * @param copy
     */
    public MakeHome(MakeHome copy) {
        this.m = copy.m;
        this.start = copy.start;
        this.end = copy.end;
        this.currCost = copy.currCost;
        this.maxCost = copy.maxCost;
    }

    /**
     * Get the collection of successors from the current one.
     *
     * @return All successors, valid and invalid.
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        for (Transportation value : this.m.values()) {
            if (value.getRoute().getStart().equals(this.start)) {
                MakeHome successor = new MakeHome(this);
                successors.add(successor);
                currCost += value.getCost();
            }
        }
        return successors;
    }

    /**
     * Is the current configuration valid or not?
     *
     * @return true if valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        if (this.currCost <= maxCost) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Is the current configuration a goal?
     *
     * @return true if goal; false otherwise.
     */
    @Override
    public boolean isGoal() {
        for (Transportation value : this.m.values()) {
            if (this.end.equals(value.getRoute().getEnd())) {
                return true;
            }
        }
        return false;
    }
}
