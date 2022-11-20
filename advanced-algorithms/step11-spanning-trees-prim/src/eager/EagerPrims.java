package eager;

import java.util.List;
import java.util.PriorityQueue;

public class EagerPrims {
    private List<Vertex> vertexList;
    private PriorityQueue<Vertex> heap;

    public EagerPrims(List<Vertex> vertexList){
        this.vertexList = vertexList;
        this.heap = new PriorityQueue<>();
    }

    public void run(Vertex vertex){
        vertex.setDistance(0);
        heap.add(vertex);

        while(!heap.isEmpty()){
            Vertex v = heap.remove();
            scanVertex(v);
        }
    }

    private void scanVertex(Vertex vertex) {
        vertex.setVisited(true);
        // consider all the edges of the given vertex
        for(Edge edge : vertex.getAdjacencies()){

            Vertex v = edge.getTargetVertex();

            // we do not want to revisit already visited vertices
            if(v.isVisited()) continue;

            // there is a "shorter path" to the unvisited vertex set from the visited vertex cluster
            if(edge.getWeight() < v.getDistance()){
                v.setDistance(edge.getWeight());
                v.setMinEdge(edge);
                if( this.heap.contains(v) ){
                    this.heap.remove(v);
                }
                this.heap.add(v);
            }
        }
    }

    public void print() {
        double cost = 0;
        for(Vertex vertex : vertexList){
            if( vertex.getMinEdge() != null ){
                Edge edge = vertex.getMinEdge();
                System.out.println("Edge: " + edge);
                cost += edge.getWeight();
            }
        }

        System.out.println("Cost of MST: " + cost);
    }

}