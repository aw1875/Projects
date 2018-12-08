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

import java.lang.reflect.Array;
import java.util.*;

public class TravelAgency extends dijkstras.Graph {
    private Map<Integer, Transportation> m;
    private String start;
    private String end;
    private int maxCost;


    /**
     * Constructor.
     * *
     *
     * @param graph the graph to search
     */
    public TravelAgency(Map<String, Node> graph) {
        super(graph);
    }

    @Override
    protected void dijkstra(Node startNode, Map<Node, Integer> distance, Map<Node, Node> predecessors) {
        super.dijkstra(startNode, distance, predecessors);
    }

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
        // I'm having problems with this one, so it doesn't seem to work.
        MakeHome home = new MakeHome(m, start, end, maxCost);
        Backtracker b1 = new Backtracker(false);
        Optional<Configuration> solution = b1.solve(home);
        return solution;
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
        Map<String, Node> map = new HashMap<>();

        // Create map
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!map.containsKey(value.getRoute().getStart())) {
                if (!map.containsKey(value.getRoute().getEnd())) {
                    currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getStart(), currNode);
                    map.put(value.getRoute().getEnd(), new Node(value.getRoute().getEnd()));
                } else {
                    currNode.addNeighbor(map.get(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getEnd(), map.get(value.getRoute().getEnd()));
                }
            } else {
                map.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
            }
        }

        // Create data for calling dijkstra later
        Node firstNode = map.get(start);
        Node lastNode = map.get(end);
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();
        List<Node> route = new LinkedList<>();

        // Using extension of Dijkstra's Graph to call dijkstra function
        TravelAgency graph = new TravelAgency(map);
        graph.dijkstra(firstNode, distance, predecessors);

        // Add to routes from lastNode until firstNode
        if (distance.get(lastNode) != null) {
            Node currNode = lastNode;
            while (!currNode.equals(firstNode)) {
                route.add(0, currNode);
                currNode = predecessors.get(currNode);
            }
            route.add(0, firstNode);
        } else {
            return result;
        }

        // Compare route list to Transportation values in map m and add to result if it is a path
        for (int i = 0; i < route.size() - 1; i++) {
            for (Transportation value : m.values()) {
                if (route.get(i).getName().equals(value.getRoute().getStart()) && route.get(i + 1).getName().equals(value.getRoute().getEnd())) {
                    result.add(m.get(value.getId()));
                    break;
                }
            }
        }
        return result;
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
        Map<String, Node> map = new HashMap<>();

        // Create map
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!map.containsKey(value.getRoute().getStart())) {
                if (!map.containsKey(value.getRoute().getEnd())) {
                    currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getStart(), currNode);
                    map.put(value.getRoute().getEnd(), new Node(value.getRoute().getEnd()));
                } else {
                    currNode.addNeighbor(map.get(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getEnd(), map.get(value.getRoute().getEnd()));
                }
            } else {
                map.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
            }
        }

        // Create data for calling dijkstra later
        Node firstNode = map.get(start);
        Node lastNode = map.get(end);
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();
        List<Node> route = new LinkedList<>();

        // Using extension of Dijkstra's Graph to call dijkstra function
        TravelAgency graph = new TravelAgency(map);
        graph.dijkstra(firstNode, distance, predecessors);

        // Add to routes from lastNode until firstNode
        if (distance.get(lastNode) != null) {
            Node currNode = lastNode;
            while (!currNode.equals(firstNode)) {
                route.add(0, currNode);
                currNode = predecessors.get(currNode);
            }
            route.add(0, firstNode);
        } else {
            return result;
        }

        // Compare route list to Transportation values in map m and add to result if it is a path
        for (int i = 0; i < route.size() - 1; i++) {

            // Will be changed to first option after first iteration (mostly just a placeholder)
            int maxCost = Integer.MAX_VALUE;

            // Create Transportation id variable to add to result after determining if it is the cheapest
            int id = 0;

            // Iterate through m values now
            for (Transportation value : m.values()) {
                if (route.get(i).getName().equals(value.getRoute().getStart()) && route.get(i + 1).getName().equals(value.getRoute().getEnd())) {
                    if (maxCost > value.getCost()) {
                        maxCost = value.getCost();
                        id = value.getId();
                    }

                }
            }
            result.add(m.get(id));
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
        Map<String, Node> map = new HashMap<>();

        // Create map
        for (Transportation value : m.values()) {
            Node currNode = new Node(value.getRoute().getStart());
            if (!map.containsKey(value.getRoute().getStart())) {
                if (!map.containsKey(value.getRoute().getEnd())) {
                    currNode.addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getStart(), currNode);
                    map.put(value.getRoute().getEnd(), new Node(value.getRoute().getEnd()));
                } else {
                    currNode.addNeighbor(map.get(value.getRoute().getEnd()), value.getRoute().getDistance());
                    map.put(value.getRoute().getEnd(), map.get(value.getRoute().getEnd()));
                }
            } else {
                map.get(value.getRoute().getStart()).addNeighbor(new Node(value.getRoute().getEnd()), value.getRoute().getDistance());
            }
        }

        // Create data for calling dijkstra later
        Node firstNode = map.get(start);
        Node lastNode = map.get(end);
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();
        List<Node> route = new LinkedList<>();

        // Add to routes from lastNode until firstNode
        if (distance.get(lastNode) != null) {
            Node currNode = lastNode;
            while (!currNode.equals(firstNode)) {
                route.add(0, currNode);
                currNode = predecessors.get(currNode);
            }
            route.add(0, firstNode);
        } else {
            return result;
        }

        // Compare route list to Transportation values in map m and add to result if it is a path
        for (int i = 0; i < route.size() - 1; i++) {

            // Will be changed to first option after first iteration (mostly just a placeholder)
            int maxTime = Integer.MAX_VALUE;

            // Create Transportation id variable to add to result after determining if it is the cheapest
            int id = 0;

            // Iterate through m values now
            for (Transportation value : m.values()) {
                if (route.get(i).getName().equals(value.getRoute().getStart()) && route.get(i + 1).getName().equals(value.getRoute().getEnd())) {
                    if (maxTime > value.getTime()) {
                        maxTime = value.getTime();
                        id = value.getId();
                    }

                }
            }
            result.add(m.get(id));
        }

        return result;
    }
}