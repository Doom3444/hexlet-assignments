package exercise;

// BEGIN
public class Flat implements Home {

    double area;
    double balconyArea;
    int floor;

    Flat (double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home anotherHome) {
        if (this.getArea() == anotherHome.getArea()) {
            return 0;
        }
        return this.getArea() > anotherHome.getArea() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Квартира площадью " +
                this.getArea() +
                " метров на " +
                floor +
                " этаже";
    }
}
// END
