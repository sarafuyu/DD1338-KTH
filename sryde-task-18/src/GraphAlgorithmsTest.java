import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for GraphAlgorithms.
 *
 * @author Sara Rydell
 * @version 2023-02-23
 */

public class GraphAlgorithmsTest {
    @Before
    public void setUp() {}

    @Test
    public void hasCycleTrueMultipleComponents() {
        // Arrange
        // Three components:
        // 0 - 1 - 5
        // 2 - 3
        //  \ /
        //   9
        // 4 - 6 - 7 - 8
        Graph g = new Graph(10);
        // component 1
        g.add(0, 1, 0);
        g.add(1, 5, 0);
        // component 2
        g.add(9, 2, 0);
        g.add(2, 3, 0);
        g.add(3, 9, 0);
        // component 3
        g.add(4, 6, 0);
        g.add(6, 7, 0);
        g.add(7, 8, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertTrue(hasCycle);
    }

    @Test
    public void hasPathTrueTreeGraph() {
        // Arrange
        // One component:
        //            0
        //           / \
        //          1   2
        //         / \   \
        //        3   4   5
        //       / \   \
        //      6   7   8
        //               \
        //                9
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(0, 2, 0);
        g.add(1, 3, 0);
        g.add(1, 4, 0);
        g.add(2, 5, 0);
        g.add(3, 6, 0);
        g.add(3, 7, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 9);

        // Assert
        assertTrue(hasPath);
    }

    @Test
    public void hasCycleFalseSingleComponent() {
        // Arrange
        // One component:
        // 0 - 1 - 4 - 8 - 9
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(1, 4, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertFalse(hasCycle);

        //fail("Not implemented!");
    }

  @Test
  public void hasCycleTrueSingleComponent() {
        // Arrange
        // One component:
        //      0 - 1 - 4
        //       \     /
        //        9 - 8
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(1, 4, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);
        g.add(9, 0, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertTrue(hasCycle);

        //fail("Not implemented!");
  }

  @Test
  public void hasCycleFalseMultipleComponents() {
        // Arrange
        // Three components:
        // 0 - 1 - 5
        // 2 - 3 - 9
        // 4 - 6 - 7 - 8
        Graph g = new Graph(10);
        // component 1
        g.add(0, 1, 0);
        g.add(1, 5, 0);
        // component 2
        g.add(2, 3, 0);
        g.add(3, 9, 0);
        // component 3
        g.add(4, 6, 0);
        g.add(6, 7, 0);
        g.add(7, 8, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertFalse(hasCycle);

        //fail("Not implemented!");
  }

    @Test
    public void graphWithCycleHasPathToSelf() {
        // Arrange
        // One component:
        //      0 - 1 - 4
        //       \     /
        //        9 - 8
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(1, 4, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);
        g.add(9, 0, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 8);

        // Assert
        assertTrue(hasPath);
        assertTrue(hasCycle);

        //fail("Not implemented!");
    }

    @Test
    public void verteciesOnDifferentComponentsHasPathIsFalse() {
        // Arrange
        // Two components:
        // 0 - 1 - 2 - 3 
        // 5 - 6 - 7 - 8
        Graph g = new Graph(10);
        // component 1
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(2, 3, 0);
        // component 2
        g.add(5, 6, 0);
        g.add(6, 7, 0);
        g.add(7, 8, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 9);

        // Assert
        assertFalse(hasPath);

        //fail("Not implemented!");
    }

    @Test
    public void graphWithVerteciesWithoutEdgesHasPathIsFalse() {
        // Arrange
        Graph g = new Graph(10);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 9);

        // Assert
        assertFalse(hasPath);

        //fail("Not implemented!");
    }
}
