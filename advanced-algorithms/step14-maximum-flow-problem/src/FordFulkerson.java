import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private boolean[] marked;       // marked[v.getId()] = true  s -> v is in the residual graph
    private Edge[] edgeTo;          // edgeTo[v] = edges in the augmenting path
    private double valueMaxFlow;

    public FordFulkerson(FlowNetwork flowNetwork, Vertex source, Vertex sink) {
        while(hasAugmentingPath(flowNetwork, source, sink) ) {
            double minValue = Double.POSITIVE_INFINITY;
            for(Vertex v= sink; v != source; v = edgeTo[v.getId()].getOther(v)) {
                minValue = Math.min(minValue, edgeTo[v.getId()].getResidualCapacity(v));
            }
            for(Vertex v = sink; v != source; v= edgeTo[v.getId()].getOther(v)){
                edgeTo[v.getId()].addResidualFlowTo(v, minValue);
            }
            valueMaxFlow = valueMaxFlow + minValue;
        }
    }
    public boolean isInCut(int index) {
        return marked[index];
    }

    public double getMaxFlow() {
        return this.valueMaxFlow;
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex source, Vertex sink) {
        edgeTo = new Edge[flowNetwork.getNumOfVertices()];
        marked = new boolean[flowNetwork.getNumOfVertices()];

        // Using BFS...
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        marked[source.getId()] = true;

        while( !queue.isEmpty() && !marked[sink.getId()]){
            Vertex v = queue.remove();
            for(Edge e : flowNetwork.getAdjacenciesList(v)) {
                Vertex w = e.getOther(v);

                if( e.getResidualCapacity(w) > 0){
                    if( !marked[w.getId()]){
                        edgeTo[w.getId()] = e;
                        marked[w.getId()] = true;
                        queue.add(w);
                    }
                }
            }

        }

        return marked[sink.getId()];
    }


}
