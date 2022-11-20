import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {
    private int numOfVertices;
    private int numOfEdges;
    private final List<List<Edge>> adjacenciesList;

    public FlowNetwork(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        this.adjacenciesList = new ArrayList<>();

        for(int i=0;i<numOfVertices;++i) {
            List<Edge> edgeList = new ArrayList<>();
            adjacenciesList.add(edgeList);
        }
    }

    public int getNumOfVertices() {
        return this.numOfVertices;
    }

    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    public void addEdge(Edge e) {
        Vertex fromVertex = e.getFromVertex();
        Vertex targetVertex = e.getTargetVertex();
        adjacenciesList.get(fromVertex.getId()).add(e);
        adjacenciesList.get(targetVertex.getId()).add(e);
        numOfEdges++;
    }

    public List<Edge> getAdjacenciesList(Vertex v) {
        return adjacenciesList.get(v.getId());
    }

}
