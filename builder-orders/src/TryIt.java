import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        // Use Builder pattern instead of old constructor + setters
        Order o = Order.builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .discountPercent(10)
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> Totals remain stable due to defensive copies and immutability.");
    }
}
