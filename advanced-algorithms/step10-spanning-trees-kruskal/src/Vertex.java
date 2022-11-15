import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	// node in the disjoint set
	private Node node;
	// the distance from the source vertex (infinity)
	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return this.name;
	}	
}
