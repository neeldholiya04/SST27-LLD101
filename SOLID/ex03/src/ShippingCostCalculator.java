import java.util.List;

public class ShippingCostCalculator {
    private final List<ShippingCostStrategy> strategies;

    public ShippingCostCalculator(List<ShippingCostStrategy> strategies) {
        this.strategies = strategies;
    }

    public double cost(Shipment shipment) {
        return strategies.stream()
                .filter(s -> s.supports(shipment.getType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown type: " + shipment.getType()))
                .calculate(shipment);
    }
}
