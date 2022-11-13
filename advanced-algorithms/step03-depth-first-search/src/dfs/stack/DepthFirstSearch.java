package dfs.stack;

import dfs.shared.Vertex;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertices) {
        // note: we may have independent clusters
        for(Vertex v: vertices) {
            if(!v.isVisited()) {
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }

    private void dfsHelper(Vertex root) {
        System.out.println("Actual vertex: " + root);
        for(Vertex v: root.getNeighbors()) {
            if(!v.isVisited()) {
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }
}
