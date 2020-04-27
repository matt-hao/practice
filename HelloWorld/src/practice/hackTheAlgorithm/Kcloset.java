package practice.hackTheAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kcloset {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k:      An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0 || k > points.length)
            return new Point[0];

        Comparator<Point> myComparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double distance1 = Math.sqrt(Math.pow(o1.x - origin.x, 2) + Math.pow(o1.y - origin.y, 2));
                double distance2 = Math.sqrt(Math.pow(o2.x - origin.x, 2) + Math.pow(o2.y - origin.y, 2));
                double distance = distance1 - distance2;
                if (distance == 0) {
                    int xCom = o1.x - o2.x;
                    int yCom = o1.y - o2.y;
                    if (xCom == 0) {
                        return yCom > 0 ? 1 : -1;
                    } else {
                        return xCom > 0 ? 1 : -1;
                    }
                } else {
                    return distance > 0 ? 1 : -1;
                }
            }
        };

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        };
        comparator = Comparator.comparingInt((Point x) -> x.x).thenComparingInt((Point x) -> x.y);

        Queue<Point> queue = new PriorityQueue<Point>(myComparator);
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
        }


        Point[] kPoints = new Point[k];
        int count = 0;
        while (count != k) {
            kPoints[count++] = queue.poll();
        }
        return kPoints;
    }

    public static void main(String[] args) {
        //[[4,6],[4,7],[4,4],[2,5],[1,1]]
        //[0,0]
        //3

        Point p1 = new Point(4, 6);
        Point p2 = new Point(4, 7);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(2, 5);
        Point p5 = new Point(1, 1);
        Point[] points = new Point[5];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;

        Kcloset k = new Kcloset();
        Point[] p = k.kClosest(points, new Point(0, 0), 3);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}