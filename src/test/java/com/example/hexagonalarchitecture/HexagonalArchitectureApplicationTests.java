package com.example.hexagonalarchitecture;

import com.example.hexagonalarchitecture.order.shared.util.GeneratedOrderNumber;
import com.example.hexagonalarchitecture.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HexagonalArchitectureApplicationTests {
	@Autowired
	private GeneratedOrderNumber generatedOrderNumber;

	@Test
	void contextLoads() {
		Product product = Product.builder()
				.id(null)
				.name("name")
				.createdDate(null)
				.build();

	}

}
