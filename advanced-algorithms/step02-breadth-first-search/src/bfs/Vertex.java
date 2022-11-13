package bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjencyList = new ArrayList<>();
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjencyList() {
        return adjencyList;
    }

    public void addNeighbor(Vertex vertex) {
        this.adjencyList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
