import java.util.ArrayList;
import java.util.List;

public class App {
    // cycle detection
    // the aim is to find cycles in a directed G(V,E) graph
    // sometimes we want to find cycles when we try to detect arbitrage opportunities on the FOREX
    // arbitrage trading involves the buying and selling of currency pairs to exploit any pricing inefficiencies
    // Usually, we represent a set of dependencies with directed graphs
    // usually, cycles mean deadlock
    // deadlock is a common case in multithreaded environment
    // each thread try to acquire a lock to a resource that is already locked by another thread

    // operatign systems and cycles
    // it's absolutelly crucial in operating systems to avoid cycles or cyclic dependencies in the main
    // the underlying operating system creates a new process for every single active program that can be managed independently
    // It's crucial to avoid cycles and deadlocks
    // this is why, the resource allocation graph (RAG) is constructed
    // we have to make sure we can not find a any cycles in this G(V,E) allocation graph
    public static void main(String[] args) {

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        // we have to handle the connections
        f.addNeighbor(a);
        a.addNeighbor(e);
        a.addNeighbor(c);

        c.addNeighbor(b);
        c.addNeighbor(d);

        // we have a cycle here...
        // e.addNeighbor(f);

        List<Vertex> graph = new ArrayList<>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);

        CycleDetection algorithm = new CycleDetection();
        algorithm.detectCycles(graph);
    }
}