package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filters")
@IdClass(FiltersPK.class)
public class Filters {
    @Id
    @ManyToOne
    @JoinColumn(name = "filterNames_id", nullable = false)
    private FilterNames filterNames;
    @Id
    @ManyToOne
    @JoinColumn(name = "filterValues_id", nullable = false)
    private FilterValues filterValues;
    @Id // Primary Key
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
