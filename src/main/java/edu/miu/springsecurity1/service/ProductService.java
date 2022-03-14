package edu.miu.springsecurity1.service;


import edu.miu.springsecurity1.entity.Product;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);
}
