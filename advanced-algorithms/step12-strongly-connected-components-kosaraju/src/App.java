import java.util.ArrayList;
import java.util.List;

public class App {
    // Strongly Connected Components
    // a G(V,E) is strongly connected if all its vertices are connected
    // a graph is strongly connected if we can get from any vertex to other vertex
    // undirected graphs are strongly connected by definition
    // in directed graph, there may be some vertices that can't be reached from everywhere
    // there clusters can be discovered with DFS
    // we can find strongly connected components of a graph in O(V) time
    // if we shrink component to a vertex, these vertices form a DAG
    // this is the condensation of the given graph
    // so a directed graph is a DAG only if there is no subgraph that is strongly connected

    // Kosaraju algorithm does 2 DFS : one to get the topological ordering and the one the G'(V,E) transposed graph to
    // discover the strongly connected component
    // transpose of og a G(V,E) is when we reverse each edges so change the start and end vertices accordingly
    // > we have to use a stack for Depth first Traversal because we have to track the finishing times
    // > this is a standard topological ordering
    // > we need to track whether we have already visited a given node or not


    // Tarjan algorithm uses only 1 DFS so it is much more popular in practise. A bit more complicated to understand and
    // to implement
    // both of the approaches have O(V+E) linear running time complexity
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex(0, "A"));
        vertexList.add(new Vertex(1, "B"));
        vertexList.add(new Vertex(2, "C"));
        vertexList.add(new Vertex(3, "D"));
        vertexList.add(new Vertex(4, "E"));
        vertexList.add(new Vertex(5, "F"));
        vertexList.add(new Vertex(6, "G"));
        vertexList.add(new Vertex(7, "H"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));

        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(4)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(3)));
        edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(6)));

        edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(3), vertexList.get(7)));

        edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(0)));
        edgeList.add(new Edge(1, vertexList.get(4), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(5), vertexList.get(6)));

        edgeList.add(new Edge(1, vertexList.get(6), vertexList.get(5)));

        edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(3)));
        edgeList.add(new Edge(1, vertexList.get(7), vertexList.get(6)));

        Graph graph = new Graph(vertexList, edgeList);
        KosarajuAlgorithm algorithm = new KosarajuAlgorithm(graph);
        System.out.println(algorithm.getCount());

        for(Vertex vertex : vertexList)
            System.out.println(vertex + " - " + vertex.getComponentId());
    }

}