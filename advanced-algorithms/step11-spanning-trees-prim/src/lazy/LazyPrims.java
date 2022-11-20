package lazy;

import java.util.*;

public class LazyPrims {
    // most of the operations have O(1) running time
    private final Set<Vertex> unvisited;
    private final List<Edge> mst;
    private final PriorityQueue<Edge> heap;
    private double fullCost;

    public LazyPrims(List<Vertex> vertexList) {
        this.unvisited = new HashSet<>(vertexList);
        this.mst = new ArrayList<>();
        this.heap = new PriorityQueue<>();
    }

    public void run(Vertex vertex) {
        // we take the start vertex and remove it from the unvisited
        unvisited.remove(vertex);

        // the algorithm ends when all vertices are visited
        while (!unvisited.isEmpty()) {
            // insert all the edges into the heap except the edges leading to already visited vertices
            for(Edge edge: vertex.getAdjacencyList()) {
                if(unvisited.contains(edge.getTargetVertex())) {
                    // this edge was not visited
                    heap.add(edge);
                }
            }
            // get the minimum edge from heap in O(logE)
            Edge minEdge = heap.remove();

            // get another edge if the edge is leading to an already visited edge
            if(!unvisited.contains(minEdge.getTargetVertex())) {
                // we must continue
                continue;
            }
            mst.add(minEdge);
            fullCost += minEdge.getWeight();
            // in the next iteration we consider the next vertex
            vertex = minEdge.getTargetVertex();
            unvisited.remove(vertex);
        }
    }

    public void print() {
        System.out.println("Cost of MST: " + fullCost);
        for(Edge edge: this.mst) {
            System.out.println(edge.getStartVertex() + " -> " + edge.getTargetVertex());
        }

    }

}
