package learning.springboot.ProductInfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.springboot.ProductInfo.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	Optional<Product> findById(long id);

}