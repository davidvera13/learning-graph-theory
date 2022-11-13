package bfs;

public class App {
    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        // path from A to B, A to F, A to G
        a.addNeighbor(b);
        a.addNeighbor(f);
        a.addNeighbor(g);
        // path from B to A, B to C, B to D
        b.addNeighbor(a);
        b.addNeighbor(c);
        b.addNeighbor(d);
        // path from D to B, D to E
        d.addNeighbor(b);
        d.addNeighbor(e);
        // path from F to A
        f.addNeighbor(a);
        // path from G to A, G to H
        g.addNeighbor(a);
        g.addNeighbor(h);
        // path from H to G
        h.addNeighbor(g);

        // A will be the root
        bfs.transverse(a);

    }
}
