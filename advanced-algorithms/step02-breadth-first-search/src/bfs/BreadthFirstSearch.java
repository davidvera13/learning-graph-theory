package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    // we have a graph and we want to visit every vertex / node: we can use BFS algorithm
    // the aim is to visit every vertex only once
    // so the algorithm visits the neighbours then the neighbours of these new
    // vertices until all vertices / nodes are visited
    // running time complexity is O(V+E)
    // memory complexisty is not goog: we must store a lot of references
    // that's why depth first search (DFS is preferred)
    // the advantage is that it constructs a shortest path: Dijkstra's algorithm
    // does a breadth first seach if all the edges are equal to 1

    // the data structure used is a queue
    // we have an empty queue at the beginning and we keep checking wheter we have visited the given node or not
    // The algorithm keeps iterating until queue is not empty

    // applications:
    // > In Artificial Intelligence (machine learning), it is a useful algorithm: robotas can discover the
    //   surrounding more easily with BFS than with DFS
    // >  it is also very important in maximum flow: Edmonds Karp algorithm uses BFS for finding augmenting paths
    // >  cheyen's algorithm in garbage collection: it helps to maintain active references on the heap
    // > serialization and deserialization of a tree like structures (for example when order does matter).
    //   it allows the truee to be reconstructed in an efficient manner
    public void transverse(Vertex root) {
        // queues is an interface and linkedList is the implementation: abstract data (Queue) type vs contrete data structure (LinkedList)
        Queue<Vertex> queue = new LinkedList<>();
        // we add the root vertex to queue
        queue.add(root);
        root.setVisited(true);
        // we loop until the queue is empty
        while (!queue.isEmpty()) {
            // we poll the last vertex from the queue and use it
            Vertex currentVertex = queue.remove();
            // print currentVertex using to string => name
            System.out.println("Actual visited vortex is: " + currentVertex);
            for(Vertex v: currentVertex.getAdjencyList()) {
                // if the vertex is not visited already
                if(!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}