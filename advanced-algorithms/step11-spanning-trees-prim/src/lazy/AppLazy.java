package lazy;

import java.util.ArrayList;
import java.util.List;

public class ÄppLazy {
    // Prim Jarnik Algorithm
    // Prim's Jarnij algorithm is able to find the minimum spanning tree in an undirected G(V,E) graph.
    // we use a priority queue (heap) in order to get the minimum edge weights in every iteration
    // we insert all the edges to the heap without modifying the content
    // this is the lazy implementation of the problem
    // Kruskal's algorithm is an edge based approach while Prim's algorithm is a lazy.Vertex based approach
    // Average running time is O(E logE) and we need O(E) memory
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);
        vertexList.add(d);
        vertexList.add(e);
        vertexList.add(f);
        vertexList.add(g);

        a.addEdge(new Edge(a, b, 1));
        a.addEdge(new Edge(a, c, 2));
        a.addEdge(new Edge(a, d, 12));

        b.addEdge(new Edge(b, a, 1));
        b.addEdge(new Edge(b, d, 4));
        b.addEdge(new Edge(b, e, 7));
        b.addEdge(new Edge(b, g, 8));

        c.addEdge(new Edge(c, a, 2));
        c.addEdge(new Edge(c, d, 6));
        c.addEdge(new Edge(c, f, 3));

        d.addEdge(new Edge(d, a, 12));
        d.addEdge(new Edge(d, b, 4));
        d.addEdge(new Edge(d, c, 6));
        d.addEdge(new Edge(d, e, 2));
        d.addEdge(new Edge(d, f, 5));

        e.addEdge(new Edge(e, b, 7));
        e.addEdge(new Edge(e, d, 2));
        e.addEdge(new Edge(e, f, 4));
        e.addEdge(new Edge(e, g, 9));

        f.addEdge(new Edge(f, c, 3));
        f.addEdge(new Edge(f, d, 5));
        f.addEdge(new Edge(f, e, 4));
        f.addEdge(new Edge(f, g, 2));

        g.addEdge(new Edge(g, b, 8));
        g.addEdge(new Edge(g, e, 9));
        g.addEdge(new Edge(g, f, 2));

        LazyPrims algorithm = new LazyPrims(vertexList);
        algorithm.run(a);
        algorithm.print();

    }
}