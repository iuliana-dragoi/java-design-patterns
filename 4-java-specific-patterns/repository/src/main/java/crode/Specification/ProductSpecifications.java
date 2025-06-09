package crode.Specification;

import crode.Model.Product;

public class ProductSpecifications {

    public static Specification<Product> hasCategory(String category) {
        return product -> product.getCategory().equalsIgnoreCase(category);
    }

    public static Specification<Product> isPriceBetween(double minPrice, double maxPrice) {
        return product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice;
    }

    public static Specification<Product> isActive() {
        return Product::isActive;
    }

    public static Specification<Product> hasQuantityGreaterThan(int minQuantity) {
        return product -> product.getQuantity() > minQuantity;
    }

    public static Specification<Product> nameContains(String keyword) {
        return product -> product.getName().toLowerCase().contains(keyword.toLowerCase());
    }

    // Combine multiple specifications with AND
    public static <T> Specification<T> and(Specification<T> spec1, Specification<T> spec2) {
        return item -> spec1.isSatisfiedBy(item) && spec2.isSatisfiedBy(item);
    }

    // Combine multiple specifications with OR
    public static <T> Specification<T> or(Specification<T> spec1, Specification<T> spec2) {
        return item -> spec1.isSatisfiedBy(item) || spec2.isSatisfiedBy(item);
    }
}
