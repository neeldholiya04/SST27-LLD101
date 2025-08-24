/*
 * PaymentService does both provider selection and payment logic. Adding a new provider means modifying this class. This is the violation of the Single Responsibility Principle.
 * The switch statement forces modification of PaymentService whenever a new provider is added. This is the violation of the Open/Closed Principle.
 * Payment types are not modeled polymorphically. There’s no guarantee that all "payment providers" can be treated interchangeably. This is the violation of the Liskov Substitution Principle.
 * No provider-specific contracts exist. A proper abstraction is missing. This is the violation of the Interface Segregation Principle.
 * PaymentService depends on concrete data (provider string) instead of an abstraction (PaymentProvider). High-level module (PaymentService) depends on low-level details. This is the violation of the Dependency Inversion Principle.
 */
public class Demo04 {
    public static void main(String[] args) {
        Payment payment = new Payment(499);

        PaymentService upiService = new PaymentService(new UpiPayment());
        PaymentService cardService = new PaymentService(new CardPayment());
        PaymentService walletService = new PaymentService(new WalletPayment());

        System.out.println(upiService.processPayment(payment));
        System.out.println(cardService.processPayment(payment));
        System.out.println(walletService.processPayment(payment));
    }
}
