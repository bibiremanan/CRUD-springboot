package learning.springboot.ProductInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.springboot.ProductInfo.model.Product;
import learning.springboot.ProductInfo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productServices;

	@PostMapping("/addnewproduct")
	public Product newProduct(@RequestBody Product product) {
		return productServices.createProduct(product);

	}

	@PutMapping("/updateproduct/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable long id) {
		productServices.updateProduct(id, product);
	}

	@GetMapping("/getproduct/{id}")
	public Product getProductById(@PathVariable long id) {
		return productServices.getProduct(id);
	}

	@RequestMapping("/getproducts")
	public List<Product> getAllProducts() {
		return productServices.getAllProduct();
	}

}
