package shortestPath;

import java.util.*;

public class Dijkstra {
    public void computePath(Vertex source) {
        source.setDistance(0);
        // heap
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        // while we have elements in queue, we proceeed
        while (!queue.isEmpty()) {
            // getting and remove latest element from the queue
            Vertex currentVertex = queue.poll();
            //
            for(Edge edge: currentVertex.getAdjacencyList()) {
                Vertex u = edge.getSource();
                Vertex v = edge.getTargetVertex();

                double d = currentVertex.getDistance() + edge.getWeight();

                if(d < v.getDistance()) {
                    // we found a shortest path to vertex v
                    // bottleneck: is it working fine ? remove is optional
                    queue.remove(v);
                    v.setDistance(d);
                    v.setPredecessor(currentVertex);
                    queue.add(v);
                }
            }
        }


    }
    public List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for(Vertex vertex = target; vertex != null; vertex = vertex.getPredecessor())
            path.add(vertex);

        Collections.reverse(path);

        return path;
    }


}
