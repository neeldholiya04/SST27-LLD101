public class OvernightShipping implements ShippingCostStrategy {
    @Override
    public boolean supports(String type) {
        return "OVERNIGHT".equalsIgnoreCase(type);
    }

    @Override
    public double calculate(Shipment shipment) {
        return 120 + 10 * shipment.getWeightKg();
    }
}
