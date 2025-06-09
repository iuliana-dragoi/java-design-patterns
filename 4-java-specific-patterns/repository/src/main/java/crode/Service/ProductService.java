package crode.Service;

import crode.Model.Product;
import crode.Repository.ProductRepository;
import crode.Specification.ProductSpecifications;
import crode.Specification.Specification;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name, String category, double price, int quantity) {
        Product product = new Product(null, name, category, price, quantity);
        productRepository.save(product);
    }

    public void displayProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        System.out.println("\n=== Products in category: " + category + " ===");
        products.forEach(System.out::println);
    }

    public void displayProductsInPriceRange(double minPrice, double maxPrice) {
        List<Product> products = productRepository.findByPriceRange(minPrice, maxPrice);
        System.out.println(String.format("\n=== Products between $%.2f and $%.2f ===", minPrice, maxPrice));
        products.forEach(System.out::println);
    }

    public void searchProducts(String keyword) {
        List<Product> products = productRepository.findByNameContaining(keyword);
        System.out.println("\n=== Search results for: " + keyword + " ===");
        products.forEach(System.out::println);
    }

    public void displayTopSellingProducts(int limit) {
        List<Product> products = productRepository.findTopSellingProducts(limit);
        System.out.println("\n=== Top " + limit + " Products by Stock ===");
        products.forEach(System.out::println);
    }

    public void displayComplexQuery() {
        // Complex query using Specification Pattern
        Specification<Product> expensiveElectronics = ProductSpecifications.and(
                ProductSpecifications.hasCategory("Electronics"),
                ProductSpecifications.isPriceBetween(500.0, 2000.0)
        );

        List<Product> products = productRepository.findBySpecification(expensiveElectronics);
        System.out.println("\n=== Expensive Electronics (500-2000$) ===");
        products.forEach(System.out::println);

        // Another complex query: active products with large stock OR cheap books
        Specification<Product> highStockProducts = ProductSpecifications.and(
                ProductSpecifications.isActive(),
                ProductSpecifications.hasQuantityGreaterThan(100)
        );

        Specification<Product> cheapBooks = ProductSpecifications.and(
                ProductSpecifications.hasCategory("Books"),
                ProductSpecifications.isPriceBetween(0.0, 20.0)
        );

        Specification<Product> complexQuery = ProductSpecifications.or(highStockProducts, cheapBooks);

        List<Product> complexResults = productRepository.findBySpecification(complexQuery);
        System.out.println("\n=== High Stock Products OR Cheap Books ===");
        complexResults.forEach(System.out::println);
    }

    public void updateProductPrice(Long productId, double newPrice) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            product.setPrice(newPrice);
            productRepository.save(product);
            System.out.println("Price updated for: " + product.getName());
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void deactivateProduct(Long productId) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            product.setActive(false);
            productRepository.save(product);
            System.out.println("Product deactivated: " + product.getName());
        }
    }
}
