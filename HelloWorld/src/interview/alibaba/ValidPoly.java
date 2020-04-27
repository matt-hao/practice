package interview.alibaba;

/**
 * 这题其实是在验证一个多边形是否是凸多边形
 */
public class ValidPoly {
    public boolean validConvex(int[][] points) {
        int cro_pro;
        int pointsNum = points.length;
        boolean negative = false;
        boolean positive = false;
        for (int i = 2; i < pointsNum + 2; i++) {
            cro_pro = crossProduct(points[(i - 2) % pointsNum], points[(i - 1) % pointsNum], points[i % pointsNum]);
            if (cro_pro == 1) {
                positive = true;
            } else if (cro_pro == -1) {
                negative = true;
            }
        }
        if (positive && negative || (!positive && !negative)) {
            return false;
        } else {
            return true;
        }
    }

    private int crossProduct(int[] p1, int[] p2, int[] p3) {
        int ax = p2[0] - p1[0];
        int ay = p2[1] - p1[1];
        int bx = p3[0] - p2[0];
        int by = p3[1] - p2[1];
        int cro_pro = ax * by - ay * bx;
        if (cro_pro > 0) {
            return 1;
        } else if (cro_pro < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ValidPoly validPoly = new ValidPoly();
        int[][] points1 = new int[][]{
                {0, 0}, {0, 1}, {1, 1}, {1, 0}
        };
        System.out.println(validPoly.validConvex(points1));


        int[][] points2 = new int[][]{
                {0, 0}, {0, 10}, {10, 10}, {10, 0}, {5, 5}
        };
        System.out.println(validPoly.validConvex(points2));
    }
}
