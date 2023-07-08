package exercies;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Point {
    private int x;

    private int y;

    private Point neighbour;

    private double distanceToNeighbour;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void calculateNeighbours(Set<Point> pointSet){
        pointSet.stream()
                .filter(p -> !Objects.equals(this, p))
                .min(Comparator.comparingDouble(this::calculateDistance))
                .ifPresent(n -> {
                    this.neighbour = n;
                    this.distanceToNeighbour = calculateDistance(n);
                });
    }

    public double calculateDistance(Point p2) {
        double powOne = Math.pow((p2.getX() - this.getY()), 2);
        double powSec = Math.pow((p2.getY() - this.getY()), 2);
        return Math.sqrt(powOne + powSec);
    }

    public void printData(){
        System.out.println(this + " my best neigbour is " + neighbour + " distance to him : " + distanceToNeighbour);
    }
}
