public class StandardShipping implements ShippingCostStrategy {
    @Override
    public boolean supports(String type) {
        return "STANDARD".equalsIgnoreCase(type);
    }

    @Override
    public double calculate(Shipment shipment) {
        return 50 + 5 * shipment.getWeightKg();
    }
}
