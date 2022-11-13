package topologicalOrdering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjencyList;

    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.adjencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex v) {
        this.adjencyList.add(v);
    }

    public List<Vertex> getNeighbors() {
        return this.adjencyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return name;
    }
}
