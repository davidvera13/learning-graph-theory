import java.util.ArrayList;
import java.util.List;

public class App {
    // Tarjan's algorithm is able to find the strongly connected component in a Directed G(V,E) graph, with a single DFS
    // > the algorithm was first constructed by Robert Tarjan back in 1972
    // > it has a linear O(V+E) running time complexity
    // > every node of the g(V,E) graph has 2 properties: an index and a lowlink parameter
    // > We assign an integer index to the nodes consecutively in the order they are visited by DFS
    // > every node has another lowlink integer value that is the smallest index of any node known to be reachable from
    //   node v
    //    > v.lowlink = v.index ? there is no backward edge to another node, so the current node is the root node of a
    //      strongly connected component
    //    > v.lowlink < v.index ? in this case, we know that there is a backward edge
    // The problem is that low link values are depending on the order of the DFS
    // This is why the stack invariant principle is crucial in Tarjan's algorithm
    // the principle make sure the lowlink values are going to be consistent
    // We will use a stack in which we store the nodes for which to update the lowlink values - the nodes must be on the
    // stack to be able to update the lowlink value
    //
    // when DFS recursively visits a node v and its descendants,
    // > those nodes are not necessarily popped from the stack when the recursive call returns
    // > a node remains on the stack after it has been visited if there exists a path in the graph from this node to
    //   some node earlier on the stack
    // > so at the end of the recursive call that visits vertex v, we know whether vertex v itself has a path to any
    //   node earlier (ancestors) on the stack
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");
        Vertex vertex7 = new Vertex("7");
        Vertex vertex8 = new Vertex("8");

        vertex1.addNeighbor(vertex2);

        vertex2.addNeighbor(vertex3);
        vertex2.addNeighbor(vertex5);
        vertex2.addNeighbor(vertex6);

        vertex3.addNeighbor(vertex4);
        vertex3.addNeighbor(vertex7);

        vertex4.addNeighbor(vertex8);
        vertex4.addNeighbor(vertex3);

        vertex5.addNeighbor(vertex1);
        vertex5.addNeighbor(vertex6);

        vertex6.addNeighbor(vertex7);
        vertex7.addNeighbor(vertex6);
        vertex8.addNeighbor(vertex4);
        vertex8.addNeighbor(vertex7);

        List<Vertex> graph = new ArrayList<>();
        graph.add(vertex6);
        graph.add(vertex7);
        graph.add(vertex5);
        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);
        graph.add(vertex8);

        TarjanAlgorithm algorithm = new TarjanAlgorithm(graph);
        algorithm.run();
        algorithm.print();


    }
}