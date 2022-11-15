import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public void run(List<Vertex> vertexList, List<Edge> edgeList) {
        DisjointSet disjointSet = new DisjointSet(vertexList);
        // minimum spanning tree
        List<Edge> mst = new ArrayList<>();

        // use merge sort to sort the edges in ascending order
        // note: we implemented the comparable interface in order to sort based on weight
        Collections.sort(edgeList);

        for(Edge edge: edgeList) {
            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            // the edge is in the MST if the nodes are in different sets
            if(disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())) {
                mst.add(edge);
            }

            // merge the join sets
            disjointSet.union(u.getNode(), v.getNode());
        }
        // display MST
        for(Edge e: mst) {
            System.out.println(e + " -> with weight: " + e.getWeight());
        }

    }
}
