package com.example.hexagonalarchitecture;

import com.example.hexagonalarchitecture.user.adapter.in.web.dto.CreateUserRequestDto;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HexagonalArchitectureApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
		User domainWithId = userMapper.toDomainWithId(new CreateUserRequestDto());
		System.out.println(domainWithId.getId());
	}

}
