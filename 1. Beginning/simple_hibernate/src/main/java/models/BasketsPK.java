package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasketsPK implements Serializable {
    private Product product;
    private User user;
}
