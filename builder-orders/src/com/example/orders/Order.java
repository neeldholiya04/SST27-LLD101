package com.example.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = new ArrayList<>();
        for (OrderLine line : builder.lines) {
            this.lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
        }
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static Builder builder(String id, String customerEmail) {
        return new Builder(id, customerEmail);
    }

    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent = null;
        private boolean expedited = false;
        private String notes = null;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line == null) {
                throw new IllegalArgumentException("OrderLine cannot be null");
            }
            this.lines.add(line);
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) {
                for (OrderLine line : lines) {
                    addLine(line);
                }
            }
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Order ID cannot be null or empty");
            }

            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format: " + customerEmail);
            }

            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be between 0 and 100, got: " + discountPercent);
            }

            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one order line");
            }

            for (OrderLine line : lines) {
                if (line.getQuantity() <= 0) {
                    throw new IllegalArgumentException("Order line quantity must be positive: " + line.getQuantity());
                }
                if (line.getUnitPriceCents() < 0) {
                    throw new IllegalArgumentException("Order line unit price cannot be negative: " + line.getUnitPriceCents());
                }
                if (line.getSku() == null || line.getSku().trim().isEmpty()) {
                    throw new IllegalArgumentException("Order line SKU cannot be null or empty");
                }
            }

            return new Order(this);
        }
    }
}
