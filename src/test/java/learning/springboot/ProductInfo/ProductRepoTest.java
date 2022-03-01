package learning.springboot.ProductInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import learning.springboot.ProductInfo.model.Product;
import learning.springboot.ProductInfo.repository.ProductRepo;

@DataJpaTest
public class ProductRepoTest {
	@Autowired
	private ProductRepo productRepo;

	@Test
	public void newProductTest() {
		List<Product> list = new ArrayList<>();
		Product pdt = new Product();

		pdt.setId(1001);
		pdt.setName("Laptops");
		pdt.setDescription("Asus vivobook");
		pdt.setPrice(35000);
		productRepo.save(pdt);
		list.add(pdt);
		assertNotNull(list);
//		 assertNull(list);
	}

	@Test
	public void getProductByIdTest() {

		Product pdt = new Product();
		pdt.setId(1001);
		productRepo.save(pdt);

		assertEquals(1001, pdt.getId());

	}

	@Test
	public void getAllProductsTest() {
//		Product pdt = new Product();
//		 pdt.setId(1001);
//		 productRepo.save(pdt);

		List<Product> list = productRepo.findAll();
		System.out.println(list);
		assertNotNull(list);
	}

	@Test
	public void updateProductTest() {
		Product p = productRepo.findById(1001).get();
//		return updateProduct;
		p.setPrice(10000);
		productRepo.save(p);
		assertNotEquals(35000, productRepo.findById(1001).get().getPrice());
	}

	@Test
	public void deleteProductTest() {
		productRepo.deleteById(1001);
		assertFalse(productRepo.existsById(1002));
		
//		assertEquals(1001, actualpdt);
	
	}

}
