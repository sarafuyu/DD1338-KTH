import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author Sara Rydell
 * @version 2023-02-23
 */
public class Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge from
     * v to w; c is the cost assigned to this edge.
     */
    private final Map<Integer, Integer>[] edges;

    /** Number of edges in the graph. */
    private int numEdges;

    /** Number of vertices in the graph. */
    private int numVertices; // new code

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity: O(n)
     *
     * @throws IllegalArgumentException if n < 0
     */
    public Graph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] a = new HashMap[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashMap<>();
        }
        edges = a;
        numVertices = n; // new code
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int numVertices() {
        // TODO
        return this.numVertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int numEdges() {
        // TODO
        return this.numEdges;
    }

    /**
    * Helper function that determines if v is a valid vertex in the graph.
    *
    * @param v vertex
    * @return boolean result for presence of vertex v
    */
    private boolean validVertex(int v) {
        return v >= 0 && v < edges.length;
    }

    /**
     * Returns the outdegree of vertex v.
     *
     * @param v vertex
     * @return the outdegree of vertex v
     * @throws IllegalArgumentException if v is out of range
     */
    public int degree(int v) {
        if (!validVertex(v)) {
            throw new IllegalArgumentException("v is out of range.");
        }
        return edges[v].size();
    }

    /**
     * Returns an iterator of vertices adjacent to v.
     *
     * @param v vertex
     * @return an iterator of vertices adjacent to v
     * @throws IllegalArgumentException if v is out of range
     */
    public Iterator<Integer> neighbors(int v) {
        // TODO
        if (!validVertex(v))
            throw new IllegalArgumentException("v is out of range.");
        return edges[v].keySet().iterator();
    }

    /**
     * Returns true if there is an edge (from, to).
     *
     * @param v vertex
     * @param w vertex
     * @return true if there is an edge (from, to).
     * @throws IllegalArgumentException if from or to are out of range
     */
    public boolean hasEdge(int v, int w) {
        // TODO
        if (!validVertex(v) || !validVertex(w))
            throw new IllegalArgumentException("from or to are out of range.");
        return edges[v].containsKey(w);
    }

    /**
     * Returns the edge cost if from and to are adjacent, otherwise -1.
     *
     * @param v vertex
     * @param w vertex
     * @return edge cost if available, -1 otherwise
     * @throws IllegalArgumentException if from or to are out of range
     */
    public int cost(int v, int w) throws IllegalArgumentException {
        // TODO
        if (!validVertex(v) || !validVertex(w))
            throw new IllegalArgumentException("from or to are out of range.");
        if (edges[v].containsKey(w)) {
            return edges[v].get(w);
        }
        return -1;
    }

    /**
     * Inserts an edge with edge cost c.
     *
     * @param c edge cost, c >= 0
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if from or to are out of range
     */
    public void add(int v, int w, int c) {
        // TODO
        if (!validVertex(v) || !validVertex(w)) {
            throw new IllegalArgumentException("From or to are out of range.");
        }
        if (!edges[v].containsKey(w) && !edges[w].containsKey(v)) {
            numEdges++;
        }
        edges[v].put(w, c);
        edges[w].put(v, c);
    }

    /**
     * Removes the edges between v and w.
     *
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if v or w are out of range
     */
    public void remove(int v, int w) {
        // TODO
        if (!validVertex(v) || !validVertex(w))
            throw new IllegalArgumentException("v or w are out of range.");
        if (edges[v].containsKey(w)) {
            edges[v].remove(w);
            edges[w].remove(v);
            numEdges--;
        }
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter). For
     * example, if a graph has edges (2,3,0) and (1,0,0), the
     * representaiton should be:
     *
     * "{(1,0,0), (2,3,0)}" or "{(2,3,0), (1,0,0)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        int n = numVertices; 
        int c;
        if (n == 0) {
            str.append("}");
            return str.toString();
        }
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (hasEdge(i,j)) {
                    c = cost(i,j);
                    str.append("(" + i + "," + j + "," + c + ")" + ", ");
                }
            }
        }
        str.delete(str.length() - 2, str.length());
        str.append("}");
        return str.toString();
    }
}