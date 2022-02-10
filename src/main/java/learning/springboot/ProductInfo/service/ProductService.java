package learning.springboot.ProductInfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.springboot.ProductInfo.exception.NotFoundException;
import learning.springboot.ProductInfo.model.Product;
import learning.springboot.ProductInfo.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo productRepo;

	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();
		productRepo.findAll().forEach(products::add);
		return products;
	}

	public Product getProduct(long id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Get Product | Product not found ! | Product_id:" + id));
	}

	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	public void updateProduct(long id, Product product) {
		Product updateProduct = productRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Update Product | Product not found | Product_id:" + id));
		updateProduct.setName(product.getName());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setPrice(product.getPrice());
		productRepo.save(updateProduct);
	}

	public void deleteProduct(long id) {
		Product deleteProduct = productRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Delete Product | Product not found | Product_id:" + id));
		productRepo.delete(deleteProduct);
	}

}
