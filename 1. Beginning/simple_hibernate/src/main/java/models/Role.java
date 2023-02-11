package models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tbl_roles")
public class Role {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment by key when adding new entry
    private int id;
    private String name;
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role() {
        userRoles = new ArrayList<>();
    }
}
