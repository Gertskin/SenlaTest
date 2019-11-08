package by.gertskin;

import java.io.*;

public class Task3 {

    public static class Point {
        double x, y;
        public Point (double newX, double newY) {
            this.x = newX;
            this.y = newY;
        }
    };

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("First line segment start point: ");
        double x = Double.parseDouble(bufferedReader.readLine());
        double y = Double.parseDouble(bufferedReader.readLine());
        Point p1 = new Point(x, y);
        System.out.print("First line segment end point: ");
        x = Double.parseDouble(bufferedReader.readLine());
        y = Double.parseDouble(bufferedReader.readLine());
        Point p2 = new Point(x, y);
        System.out.print("Second line segment start point: ");
        x = Double.parseDouble(bufferedReader.readLine());
        y = Double.parseDouble(bufferedReader.readLine());
        Point p3 = new Point(x, y);
        System.out.print("Second line segment end point: ");
        x = Double.parseDouble(bufferedReader.readLine());
        y = Double.parseDouble(bufferedReader.readLine());
        Point p4 = new Point(x, y);

        System.out.println(checkCross(p1,p2,p3,p4));

    };

    public static boolean checkCross(Point p1, Point p2, Point p3, Point p4) {

        if (p2.x < p1.x) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        if (p4.x < p3.x) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        // если не пересекаются по Х, то не пересекаются
        if (p2.x < p3.x) {
            return false;
        }

        // если отрезки вертикальные
        if ((p1.x - p2.x == 0) && (p3.x - p4.x == 0)) {
            if (p1.x == p3.x) {

                //если верхняя точка первого ниже нижней точки второго или
                //нижняя первого выше верхней, то непересекаются
                if (!((Math.max(p1.y, p2.y) < Math.min(p3.y, p4.y)) ||
                        (Math.min(p1.y, p2.y) > Math.max(p3.y, p4.y)))) {
                    return true;
                }
            }

            return false;
        }

      //если первый отрезок вертикальный
        if (p1.x - p2.x == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p1.x;
            double a2 = (p3.y - p4.y) / (p3.x - p4.x);
            double b2 = p3.y - a2 * p3.x;
            double Ya = a2 * Xa + b2;

            if (p3.x <= Xa && p4.x >= Xa && Math.min(p1.y, p2.y) <= Ya &&
                    Math.max(p1.y, p2.y) >= Ya) {

                return true;
            }

            return false;
        }

        //если второй отрезок вертикальный
        if (p3.x - p4.x == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p3.x;
            double a1 = (p1.y - p2.y) / (p1.x - p2.x);
            double b1 = p1.y - a1 * p1.x;
            double Ya = a1 * Xa + b1;

            if (p1.x <= Xa && p2.x >= Xa && Math.min(p3.y, p4.y) <= Ya &&
                    Math.max(p3.y, p4.y) >= Ya) {

                return true;
            }

            return false;
        }

        //оба отрезка невертикальные
        double a1 = (p1.y - p2.y) / (p1.x - p2.x);
        double a2 = (p3.y - p4.y) / (p3.x - p4.x);
        double b1 = p1.y - a1 * p1.x;
        double b2 = p3.y - a2 * p3.x;

        if (a1 == a2) {
            return false; //отрезки параллельны
        }

        //Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (a1 - a2);

        if ((Xa < Math.max(p1.x, p3.x)) || (Xa > Math.min( p2.x, p4.x))) {
            return false; //точка Xa находится вне пересечения проекций отрезков на ось X
        }
        else {
            return true;
        }

    }
}
