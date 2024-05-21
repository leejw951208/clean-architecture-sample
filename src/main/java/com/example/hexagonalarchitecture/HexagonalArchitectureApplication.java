package com.example.hexagonalarchitecture;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;
import com.example.hexagonalarchitecture.product.application.port.in.CreateProductUseCase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
public class HexagonalArchitectureApplication {
	private final CreateProductUseCase createProductUseCase;

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<CreateProductRequestDto> dtos = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			dtos.add(CreateProductRequestDto.builder().productName("product" + i).build());
		}
		createProductUseCase.createProducts(dtos);
		System.out.println("init data");
	}
}
