package shortestPath;

import java.util.ArrayList;
import java.util.List;

public class App {
    // DAG Shortest path
    // > Usually we use Dijkstra's algorithm if we want the shortest path in an arbitrary G(V, E) graph
    // > Can we do better if the G(V, E) graph is a directed acyclic graph
    // we can achieve linear running time to calculate the shortest path in a G(V, E) directed acyclic graph
    // we can find the shortest path in a directed acyclic graph (DAG) with topological ordering in
    // (O(V+E) linear running time
    // it only works when there a valid topological order exists
    public static void main(String[] args) {
        List<Vertex> graph = new ArrayList<>();

        Vertex v0 = new Vertex("S");
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        v0.addNeighbor(new Edge(v1, 1));
        v0.addNeighbor(new Edge(v3, 2));

        v1.addNeighbor(new Edge(v2, 6));

        v2.addNeighbor(new Edge(v4, 1));
        v2.addNeighbor(new Edge(v5, 2));

        v3.addNeighbor(new Edge(v1, 4));
        v3.addNeighbor(new Edge(v4, 3));

        v4.addNeighbor(new Edge(v5, 1));

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        ShortestPath algorithm = new ShortestPath(graph);
        algorithm.compute();

        for(Vertex v : graph)
            System.out.println("Distance from s: " + v.getMinDistance()
                    + " - " + v.getPredecessor());

    }
}
