package maze;

public class App {
    // the problem is that we have to construct an algorithm
    // that can find it's way out of an NxN maze
    // We can represent the problem with an NxN matrix
    // it is an important problem in robotics: how to navidate a robot in the most effective manner
    // other case: autonomous vacuum clearners
    // there may be serveral obstacles so we can use backtracking or we can construct
    // the search tree and use DFS

    // there may be several algorithms for the problem:
    // > If we know the maze then we can use heavy weight graph algorithm: Dijkstra & A* search
    // > if we do not know the mase: we can use backtracking (Trémaux algorithms or DFS are the same)
    public static void main(String[] args) {
        // Integer 1 represents walls
        // Integer 2 is the starting point
        // Integer 3 is the destination (so this is what we are looking for)
        // Integer 0 represents the states we can consider (so the solution contains one or more 0 states)
        int[][] map = {
                {1, 1, 1, 1, 1},
                {1, 2, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 3}
        };
        MazeSolver mazeSolver = new MazeSolver(map, 1, 0);
        mazeSolver.findWay();
    }
}
