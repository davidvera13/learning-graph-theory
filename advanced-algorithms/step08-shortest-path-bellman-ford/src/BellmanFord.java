import java.util.List;

public class BellmanFord {
    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    // bellman ford algorithm
    public void run(Vertex source) {
        System.out.println("From source: " + source.getName());
        // we set the distance from the source to 0
        source.setDistance(0);
        // we must iterate vertexList.size - 1 (V-1) iterations: in worst case, the longest
        // path contains V-1 steps
        for(int i = 0; i < vertexList.size(); i++) {
            // relaxation: considering other edges
            for(Edge edge: edgeList) {
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();
                if(u.getDistance() + edge.getWeight() < v.getDistance()) {
                    // if we get shortest distance
                    v.setDistance(u.getDistance() + edge.getWeight());
                    v.setPredecessor(u);
                }
            }
        }
        // if we make an additional relaxation and there is shorter paths
        // then we know that there is a negative cycle in the network
        for(Edge edge: edgeList) {
            if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
                if(hasCycle(edge)) {
                    System.out.println("There is a negative cycle");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() <
                edge.getTargetVertex().getDistance();
    }

    public void shortestPathTo(Vertex vertex) {
        System.out.println("To destination:  " + vertex.getName());
        if(vertex.getDistance() == Double.MAX_VALUE) {
            // no shortest path
            System.out.println("There is no path from source to the given vertex");
        }
        Vertex currentVertex = vertex;
        while (currentVertex.getPredecessor() != null) {
            System.out.println(currentVertex);
            currentVertex = currentVertex.getPredecessor();
        }

    }
}
