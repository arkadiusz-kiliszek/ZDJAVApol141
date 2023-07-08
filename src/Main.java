import exercies.Point;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj liczbe punktów, które chcesz wprowadzic: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < numberOfPoints; i++) {
            System.out.println("Podaj x ");
            int x = scanner.nextInt();
            System.out.println("Podaj y");
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }
        points.forEach(p -> p.calculateNeighbours(points));
        points.forEach(Point::printData);
    }
}