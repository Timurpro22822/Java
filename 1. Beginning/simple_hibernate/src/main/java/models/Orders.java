package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "orderStatuses_id", nullable = false)
    protected OrderStatuses orderStatuses;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    public Orders() {
    }

    public Orders(Date dateCreated, boolean isDelete, OrderStatuses orderStatuses, User user) {
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.orderStatuses = orderStatuses;
        this.user = user;
    }
}
