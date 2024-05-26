package com.example.hexagonalarchitecture;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.user.application.port.in.UserSaveUseCases;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.stream.IntStream;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
public class HexagonalArchitectureApplication {
	/*private final ProductSaveUseCases productSaveUseCases;
	private final UserSaveUseCases userSaveUseCases;*/

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

	/*@PostConstruct
	public void init() {
		List<String> names = IntStream.range(1, 10)
				.mapToObj(i -> "product" + i)
				.toList();

		productSaveUseCases.saveProducts(names);
		userSaveUseCases.saveUser("홍길동");

		System.out.println("init data");
	}*/
}
