package org.geeksforgeeks;

import java.util.List;

public class Longest_Possible_Route_in_a_Matrix_with_Hurdles {
    private static int max = -1;
    private static boolean visitedDestination;
    private static boolean[][] visited;
    private static int row;
    private static int col;

    private static void recursive(int[][] mat, int currX, int currY, int xd, int yd, int depth) {
        if (currX == xd && currY == yd) {
            visitedDestination = true;
            max = Math.max(max, depth);
            return;
        }

        if (currX - 1 >= 0 && mat[currX - 1][currY] == 1 && !visited[currX - 1][currY]) {
            visited[currX - 1][currY] = true;
            recursive(mat, currX - 1, currY, xd, yd, depth + 1);
            visited[currX - 1][currY] = false;
        }

        if (currY - 1 >= 0 && mat[currX][currY - 1] == 1 && !visited[currX][currY - 1]) {
            visited[currX][currY - 1] = true;
            recursive(mat, currX, currY - 1, xd, yd, depth + 1);
            visited[currX][currY - 1] = false;
        }

        if (currX + 1 < row && mat[currX + 1][currY] == 1 && !visited[currX + 1][currY]) {
            visited[currX + 1][currY] = true;
            recursive(mat, currX + 1, currY, xd, yd, depth + 1);
            visited[currX + 1][currY] = false;
        }

       if (currY + 1 < col && mat[currX][currY + 1] == 1 && !visited[currX][currY + 1]) {
            visited[currX][currY + 1] = true;
            recursive(mat, currX, currY + 1, xd, yd, depth + 1);
            visited[currX][currY + 1] = false;
        }
    }

    public int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd, int yd) {
        if (mat[xs][ys] == 0) {
            return -1;
        }
        max = -1;
        visitedDestination = false;
        visited = new boolean[n][m];
        row = n;
        col = m;
        visited[xs][ys] = true;
        recursive(mat, xs, ys, xd, yd, 0);
        return max;
    }
}
