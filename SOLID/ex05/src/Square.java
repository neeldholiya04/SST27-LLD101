public class Square implements Shape {
    private int side;

    public Square() {
        this.side = 0;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
