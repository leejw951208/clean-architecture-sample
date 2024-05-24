package com.example.hexagonalarchitecture;

import com.example.hexagonalarchitecture.order.shared.util.GeneratedOrderNumber;
import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HexagonalArchitectureApplicationTests {
	@Autowired
	private GeneratedOrderNumber generatedOrderNumber;

	@Test
	void contextLoads() {
		String generate = generatedOrderNumber.generate("230524GA99999");
		System.out.println("===" + generate);
	}

}
