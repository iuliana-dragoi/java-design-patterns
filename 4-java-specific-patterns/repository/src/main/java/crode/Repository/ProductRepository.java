package crode.Repository;

import crode.Model.Product;
import crode.Specification.Specification;

import java.util.List;

public interface ProductRepository {

    void save(Product product);
    void delete(Long id);
    Product findById(Long id);
    List<Product> findAll();
    List<Product> findBySpecification(Specification<Product> specification);

    List<Product> findByCategory(String category);
    List<Product> findByPriceRange(double minPrice, double maxPrice);
    List<Product> findActiveProducts();
    List<Product> findByNameContaining(String keyword);
    List<Product> findTopSellingProducts(int limit);
}
