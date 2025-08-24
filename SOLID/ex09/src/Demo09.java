/*
 * Issues in existing implementation:
 * OrderController is handling both the controller logic (create) and repository instantiation. Should only handle orchestration. This violates the Single Responsibility Principle.
 * OrderController is tightly coupled to SqlOrderRepository. Adding a MongoOrderRepository or InMemoryOrderRepository would require changing OrderController. This violates the Open/Closed Principle.
 * OrderController depends on a concrete class (SqlOrderRepository), not an abstraction. This violates the Dependency Inversion Principle.
 */
public class Demo09 {
    public static void main(String[] args) {
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController controller = new OrderController(sqlRepo);

        controller.create("ORD-1");
    }
}
