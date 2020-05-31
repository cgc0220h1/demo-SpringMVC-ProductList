package service;

import model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> productMap;

    static {
        productMap = new LinkedHashMap<>();
        productMap.put(1, new Product(1, "Iphone 7", "Chanh sả", 20000000));
        productMap.put(2, new Product(2, "Iphone 6", "Không chanh sả lắm", 15000000));
        productMap.put(3, new Product(3, "Iphone XR", "Cực kỳ chanh sả", 25000000));
        productMap.put(4, new Product(4, "Samsung Note 7", "Hàng của Oppa", 15000000));
        productMap.put(5, new Product(5, "Xiaomi A7", "Hàng nhái Iphone", 5000000));
        productMap.put(6, new Product(6, "Samsung Galaxy A3", "Hàng Lởm", 3000000));
    }

    @Override
    public List<Product> findAll() {
        return new LinkedList<>(productMap.values());
    }

    @Override
    public Product findOne(int id) {
        return productMap.get(id);
    }

    @Override
    public boolean save(Product product) {
        int id = productMap.size() + 1;
        product.setId(id);
        return productMap.put(id, product) == product;
    }

    @Override
    public boolean update(int id, Product product) {
        return productMap.put(id, product) == product;
    }

    @Override
    public boolean remove(int id) {
        Product product = productMap.get(id);
        return productMap.remove(id) == product;
    }
}
