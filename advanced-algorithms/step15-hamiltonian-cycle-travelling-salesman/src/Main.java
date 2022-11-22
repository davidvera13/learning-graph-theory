public class Main {
    // Hamiltonian cycles
    // a G(V,E) graph is made up to V vertices (nodes) which are connected by E edges (links)
    // in graph theory, Hamiltonian path is a path in a directed or undirected graph that visits each vertex exactly once
    // Hamiltonian cycle is an Hamiltonian path that is a cycle
    // There may be several Hamiltonian paths in a given G(E,V) graph
    // > How many permutation are there for N nodes
    // > brute force approach is O(N!) running time complexity
    // > We can eliminate and discard multiple states in one iteration if we use backtracking

    // the Hamiltonian problem is the problem of determining whether such paths and cycle exist in a G(V,E) graph or not
    // this is a so-called NP Complete problem
    // Dirac Principle: a simple G(V,E) graph with V vertices is Hamiltonian if every vertex has degree V/2 or greater
    //  * degree is the number if edges of the vertex
    // Note: findind Hamiltonian path is NP Complete but we can decide whether such path exists in linear time complexity
    // with topological ordering

    // Back tracking algorithm:
    // 1. start with a random node (with index 0 for example) - Close Hamiltonian paths are cyclic ...
    // 2. keep adding one of the neighbors of the actual node and we make sure it is not added already to the solution
    //    list
    // 3. We may backtrack if necessary

    // the travelling salesman problem:
    // "Given a list of cities and the distances between each pais of cities. What is the shortest possible route that
    // visits each city exactly once and returns to the origin city ?"
    // the solution for the travelling salesman is a Hamiltonian cycle with the lowest sum of edge weight
    public static void main(String[] args) {

        // adjacency matrix (graph)
        int[][] graph = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };


        TravellingSalesman tsp = new TravellingSalesman(graph);
        // starting vertex has index 0
        // 1 we start with the first iteration
        // cost is equals to 0
        tsp.solve(0, 1, 0);
        tsp.show();
    }
}