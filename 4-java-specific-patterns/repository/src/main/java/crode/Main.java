package crode;

import crode.Model.Product;
import crode.Repository.InMemoryProductRepository;
import crode.Repository.ProductRepository;
import crode.Service.ProductService;
import crode.Specification.ProductSpecifications;
import crode.Specification.Specification;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Repository Pattern Demo ===");

        ProductRepository productRepository = new InMemoryProductRepository();
        ProductService productService = new ProductService(productRepository);

        System.out.println("\n1. All Products:");
        displayAllProducts(productRepository);

        System.out.println("\n2. Products by Category:");
        productService.displayProductsByCategory("Electronics");

        System.out.println("\n3. Products in Price Range:");
        productService.displayProductsInPriceRange(100.0, 200.0);

        System.out.println("\n4. Search Products:");
        productService.searchProducts("Air");

        System.out.println("\n5. Top Selling Products:");
        productService.displayTopSellingProducts(3);

        System.out.println("\n6. Complex Queries:");
        productService.displayComplexQuery();

        System.out.println("\n7. Add New Product:");
        productService.addProduct("iPad Pro", "Electronics", 1099.99, 25);

        System.out.println("\n8. Update Product Price:");
        productService.updateProductPrice(1L, 949.99);

        System.out.println("\n9. Deactivate Product:");
        productService.deactivateProduct(2L);

        System.out.println("\n10. Final Product List:");
        displayAllProducts(productRepository);

        System.out.println("\n11. Only Active Products:");
        displayActiveProducts(productRepository);

        System.out.println("\n12. Custom Specification Demo:");
        demonstrateCustomSpecifications(productRepository);
    }

    private static void displayAllProducts(ProductRepository repository) {
        List<Product> allProducts = repository.findAll();
        System.out.println("Total products: " + allProducts.size());
        allProducts.forEach(System.out::println);
    }

    private static void displayActiveProducts(ProductRepository repository) {
        List<Product> activeProducts = repository.findActiveProducts();
        System.out.println("Active products: " + activeProducts.size());
        activeProducts.forEach(System.out::println);
    }

    private static void demonstrateCustomSpecifications(ProductRepository repository) {
        System.out.println("\n=== Custom Specification Examples ===");

        // Expensive electronic products with low stock
        Specification<Product> expensiveElectronicsLowStock = ProductSpecifications.and(
                ProductSpecifications.and(
                        ProductSpecifications.hasCategory("Electronics"),
                        ProductSpecifications.isPriceBetween(800.0, 5000.0)
                ),
                product -> product.getQuantity() < 50
        );

        List<Product> results1 = repository.findBySpecification(expensiveElectronicsLowStock);
        System.out.println("\nExpensive Electronics with Low Stock:");
        results1.forEach(System.out::println);

        // Products with names containing "a" and prices under $50
        Specification<Product> cheapProductsWithA = ProductSpecifications.and(
                ProductSpecifications.nameContains("a"),
                ProductSpecifications.isPriceBetween(0.0, 50.0)
        );

        List<Product> results2 = repository.findBySpecification(cheapProductsWithA);
        System.out.println("\nCheap Products containing 'a':");
        results2.forEach(System.out::println);

        // Demonstrate the power of the Repository pattern with Specification
        System.out.println("\n=== Repository Pattern Benefits ===");
        System.out.println("Abstracts data access");
        System.out.println("Centralizes common queries");
        System.out.println("Allows complex queries with Specification Pattern");
        System.out.println("Easy to test with mock implementations");
        System.out.println("Separates business logic from data access");
    }
}
