public class Rectangle implements Shape {
    private int width, height;

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }
}
