/*
 * Issues in existing implementation:
 * Aviary.release() assumes all birds can fly. But not all birds should have the same release behavior. This is the violation of the Single Responsibility Principle.
 * Penguin extends Bird, but Penguin.fly() throws an exception. That means a Penguin cannot safely be substituted for a Bird. This is the violation of the Liskov Substitution Principle.
 * Bird has a fly() method, forcing all birds to support flight. Penguins cannot. This is the violation of Interface Segregation Principle.
 */
public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        aviary.release(new Penguin());
    }
}
