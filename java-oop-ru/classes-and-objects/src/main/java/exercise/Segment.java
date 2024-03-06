package exercise;

// BEGIN
public class Segment {

    private Point beginPoint;
    private Point endPoint;

    Segment(Point p1, Point p2) {
        this.beginPoint = p1;
        this.endPoint = p2;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int midX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
