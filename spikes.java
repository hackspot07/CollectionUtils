import java.util.*;
import java.io.*;

public class spikes {
    private static HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
    private static ArrayList<String> visitedVertices = new ArrayList<String>();
    private static ArrayList<String> paths = new ArrayList<String>();
    public static void main(String[] args){
        graph.put("Bangalore", new ArrayList<String>(Arrays.asList("Singapore")));
        graph.put("Singapore", new ArrayList<String>(Arrays.asList("Seoul")));
        graph.put("Singapore", new ArrayList<String>(Arrays.asList("Dubai")));
        graph.put("Dubai", new ArrayList<String>(Arrays.asList("Lucknow")));
        graph.put("Seoul", new ArrayList<String>(Arrays.asList("Beijing")));
        graph.put("Beijing", new ArrayList<String>(Arrays.asList("Tokyo")));
        graph.put("India", new ArrayList<String>(Arrays.asList("Pak")));
        checkAndClear("Tokyo","Beijing");
    }
    public static boolean isConnected(String source, String destination) {
        visitedVertices.add(source);
        if (graph.get(source).contains(destination)) {
            paths.add(destination);
            System.out.println(paths);
            return true;
        }
        else if(source == destination){
            return true;
        }
        ArrayList<String> a = graph.get(source);
        for (String vis:a) {
            if(!visitedVertices.contains(vis)) {
                paths.add(vis);
                if (isConnected(vis, destination)) return true;
            }   
        }
        return false;
    }
    public static boolean checkAndClear(String source, String destination){
        boolean result = isConnected(source,destination);
        visitedVertices.clear();
        return result;
    }
}