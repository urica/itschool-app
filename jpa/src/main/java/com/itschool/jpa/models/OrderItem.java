package com.itschool.jpa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrderItem() {
    }

    public OrderItem(Order order, Instrument instrument, Integer quantity) {
        this.order = order;
        this.quantity = quantity;
        this.instrument = instrument;
    }

    public BigDecimal getSubtotal() {
        return instrument.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public void setQuantity(Integer quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive!");
        if (quantity > instrument.getStockQuantity())
            throw new IllegalStateException("Insufficient stock for this instrument!");

        this.quantity = quantity;
    }

    public void updateInstrumentStock() {
        this.instrument.setStockQuantity(this.instrument.getStockQuantity() - this.quantity);
    }

}
