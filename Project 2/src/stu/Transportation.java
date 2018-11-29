package stu;

public class Transportation {

    private int id;
    private String type;
    private int cost;
    private int time;
    private Route route;

    /**
     * Take in each of the private states declared and set them
     * @param id
     * @param type
     * @param cost
     * @param time
     * @param route
     */
    public Transportation(int id, String type, int cost, int time, Route route) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.time = time;
        this.route = route;
    }

    /**
     * Get int id
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get String type
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get int cost
     * @return cost
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Get int time
     * @return time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Get Route route
     * @return route
     */
    public Route getRoute() {
        return this.route;
    }

    /**
     * Print out the class
     * @return class as a string
     */
    public String toString() {
        return this.id + ": " + this.type + ", cost " + this.cost + ", route " + this.route.getId() + ", time " + this.time;
    }
}
