package shortestPath;

public class App {
    // in graph theory, the shortest path problem is the problem of finding a path between two vertices in a graph
    // such that the sum of the weights of its constituent edges is minimized
    // > it was constructed by computer scientist Edsger Dijsktra in 1956
    // > shortestPath.Dijkstra's method can handle positive edge weight (Bellman Ford can have negative weights as well)
    // > It can find the shortest path in a G(V,E) graph from v to u but is able to construct a shortest path tree too
    // > The shortest path tree defines the shortest paths from a source to all other nodes
    // > it is asymptotically the fastest known single-source shortest path algorithm for arbitrary directed graphs with
    //   unbounded non negative weights
    //
    // shortestPath.Dijkstra's algorithm has a O(VlogV + E) running time complexity
    // it is a greedy approach - it tries to find the global optimum with the help of local optimum
    // on every iteration, we want to find the minimum distance to the next vertex possible
    // the appropriate data structure is a priority queue (heap)
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbor(new Edge(5, a, b));
        a.addNeighbor(new Edge(9, a, e));
        a.addNeighbor(new Edge(8, a, h));

        b.addNeighbor(new Edge(12, b, c));
        b.addNeighbor(new Edge(15, b, d));
        b.addNeighbor(new Edge(4, b, h));

        c.addNeighbor(new Edge(3, c, d));
        c.addNeighbor(new Edge(11, c, g));

        d.addNeighbor(new Edge(9, d, g));

        e.addNeighbor(new Edge(4, e, f));
        e.addNeighbor(new Edge(20, e, g));
        e.addNeighbor(new Edge(5, e, h));

        f.addNeighbor(new Edge(1, f, c));
        f.addNeighbor(new Edge(13, f, h));

        h.addNeighbor(new Edge(7, h, c));
        h.addNeighbor(new Edge(6, h, f));

        Dijkstra algorithm = new Dijkstra();
        algorithm.computePath(a);
        System.out.println(algorithm.getShortestPathTo(g));

        System.out.println("***************************");
        algorithm.computePath(a);
        System.out.println(algorithm.getShortestPathTo(d));
    }
}