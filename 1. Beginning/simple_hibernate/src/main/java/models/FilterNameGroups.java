package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filter_names_groups")
@IdClass(FilterNameGroupsPK.class)
public class FilterNameGroups {
    @Id // Primary Key
    @ManyToOne
    @JoinColumn(name = "filterNames_id", nullable = false)
    private FilterNames filterNames;
    @Id
    @ManyToOne
    @JoinColumn(name = "filterValues_id", nullable = false)
    private FilterValues filterValues;
}
