
/*
 * Issues in Existing Implementation
 * ShippingCostCalculator both stores shipping cost formulas and decides which one to use. This violates the Single Responsibility Principle.
 * To add a new shipping type, you must modify the ShippingCostCalculator class instead of just extending functionality. This is the violation of Open/Closed Principle
 * Without polymorphism, new strategies cannot be substituted safely for existing ones. This is the violation of Liskov Substitution Principle.
 * The ShippingCostCalculator is tightly coupled to specific shipping types. This makes it hard to test in isolation and violates the Dependency Inversion Principle.
 */

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args) {
        ShippingCostCalculator calculator = new ShippingCostCalculator(
                Arrays.asList(
                        new StandardShipping(),
                        new ExpressShipping(),
                        new OvernightShipping()));

        Shipment s1 = new Shipment("STANDARD", 3.0);
        Shipment s2 = new Shipment("EXPRESS", 2.0);
        Shipment s3 = new Shipment("OVERNIGHT", 1.5);

        System.out.println("STANDARD cost = " + calculator.cost(s1));
        System.out.println("EXPRESS  cost = " + calculator.cost(s2));
        System.out.println("OVERNIGHT cost = " + calculator.cost(s3));
    }
}
