import java.util.ArrayList;
import java.util.List;

public class App {
    // the maximum flow problem was first formulated in 1954 as a simplified model of the Soviet Railway Traffic flow
    // Lester R. Ford and Delbert R. Fulkerson created the first known algorithm that can solve this problem in 1955
    // "Consider a rail network connecting two cities by way of a number of intermediate cities, where each link of the
    // network has a number assigned to it representing its capacity. Assuming a steady state condition, find a maximal
    // flow from one given city to the other"

    // max flow min cut theorem
    // > the value of any flow is bounded by the capacity of any cut
    // > so the maximum flow and the minimum cut has something to do with each other (not independant)
    // > max flow min cut theorem: the value of the maximum flow passing from source s to sink t is equal to the capacity
    //   of the minimum cut
    // > another important fact: the minimum cut is the smallest total weight of the edges which if removed would
    //   disconnect the source from the sink

    // Ford Fulkerson approach
    // Using augmenting path: an augmenting path exists in the residual graph G'(V,E) network which is a simple path from
    // source s to sink t in G'(V,E) residual network
    // > if there is an augmenting path, we know that the flow is not maximal
    // > if there is no augmenting path, it means we can terminate the algorithm with the max flow

    // Edmond karp
    // we know from Ford Fulkerson that we have to find the augmenting paths in residual network
    // there aree several graph traversal algorithms to traverse a graph
    // Edmond Karp uses BFS to find augmenting paths
    // Running time of Edmonds Karp algorithm is O(VE²=
    // Running time of Dinic algorithm is O(V²E)
    public static void main(String[] args) {
        FlowNetwork flowNetwork = new FlowNetwork(4);

        Vertex vertex0 = new Vertex(0, "source");
        Vertex vertex1 = new Vertex(1, "A");
        Vertex vertex2 = new Vertex(2, "B");
        Vertex vertex3 = new Vertex(3, "sink");

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);

        flowNetwork.addEdge(new Edge(vertex0, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex0, vertex2, 5));

        flowNetwork.addEdge(new Edge(vertex1, vertex3, 7));

        flowNetwork.addEdge(new Edge(vertex2, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex2, vertex3, 1));

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, vertex0, vertex3);

        System.out.println("Maximum flow is: " + fordFulkerson.getMaxFlow());

        // print min-cut
        System.out.println("Vertices in the min cut set: ");
        for (int v = 0; v < vertexList.size(); v++) {
            if (fordFulkerson.isInCut(v))
                System.out.print(vertexList.get(v)+" - ");
        }
    }
}