public class OrderCalculator {
    private final double taxRate;

    public OrderCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
}
