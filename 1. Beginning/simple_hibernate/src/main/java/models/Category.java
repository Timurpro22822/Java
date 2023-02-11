package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;
    protected boolean isDelete;
    @Column(length = 500, nullable = false)
    private String name;
    @Column(length = 200)
    private String image;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name, String image, Date dateCreate, boolean isDelete) {
        super();
        this.name = name;
        this.image = image;
        this.dateCreated = dateCreate;
        this.isDelete = isDelete;
    }
}
