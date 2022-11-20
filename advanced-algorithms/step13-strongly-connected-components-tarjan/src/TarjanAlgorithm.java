import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
    private List<Vertex> graph;
    // we have to track the vertices in the same SCC
    private Stack<Vertex> stack;
    private int index;
    // SCC for Strongly Connected Component
    // it will track the integer representations of the SCCs
    private int sccCounter;

    public TarjanAlgorithm(List<Vertex> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
    }

    public void run() {
        for(Vertex vertex: graph)
            if(!vertex.isVisited())
                dfs(vertex);

    }

    private void dfs(Vertex vertex) {
        // at start, index is equal to low link
        vertex.setIndex(index);
        vertex.setLowLink(index);
        index++;

        vertex.setVisited(true);
        stack.add(vertex);
        vertex.setOnStack(true);

        // let's visit all connected vertex
        for(Vertex v: vertex.getAdjacencyList()) {
            if (!v.isVisited()) {
                dfs(v);
                // after DFS, we update the low links value
                vertex.setLowLink(Math.min(vertex.getLowLink(), v.getLowLink()));
            } else if (v.isOnStack()) {
                // we update low link
                vertex.setLowLink(Math.min(v.getIndex(), vertex.getLowLink()));
            }
        }
        // this is what we have to chck
        if(vertex.getIndex() == vertex.getLowLink()) {
            while (true) {
                Vertex pop = stack.pop();
                pop.setOnStack(false);
                pop.setComponentId(sccCounter);
                if(pop == vertex)
                    break;
            }
            sccCounter++;
        }
    }
    public void print() {
        for(Vertex vertex : graph)
            System.out.println(vertex);
    }
}
