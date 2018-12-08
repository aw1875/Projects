/**
 * file: TravelAgency.java
 * language: java
 * author: Adam Wolf
 */

package stu;

import backtracking.*;
import dfs_bfs.*;
import dfs_bfs.LinkedGraph;
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
        // Create graph and routes ArrayList
        dfs_bfs.Graph graph = new LinkedGraph();
        ArrayList<Route> routes = new ArrayList<>();

        // Populate ArrayList
        for (Transportation value : m.values()) {
            if (!routes.contains(value.getRoute())) {
                routes.add(value.getRoute());
            }
        }

        // Populate graph
        for (Route route : routes) {
            if (graph.hasNode(route.getStart()) && graph.hasNode(route.getEnd())) {
                graph.addNeighbor(graph.getNode(route.getStart()), graph.getNode(route.getEnd()));
            } else if (graph.hasNode(route.getStart()) && !graph.hasNode(route.getEnd())) {
                dfs_bfs.Node endNode = graph.makeNode(route.getEnd());
                graph.addNeighbor(endNode, graph.getNode(route.getStart()));
            } else if (graph.hasNode(route.getEnd()) && !graph.hasNode(route.getStart())) {
                dfs_bfs.Node startNode = graph.makeNode(route.getStart());
                graph.addNeighbor(startNode, graph.getNode(route.getEnd()));
            } else {
                dfs_bfs.Node startNode = graph.makeNode(route.getStart());
                dfs_bfs.Node endNode = graph.makeNode(route.getEnd());
                graph.addNeighbor(graph.getNode(route.getStart()), graph.getNode(route.getEnd()));
            }
        }
        return GraphSearching.canReachDFS(graph, start, end);
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
        int counter = -1;

        // Create graph and routes ArrayList
        Graph graph = new LinkedGraph();
        ArrayList<Route> routes = new ArrayList<>();

        // Populate ArrayList
        for (Transportation value : m.values()) {
            if (!routes.contains(value.getRoute())) {
                routes.add(value.getRoute());
            }
        }

        // Populate graph
        for (Route route : routes) {
            if (graph.hasNode(route.getStart()) && graph.hasNode(route.getEnd())) {
                graph.addNeighbor(graph.getNode(route.getStart()), graph.getNode(route.getEnd()));
            } else if (graph.hasNode(route.getStart()) && !graph.hasNode(route.getEnd())) {
                dfs_bfs.Node endNode = graph.makeNode(route.getEnd());
                graph.addNeighbor(endNode, graph.getNode(route.getStart()));
            } else if (graph.hasNode(route.getEnd()) && !graph.hasNode(route.getStart())) {
                dfs_bfs.Node startNode = graph.makeNode(route.getStart());
                graph.addNeighbor(startNode, graph.getNode(route.getEnd()));
            } else {
                dfs_bfs.Node startNode = graph.makeNode(route.getStart());
                dfs_bfs.Node endNode = graph.makeNode(route.getEnd());
                graph.addNeighbor(graph.getNode(route.getStart()), graph.getNode(route.getEnd()));
            }
        }

        // Iterate through BFS results and add to counter
        Iterable<dfs_bfs.Node> iterable = GraphSearching.buildPathBFS(graph, start, end);
        if (iterable == null) {
            return -1;
        } else {
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                counter++;
                iterator.next();
            }
        }
        return counter;
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
        Map<String, Node> graph = new HashMap<>();

        // Create graph
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!graph.containsKey(value.getRoute().getStart())) {
                currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
                graph.put(value.getRoute().getStart(), currNode);
            } else {
                graph.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
            }
        }
        dijkstras.Graph dg = new dijkstras.Graph(graph);

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
        // Create list of results
        List<Transportation> result = new LinkedList<>();
        Map<String, Node> graph = new HashMap<>();

        // Create graph
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!graph.containsKey(value.getRoute().getStart())) {
                currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getCost());
                graph.put(value.getRoute().getStart(), currNode);
            } else {
                graph.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getCost());
            }
        }
        return result;
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
        // Create list of results
        List<Transportation> result = new LinkedList<>();
        Map<String, Node> graph = new HashMap<>();

        // Create graph
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!graph.containsKey(value.getRoute().getStart())) {
                currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getTime());
                graph.put(value.getRoute().getStart(), currNode);
            } else {
                graph.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getTime());
            }
        }
        return result;
    }
}
