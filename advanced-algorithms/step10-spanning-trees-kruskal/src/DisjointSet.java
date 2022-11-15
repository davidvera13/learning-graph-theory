import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    public DisjointSet(List<Vertex> vertexList) {
        makeSets(vertexList);
    }

    // find the representative (root node) for node 'node'
    public Node find(Node node) {
        Node currentNode = node;
        while (currentNode.getParentNode() != null) {
            currentNode = currentNode.getParentNode();
        }
        // path compression to make sure that next time we look for the representative of the node we have 0(1)
        Node root = currentNode;
        currentNode = node;

        while (currentNode != root) {
            Node tmp = currentNode.getParentNode();
            currentNode.setParentNode(root);
            currentNode = tmp;
        }
        return root;
    }
    // combining two sets
    public void union(Node node1, Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);
        if(root1 == root2)
            return;

        // attach the smaller tree to the root of the larger tree 'union by height'
        if(root1.getHeight() < root2.getHeight()) {
            root1.setParentNode(root2);
        } else if (root1.getHeight() > root2.getHeight()){
            root2.setParentNode(root1);
        } else {
            root2.setParentNode(root1);
            // if equals, we increase the height of parent node
            root1.setHeight(root1.getHeight() + 1);
        }
    }

    private void makeSets(List<Vertex> vertexList) {
        vertexList.forEach(vertex -> makeSet(vertex));
    }

    private void makeSet(Vertex vertex) {
        // initialy nodes are not connected
        Node node = new Node(0, null);
        vertex.setNode(node);
    }
}
