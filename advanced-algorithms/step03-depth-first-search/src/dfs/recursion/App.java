package dfs.recursion;

import dfs.shared.Vertex;

import java.util.ArrayList;
import java.util.List;

public class App {
    // Depth first search
    // > Depth first search is a widely used graph traversal algorithm
    //   besides breadth first search.
    // > It was investigated as strategy for solving mazes by Trémeaux in 19th century
    // > The algorithm explores as far as possible along each branch before backtracking (on the other hand BFS
    //   is a layer by layer algorithm).
    // > time complexity of traversing a graph with DFS: O(V+E)
    // > memory complexity: a bit better than that of BFS
    //
    // DFS can be used for:
    // > Topological ordering
    // > Kosaraju algorithm for finding strongly connected components in a graph
    //   which can prove to be very important for recommendation systems
    // > Detecting cycles (checking wheter a graph is a DAG or not)
    // > generating mazes or finding way out of a maze
    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Vertex v8 = new Vertex("H");

        List<Vertex> vertices = new ArrayList<>();
        v1.addNeighbor(v2);
        v1.addNeighbor(v6);
        v1.addNeighbor(v7);
        v2.addNeighbor(v3);
        v2.addNeighbor(v4);
        v4.addNeighbor(v5);
        v7.addNeighbor(v8);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);
        vertices.add(v8);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(vertices);
    }
}