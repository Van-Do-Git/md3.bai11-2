package sevice;

import model.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsManagerImpl implements ProductsManager {
    private static Map<Integer, Products> productsMap;

    static {
        productsMap = new HashMap<>();
        productsMap.put(1, new Products("Iphone 5", "https://didongviet.vn/pub/media/catalog/product//a/p/apple-iphone-5s-vang-didongviet_.png", 1550));
        productsMap.put(2, new Products("Iphone 6", "https://didongviet.vn/pub/media/catalog/product//i/p/iphone-6s-didongviet_2.jpg", 1650));
        productsMap.put(3, new Products("Iphone 7", "https://clickbuy.com.vn/uploads/2019/03/iPhone-7-jetback.png", 1750));
        productsMap.put(4, new Products("Iphone 8", "https://dienthoaihay.vn/images/products/2020/08/27/original/iphone-8-plus-do_1598492332.jpg", 1850));
        productsMap.put(5, new Products("Iphone 9", "https://www.viettablet.com/images/thumbnails/480/516/detailed/27/iphone-9-plus-chinh-hang-xach-tay-vtb.jpg", 1950));
        productsMap.put(6, new Products("Iphone X", "https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-hh-600x600.jpg", 2050));
    }

    @Override
    public List<Products> getlistProduct() {
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void save(Products products) {
        productsMap.put(products.getId(), products);
    }

    @Override
    public Products findById(int id) {
        return productsMap.get(id);
    }

    @Override
    public void update(int id, Products products) {
        productsMap.put(id, products);
    }

    @Override
    public void remove(int id) {
        productsMap.remove(id);
    }
}
