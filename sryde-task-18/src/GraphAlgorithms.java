import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for solving graph problems.
 *
 * @author Sara Rydell
 * @version 2023-02-23
 */

public class GraphAlgorithms {

    /**
    * Determines if a component has a cycle.
    *
    * @param g the graph to search
    * @param v the node to start at
    * @param visited boolean array keeping track of visited nodes
    * @param parent parent node of v
    * @return true if component has cycle, false otherwise
    */
    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> neighbors = g.neighbors(v);
        int currentNeighbor;
        boolean cycleFound = false;
        while (neighbors.hasNext()) {
            currentNeighbor = neighbors.next();
            if (visited[currentNeighbor] && parent!=currentNeighbor) {
                cycleFound = true;
            }
            if (!visited[currentNeighbor]) {
                cycleFound = DFS(g, currentNeighbor, visited, v);
            }
        }
        visited[v] = false;
        return cycleFound;
    }

    /**
    * Determine if there is a cycle in the graph. Implement using DFS.
    *
    * @param g the graph to search
    * @return true if there exists at least one cycle in the graph, false otherwise
    */
    public static boolean hasCycle(Graph g) {
        int n = g.numVertices();
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if(DFS(g, i, visited, i) && !visited[i]) {
                return true;
            }
        }
        return false;
    }

    /**
    * Determine if there is a path between two vertices. Implement using
    * BFS.
    *
    * @param v vertex
    * @param w vertex
    * @param g the graph to search
    * @return true if there is a path between v and w, false otherwise
    */
    public static boolean hasPath(Graph g, int v, int w) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[g.numVertices()];

        visited[v] = true;
        queue.add(v);

        int parent, currentNeighbor;
        Iterator<Integer> neighbors;
        while (!queue.isEmpty()) {
            neighbors = g.neighbors(queue.element());
            parent = queue.remove();
            while (neighbors.hasNext()) {
                currentNeighbor = neighbors.next();
                if (!visited[currentNeighbor] && currentNeighbor!=parent) {
                    visited[currentNeighbor] = true;
                    queue.add(currentNeighbor);
                    if (currentNeighbor == w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}