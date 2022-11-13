package dfs.recursion;

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
        // it uses LIFO structure: last in first out
        stack.add(root);
        root.setVisited(true);
        while (!stack.empty()) {
            Vertex currentVertex = stack.pop();
            System.out.println("Actual vertex:" + currentVertex);

            // consider all neighbors
            for(Vertex v: currentVertex.getNeighbors()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }
    }
}
