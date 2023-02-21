package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    protected int PriceBuy;
    protected int Count;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderItems() {
    }

    public OrderItems(Date dateCreated, boolean isDelete, int priceBuy, int count) {
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        PriceBuy = priceBuy;
        Count = count;
    }
}
