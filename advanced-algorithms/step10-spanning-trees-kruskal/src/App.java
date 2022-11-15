import java.util.ArrayList;
import java.util.List;

public class App {
    // Disjoint sets
    // > Also known as union find data structure
    // > it is a data structure to keep track if a set of elements partitioned into a number of disjoints (non
    //   overlapping) subsets
    // > 3 main operations are union, find and make sets
    // > disjoint sets can be represented with the help of linkedlists but usually we implement it as a tree like
    //   structure
    // > In Kruskal algorithm, it will be useful - with disjoint sets we can decide in O(1) tiee wheter two vertices
    //   are in the same set or not
    // > We can find cycles in a graph with this data structure in O(logN)
    // ---------------------------------------------
    // 1. Making sets: at the beginning, each item is in a distinct set  and sets are represented by the given item
    // 2. Find: Several items (nodes) may belong to the same set during algorithm. We usually represent the set with
    //    one of its items the so call representative. Representative is found recursively
    // 3. Union / merge: the union operation is the merging of 2 disjoint sets by connecting them according to
    //    the representatives. Issue: this tree like structure can become imbalanced
    // ---------------------------------------------
    // Union can be:
    // > Union by rank: always attach the smaller tree to the root of the larger one. THe tree will become more balanced
    //   and of course balanced trees are faster
    // > path compression: we may flatten the structure of the tree. We set every visisted node to be connected to the
    //   root directly and this is how we can achieve even O(1) running time
    // ---------------------------------------------
    // rank parameter: we can represent the sets with the help of tree structures. Every node in the tree can have a
    // so-called rank parameter (the height basically).
    // > the rank of the set is equal to the rank of the representative
    // > we attach the smaller tree to the larger one during the merge operation. It means we attach the tree with
    //   smaller rank to the tree with higher rank
    // ---------------------------------------------
    // Disjoint sets applications
    // disjoint set data structure is used in Kruskal Algorithm implementation
    // we have to check whether adding a given edge to the minimum spanning tree would form a cycle or not
    // union find data structure is extremely helpful because of the union and find functions
    // we can check whether a cycle is present in a G(V,E) graph in O(1) constant running time complexity
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));
        vertexList.add(new Vertex("F"));
        vertexList.add(new Vertex("G"));
        vertexList.add(new Vertex("H"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 3));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 2));
        edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), 5));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), 13));
        edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), 5));
        edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 4));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 6));
        edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), 3));
        edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), 6));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), 2));
        edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), 3));
        edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), 6));

        Kruskal algorithm = new Kruskal();
        algorithm.run(vertexList,  edgeList);
    }
}