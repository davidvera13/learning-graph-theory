package shortestPath;

public class Edge {
    private double weight;
    private Vertex source;
    private Vertex target;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.source = startVertex;
        this.target = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTargetVertex() {
        return this.target;
    }

    public void setTargetVertex(Vertex target) {
        this.target = target;
    }
}
