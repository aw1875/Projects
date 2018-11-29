package stu;

import java.io.*;
import java.util.*;

public class TransportationReader {

    private static Map<Integer, Route> routes = new HashMap<>();
    private static Map<Integer, Transportation> map = new HashMap<>();

    public static Map readTransportations(String fName) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fName));
            String input;

            while((input = bf.readLine()) != null) {
                if (input.equals("Routes")) {
                    while (!(input = bf.readLine()).equals("Transportations")) {
                        String currLine[] = input.split(",");
                        Route newRT = new Route(Integer.valueOf(currLine[0].trim()), currLine[1].trim(), currLine[2].trim(), Integer.valueOf(currLine[3].trim()));
                        routes.put(newRT.getId(), newRT);
                    }
                }
                if (input.equals("Transportations")) {
                    while((input = bf.readLine()) != null) {
                        String currLine[] = input.split(",");
                        Transportation newTP = new Transportation(Integer.valueOf(currLine[0].trim()), currLine[1].trim(), Integer.valueOf(currLine[2].trim()), Integer.valueOf(currLine[4].trim()), routes.get(Integer.valueOf(currLine[3].trim())));
                        map.put(newTP.getId(), newTP);
                    }
                }
            }
            return map;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return map;
    }
}
