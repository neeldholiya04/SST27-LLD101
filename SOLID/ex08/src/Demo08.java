/*
 * Issues in existing implementation:
 * Vehicle forces all implementers (Bicycle, Car, ElectricCar, etc.) to implement irrelevant methods. This violates the Interface Segregation Principle.
 * One interface (Vehicle) tries to handle engine-driven, pedal-driven, and electric-powered vehicles. This violates the Single Responsibility Principle.
 * A Bicycle cannot substitute a Vehicle in Demo08 safely, because calling startEngine() crashes. This violates the Liskov Substitution Principle.
 */
public class Demo08 {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle();
        bike.move();
        bike.pedal(5);
    }
}
