/*
 * Issues in existing implementation:
 * Machine is trying to do multiple things (print, scan, fax). This violates the Single Responsibility Principle.
 * Machine interface forces every printer to implement scan and fax, even if they don’t support them. This violates the Interface Segregation Principle.
 * BasicPrinter breaks expectations: if Machine m = new BasicPrinter() is used, calling scan() breaks. A subtype should not break base class contracts. This violates the Liskov Substitution Principle.
 */
public class Demo07 {
    public static void main(String[] args) {

        BasicPrinter basic = new BasicPrinter();
        basic.print("Hello");
        basic.scan("/tmp/out");
        basic.fax("1234567890");
    }
}
