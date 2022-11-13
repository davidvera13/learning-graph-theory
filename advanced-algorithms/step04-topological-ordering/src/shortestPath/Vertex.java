package shortestPath;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    // shortest path from the source vertex to actual vertex
    private int minDistance;
    // previous node in shortest path
    private Vertex predecessor;
    private List<Edge> adjencyList;

    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.minDistance = Integer.MAX_VALUE; // infinity
        this.adjencyList = new ArrayList<>();
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    // getAdjencyList()
    public List<Edge> getNeighbors() {
        return this.adjencyList;
    }
    // setAdjencyList
    public void addNeighbor(Edge edge) {
         this.adjencyList.add(edge);
    }

    @Override
    public String toString() {
        return name + " - " + predecessor;
    }
}
