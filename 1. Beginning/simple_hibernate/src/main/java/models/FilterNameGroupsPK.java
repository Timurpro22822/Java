package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilterNameGroupsPK implements Serializable {

    protected FilterNames filterNames;
    protected FilterValues filterValues;
}
