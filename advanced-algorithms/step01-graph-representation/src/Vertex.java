import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> adjencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex v) {
        adjencyList.add(v);
    }

    public void showNeighbor() {
        for (Vertex v: adjencyList) {
            System.out.println(v.name);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
