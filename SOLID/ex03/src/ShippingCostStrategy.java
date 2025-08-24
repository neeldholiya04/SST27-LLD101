public interface ShippingCostStrategy {
    boolean supports(String type);

    double calculate(Shipment shipment);
}
