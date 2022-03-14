package edu.miu.springsecurity1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

}
