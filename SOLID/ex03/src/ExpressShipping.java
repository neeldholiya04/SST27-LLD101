public class ExpressShipping implements ShippingCostStrategy {
    @Override
    public boolean supports(String type) {
        return "EXPRESS".equalsIgnoreCase(type);
    }

    @Override
    public double calculate(Shipment shipment) {
        return 80 + 8 * shipment.getWeightKg();
    }
}
