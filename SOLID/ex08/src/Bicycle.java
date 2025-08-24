public class Bicycle implements Vehicle, PedalPowered {
    @Override
    public void move() {
        System.out.println("Bicycle is moving...");
    }

    @Override
    public void pedal(int effort) {
        System.out.println("Pedaling with effort " + effort);
    }
}
