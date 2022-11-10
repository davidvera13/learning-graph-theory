public class Main {
    public static int[][] adjencyMatrix = {
            {0, 2, 4, 0},
            {0, 0, 0, 3},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    public static void main(String[] args) {
        // fin all edges
        for (int i = 0; i < adjencyMatrix.length; i++) {
            for (int j = 0; j < adjencyMatrix.length; j++) {
                if(adjencyMatrix[i][j] != 0) {
                    System.out.println("Edge with weight " + adjencyMatrix[i][j]);
                }
            }
        }

        // if we know the vertices, the lookup is O(1)
        System.out.println("is there connection between vertex A and C ?");
        System.out.println(adjencyMatrix[0][2]);

        // adjency list representation
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(d);

        // show neighbor
        System.out.println("Show neighbors");
        a.showNeighbor();
        b.showNeighbor();
        c.showNeighbor();
        d.showNeighbor();
    }
}