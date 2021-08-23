package sevice;

import model.Products;

import java.util.List;

public interface ProductsManager {
    List<Products> getlistProduct();

    void save(Products products);

    Products findById(int id);

    void update(int id, Products products);

    void remove(int id);
}
