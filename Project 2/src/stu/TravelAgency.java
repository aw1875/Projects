/**
 * file: TravelAgency.java
 * language: java
 * author: Adam Wolf
 */

package stu;

import backtracking.*;
import dijkstras.Graph;
import dijkstras.Node;

import java.util.*;

public class TravelAgency {

    /**
     * Will use DFS to determine if there is a path home.
     *
     * @param m     - an instance of the map created
     * @param start - the name of the starting location
     * @param end   - the name of the ending location
     * @return true if path exists, false otherwise
     */
    public static boolean isThereAPath(Map<Integer, Transportation> m, String start, String end) {
        return false; // FOR NOW
    }

    /**
     * Will use BFS to determine the least number of stops to get home
     *
     * @param m     - an instance of the map created
     * @param start - the name of the starting location
     * @param end   - the name of the ending location
     * @return the least number of stops to get home, or -1 if there is no path
     */
    public static int leastStops(Map<Integer, Transportation> m, String start, String end) {
        return 0; // FOR NOW
    }

    /**
     * Will use backtracking to determine if a path exists between the two locations for under the maximum cost provided
     *
     * @param m       - an instance of the map created
     * @param start   - the name of the starting location
     * @param end     - the name of the ending location
     * @param maxCost - the maximum cost of the trip
     * @return configuration inside of the Optional if successful, otherwise it will return an empty Optional
     */
    public static Optional<Configuration> canMakeItHomeCost(Map<Integer, Transportation> m, String start, String end, int maxCost) {
        return null; // FOR NOW
    }

    /**
     * Will use Dijkstra's to determine the shortest distance path between the two locations
     *
     * @param m     - an instance of the map created
     * @param start - the name of the starting location
     * @param end   - the name of the ending location
     * @return List of the Transportation's in the order they are used to get between the paths, or an empty List if no such path exits
     */
    public static List<Transportation> shortestPath(Map<Integer, Transportation> m, String start, String end) {

        // Create list of results
        List<Transportation> result = new LinkedList<>();
        Map<String, Node> temp = new HashMap<>();

        // Test
        for (int i = 0; i < m.size(); i++) {
            if (!temp.containsKey(m.get(i).getRoute().getStart())) {
                Node currNode = new Node(String.valueOf(m.get(i).getRoute().getStart()));
                temp.put(String.valueOf(m.get(i).getRoute().getStart()), currNode);
            } else {
                temp.get(String.valueOf(m.get(i).getRoute().getStart())).addNeighbor(new Node(String.valueOf(m.get(i).getRoute().getEnd())));
            }
        }

        Graph g = new Graph(temp);


        return result; // FOR NOW
    }

    /**
     * Will use Dijkstra's to determine the cheapest path between the two locations
     *
     * @param m     - an instance of the map created
     * @param start - the name of the staring location
     * @param end   - the name of the ending location
     * @return List of the Transportation's in the order they are used to get between the paths, or an empty List if no such path exists
     */
    public static List<Transportation> cheapestPath(Map<Integer, Transportation> m, String start, String end) {
        return null; // FOR NOW
    }

    /**
     * Will use Dijkstra's to determine the quickest path between the two locations
     *
     * @param m     - an instance of the map created
     * @param start - the name of the starting location
     * @param end   - the name of the ending location
     * @return List of the Transportation's in the order they are used to get between the paths, or an empty List if no such path exists
     */
    public static List<Transportation> quickestPath(Map<Integer, Transportation> m, String start, String end) {
        return null; // FOR NOW
    }
}
