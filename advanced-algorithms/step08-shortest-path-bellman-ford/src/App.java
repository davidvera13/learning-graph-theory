import java.util.ArrayList;
import java.util.List;

public class App {
    // Bellman Ford
    // > First constructed in 1958 by Bellman and Ford independently
    // > Slower than Dijkstra's algorithm but it is more robust, it can handle negative edge weights
    // > Dijkstra's algorithm choose the edges greedily in every iteration with the lowest cost
    // > Bellman Ford relaxes all edges in a G(V,E) graph at the same time for V-1 iterations
    // Optimization
    // An optimization of the algorithm exists
    // > introduced by yen back in 1970
    // > we can terminate the algorithm if there is no change in the distances between 2 iterations (in the relaxation phases)
    // > same technique used in bubble sort
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);
        vertexList.add(d);
        vertexList.add(e);
        vertexList.add(f);
        vertexList.add(g);
        vertexList.add(h);

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(5, a, b));
        edgeList.add(new Edge(9, a, e));
        edgeList.add(new Edge(8, a, h));

        edgeList.add(new Edge(12, b, c));
        edgeList.add(new Edge(15, b, d));
        edgeList.add(new Edge(4, b, h));

        edgeList.add(new Edge(3, c, d));
        edgeList.add(new Edge(11, c, g));

        edgeList.add(new Edge(9, d, g));

        edgeList.add(new Edge(4, e, f));
        edgeList.add(new Edge(20, e, g));
        edgeList.add(new Edge(5, e, h));

        edgeList.add(new Edge(1, f, c));
        edgeList.add(new Edge(13, f, h));

        edgeList.add(new Edge(7, h, c));
        edgeList.add(new Edge(6, h, f));

        BellmanFord algorithm = new BellmanFord(vertexList, edgeList);
        algorithm.run(vertexList.get(0)); // A
        algorithm.shortestPathTo(vertexList.get(3)); // C
        System.out.println("**********");
        algorithm.shortestPathTo(vertexList.get(6)); // C

    }
}