/**
 * file: Route.java
 * language: java
 * author: Adam Wolf
 */

package stu;

public class Route {

    private int id;
    private String starting;
    private String ending;
    private int distance;


    /**
     * Take in each of the private states declared and set them
     *
     * @param id       - Route ID
     * @param starting - Starting location
     * @param ending   - Ending location
     * @param distance - Distance of route
     */
    public Route(int id, String starting, String ending, int distance) {
        this.id = id;
        this.starting = starting;
        this.ending = ending;
        this.distance = distance;
    }

    /**
     * Get int id
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get String starting
     *
     * @return starting
     */
    public String getStart() {
        return this.starting;
    }

    /**
     * Get String ending
     *
     * @return ending
     */
    public String getEnd() {
        return this.ending;
    }

    /**
     * Get int distance
     *
     * @return distance
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * Print out the class
     *
     * @return class as a string
     */
    public String toString() {
        return this.id + ": " + this.starting + " to " + this.ending + ", " + this.distance + " distance";
    }
}
