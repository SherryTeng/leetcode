public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        //do indexOutOfBounds checks before any conditional checks
        if ( sr < 0 || sr >= image.length ||sc < 0 || sc >= image[0].length ||image[sr][sc] != oldColor ) return;
        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, oldColor, newColor);
        dfs(image, sr+1, sc, oldColor, newColor);
        dfs(image, sr, sc-1, oldColor, newColor);
        dfs(image, sr, sc+1, oldColor, newColor);
    }
}
