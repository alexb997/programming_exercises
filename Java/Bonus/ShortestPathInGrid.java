import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGrid {
    static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int shortestPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return -1;
        boolean[][] visited = new boolean[rows][cols];
        int[] dirX = {-1, 1, 0, 0}, dirY = {0, 0, -1, 1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == rows - 1 && point.y == cols - 1) return point.dist;
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dirX[i], newY = point.y + dirY[i];
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && !visited[newX][newY] && grid[newX][newY] == 0) {
                    queue.add(new Point(newX, newY, point.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };
        int result = shortestPath(grid);
        System.out.println(result == -1 ? "No path exists" : "Shortest path length: " + result);
    }
}
