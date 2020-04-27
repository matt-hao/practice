package practice.hackTheAlgorithm;

public class EncloseBlackPixels {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0)
            return 0;

        boolean[][] visited = new boolean[image.length][image[0].length];

        //left, up, right, down
        int[] area = new int[]{y, x, y, x};

        visited[x][y] = true;
        leftHelper(image, visited, x, y, area);
        upHelper(image, visited, x, y, area);
        rightHelper(image, visited, x, y, area);
        downHelper(image, visited, x, y, area);

        int width = Math.abs(area[2] - area[0]) + 1;
        int height = Math.abs(area[3] - area[1]) + 1;

        return width * height;
    }

    private void leftHelper(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        int i = y - 1;
        for (; i >= 0 && image[x][i] == '1' && !visited[x][i]; i--) {
            if (i < area[0])
                area[0] = i;
            visited[x][i] = true;
            upAndDown(image, visited, x, i, area);
        }
    }

    private void upHelper(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        int i = x - 1;
        for (; i >= 0 && image[i][y] == '1' && !visited[i][y]; i--) {
            if (i < area[1])
                area[1] = i;
            visited[i][y] = true;
            leftAndRight(image, visited, i, y, area);
        }
    }

    private void rightHelper(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        int i = y + 1;
        for (; i <= image[x].length - 1 && image[x][i] == '1' && !visited[x][i]; i++) {
            if (i > area[2])
                area[2] = i;
            visited[x][i] = true;
            upAndDown(image, visited, x, i, area);
        }
    }

    private void downHelper(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        int i = x + 1;
        for (; i <= (image.length - 1) && image[i][y] == '1' && !visited[i][y]; i++) {
            if (i > area[3])
                area[3] = i;
            visited[i][y] = true;
            leftAndRight(image, visited, i, y, area);
        }
    }

    private void leftAndRight(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        if (y - 1 >= 0 && !visited[x][y - 1] && image[x][y - 1] == '1')
            leftHelper(image, visited, x, y, area);
        if (y + 1 <= image[x].length - 1 && !visited[x][y + 1] && image[x][y + 1] == '1')
            rightHelper(image, visited, x, y, area);
    }

    private void upAndDown(char[][] image, boolean[][] visited, int x, int y, int[] area) {
        if (x - 1 >= 0 && !visited[x - 1][y] && image[x - 1][y] == '1')
            upHelper(image, visited, x, y, area);
        if (x + 1 <= image.length - 1 && !visited[x + 1][y] && image[x + 1][y] == '1')
            downHelper(image, visited, x, y, area);
    }

    public static void main(String[] args) {
        EncloseBlackPixels e = new EncloseBlackPixels();
        String[] a = new String[]{
                "110000000111111101",
                "110000111111111111",
                "111111111111111111",
                "111111111111101111",
                "111111111111111111",
                "111111111111111111",
                "001111111111111101",
                "001111111111111100",
                "001111111111111110",
                "001111111111111110",
                "001111110110111110",
                "111111111111111110",
                "110111101111001110"};
        char[][] c = new char[a.length][a[0].length()];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                c[i][j] = a[i].charAt(j);
            }
        }
        System.out.println(e.minArea(c, 4, 4));
    }
}
