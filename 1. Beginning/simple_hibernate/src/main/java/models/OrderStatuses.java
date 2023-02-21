package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_order_statuses")
public class OrderStatuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDelete;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    @Column(length = 500, nullable = false)
    protected String name;

    public OrderStatuses() {
    }

    public OrderStatuses(boolean isDelete, Date dateCreated, String name) {
        this.isDelete = isDelete;
        this.dateCreated = dateCreated;
        this.name = name;
    }
}
