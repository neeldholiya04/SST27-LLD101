/*
 * Issues in existing implementation
 * Rectangle and Square mix data, geometry, and area calculation in one place. Should separate shape behavior from shape properties. This violates the Single Responsibility Principle.
 * Adding a new shape forces us to modify existing code. This violates the Open/Closed Principle.
 * Square extends Rectangle, but it changes expectations: areaAfterResize(new Square()) doesn’t behave the same as with Rectangle. Subtypes should be substitutable without breaking the client code. This violates the Liskov Substitution Principle.
 */
public class Demo05 {
    static int areaAfterResize(Shape s) {
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            r.setWidth(5);
            r.setHeight(4);
            return r.area();
        } else if (s instanceof Square) {
            Square sq = (Square) s;
            sq.setSide(4);
            return sq.area();
        }
        throw new IllegalArgumentException("Unknown shape");
    }

    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle()));
        System.out.println(areaAfterResize(new Square()));
    }
}
