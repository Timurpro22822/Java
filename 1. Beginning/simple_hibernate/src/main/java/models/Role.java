package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_roles")
public class Role {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment by key when adding new entry
    private int id;
    private String name;

}
