import java.util.*;

public class ShortestPathInMatrix {
    // Directions for moving in the matrix (right, down, left, up)
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static List<int[]> findPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return new ArrayList<>(); // No path exists if start or end is blocked
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        Map<int[], int[]> parentMap = new HashMap<>(); // To store the path
        parentMap.put(new int[]{0, 0}, null);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // If we've reached the bottom-right corner
            if (x == rows - 1 && y == cols - 1) {
                return constructPath(parentMap, current);
            }

            // Explore neighbors
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isValid(grid, newX, newY) && !parentMap.containsKey(new int[]{newX, newY})) {
                    parentMap.put(new int[]{newX, newY}, current);
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        // Return an empty list if no path is found
        return new ArrayList<>();
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
    }

    private static List<int[]> constructPath(Map<int[], int[]> parentMap, int[] end) {
        List<int[]> path = new LinkedList<>();
        for (int[] at = end; at != null; at = parentMap.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        List<int[]> path = findPath(grid);

        if (path.isEmpty()) {
            System.out.println("No path exists");
        } else {
            for (int[] coordinates : path) {
                System.out.println(Arrays.toString(coordinates));
            }
        }
    }
}
