package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_products")
public class Product {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment by key when adding new entry
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500, nullable = false)
    private String name;
    @Column(length = 4000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    public Product() {
        productImages = new ArrayList<>();
    }

    public Product(Date dateCreated, boolean isDelete, String name, String description, Category category) {
        super();
        this.dateCreated = dateCreated;
        this.isDelete = isDelete;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
