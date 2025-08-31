package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines,
                             Integer discount, boolean expedited, String notes) {

        Order.Builder builder = Order.builder(id, email);

        if (lines != null) {
            builder.addLines(lines);
        }

        if (discount != null) {
            builder.discountPercent(discount);
        }

        builder.expedited(expedited);

        if (notes != null) {
            builder.notes(notes);
        }

        return builder.build();
    }
}
