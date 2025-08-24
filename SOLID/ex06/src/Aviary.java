public class Aviary {
    public void release(Bird bird) {
        if (bird instanceof Flyable flyable) {
            flyable.fly();
        } else {
            System.out.println(bird.name() + " waddles out safely!");
        }
        System.out.println("Released");
    }
}
