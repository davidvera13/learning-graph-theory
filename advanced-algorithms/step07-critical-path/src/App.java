import java.util.ArrayList;
import java.util.List;

public class App {
    // longest path problem
    // We know how to find the shortest path in a G(V,E) graph from s source vertex to a d destination vertex
    // how to find the longest path ?
    // it is a NP Hard problem with no known polynomial running time algorithm to solve
    // but if the G(V,E) graph is a directed acyclic graph (DAG) then we can solve the problem in linear running time
    // scheduling algorithms rely heavily on longest paths
    //
    // it is possible to transform the longest path problem into shortest path problem ?
    // > we just have to negate the edge weights (multiply by -1) and run the shortest path algorithms
    // > because of negative weights, we have to use Bellman Ford algorithm for finding the shortest path
    // > it can solve the parallel job scheduling problem
    // > give a set of V jobs, with duration d and precedences constraints: schedule the jobs by finding a start time
    //   to each so as to achieve the minimum completion time while respecting the constraints
    // Critical Path Method (CPM)
    // > First used between 1940 and 1943 in the Manhattan project
    // > The first time CPM was used for major skyscrapper development was in 1966 while constructing the world trade center
    // > We want an algorithm for scheduling a set of project activities so that the total running time will be as minimal as possible
    // CPM needs:
    // 1. A list of all activities required to complete the project
    // 2. the duration that each activity will take to complete
    // 3. the dependencies between the activities
    // Based on those information:
    // > A weighted G(V,E) directed acyclic graph can be generated
    // > Add edges with 0 weight for each precedence constraint
    // > we then have to find the longest path in order to solve the problem
    // > No cycle is present in the graph

    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("S"));
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));

        // use Bellman Ford because Dijkstra cannot be used on negative weighted graphs
        // negate all edge weights -> and run Bellman Ford, the abs|f| will be the longest path and the path
        // can be traversed with the help of getPreviousVertex()

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(vertexList.get(0),vertexList.get(1),-1));
        edgeList.add(new Edge(vertexList.get(0),vertexList.get(3),-2));

        edgeList.add(new Edge(vertexList.get(1),vertexList.get(2),-6));

        edgeList.add(new Edge(vertexList.get(2),vertexList.get(4),-1));
        edgeList.add(new Edge(vertexList.get(2),vertexList.get(5),-2));

        edgeList.add(new Edge(vertexList.get(3),vertexList.get(1),-4));
        edgeList.add(new Edge(vertexList.get(3),vertexList.get(4),-3));

        edgeList.add(new Edge(vertexList.get(4),vertexList.get(5),-1));

        BellmanFord bellmannFordAlgorithm = new BellmanFord(vertexList,edgeList);
        bellmannFordAlgorithm.bellmanFord(vertexList.get(0),vertexList.get(5));
    }
}