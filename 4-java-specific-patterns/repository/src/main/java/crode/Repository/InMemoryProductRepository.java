package crode.Repository;

import crode.Model.Product;
import crode.Specification.ProductSpecifications;
import crode.Specification.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryProductRepository implements ProductRepository {

    private Map<Long, Product> products;
    private Long nextId;

    public InMemoryProductRepository() {
        this.products = new HashMap<>();
        this.nextId = 1L;
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Product(null, "iPhone 15", "Electronics", 999.99, 50));
        save(new Product(null, "Samsung Galaxy S24", "Electronics", 899.99, 30));
        save(new Product(null, "MacBook Pro", "Electronics", 1999.99, 15));
        save(new Product(null, "Nike Air Max", "Clothing", 149.99, 100));
        save(new Product(null, "Adidas Ultraboost", "Clothing", 179.99, 80));
        save(new Product(null, "The Great Gatsby", "Books", 12.99, 200));
        save(new Product(null, "Clean Code", "Books", 39.99, 75));
        save(new Product(null, "Wireless Mouse", "Electronics", 25.99, 150));
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        products.put(product.getId(), product);
        System.out.println("Product saved: " + product.getName());
    }

    @Override
    public void delete(Long id) {
        Product removed = products.remove(id);
        if (removed != null) {
            System.out.println("Product deleted: " + removed.getName());
        } else {
            System.out.println("Product with ID " + id + " not found");
        }
    }

    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findBySpecification(Specification<Product> specification) {
        return products.values().stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCategory(String category) {
        return findBySpecification(ProductSpecifications.hasCategory(category));
    }

    @Override
    public List<Product> findByPriceRange(double minPrice, double maxPrice) {
        return findBySpecification(ProductSpecifications.isPriceBetween(minPrice, maxPrice));
    }

    @Override
    public List<Product> findActiveProducts() {
        return findBySpecification(ProductSpecifications.isActive());
    }

    @Override
    public List<Product> findByNameContaining(String keyword) {
        return findBySpecification(ProductSpecifications.nameContains(keyword));
    }

    @Override
    public List<Product> findTopSellingProducts(int limit) {
        // Simulate "best sellers" by sorting descending quantity
        return products.values().stream()
            .sorted((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()))
            .limit(limit)
            .collect(Collectors.toList());
    }
}
