package topologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    // topological ordering;
    // the DSF search based algorithm was first constructed by Tarjan back in 1976
    // topological ordering (topologival sort) of a G(V,E) directed graph is a linear ordering
    // of its vertices such that for every directed (u, v) edge u comes before v in the ordering.
    // the V vertices of the G(V,E) graph may represent tasks to be performed and the edges are the constraints (one task
    // may be performed before another)
    // topological ordering (sorting) yield the valid sequence for the tasks

    // we can use topological ordering if only the G(V,E) graph does not have any cycles
    // So it is a directed acyclic graph (DAG)
    // any directed acyclic graph has at least one topological order

    // topological orderering (topological sort) has O(V+E) linear running time complexity
    // > it is crucial in project management and in finding hamiltonian paths and cycles
    // > Hamiltonian path in a G(V, E) graph visits every vertex exactly once
    // > If a Hamiltonian path exists, then the topological sort order is unique
    // > If a topological sort does not form a Hamiltonian path it means that the DAG has mort valid topological
    //   orderings
    // > It is NP Complete problem to find the Hamiltonian path but we can decide wether such path exists in O(V+E)
    //   running time with topological sort

    // applications:
    // crucial in project management softwares to decide the order in which tasks should be executed
    // when we have a large application with several dependencies: Ant, Maven, Gradle (dependencies management)

    public static void main(String[] args) {
        TopologicalOrdering ordering = new TopologicalOrdering();
        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbor(graph.get(3));

        graph.get(3).addNeighbor(graph.get(1));

        graph.get(4).addNeighbor(graph.get(0));
        graph.get(4).addNeighbor(graph.get(1));

        graph.get(5).addNeighbor(graph.get(0));
        graph.get(5).addNeighbor(graph.get(2));

        // consider all the vertices: note we're dealing with directed graph, we start DFS with each vertex
        for (int i = 0; i < graph.size(); i++) {
            if(!graph.get(i).isVisited()) {
                ordering.dfs(graph.get(i));
            }
        }
        Stack<Vertex> stack = ordering.getStack();

        for (int i = 0; i < graph.size(); i++) {
            System.out.println(stack.pop());
        }

    }
}