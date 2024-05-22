package com.example.hexagonalarchitecture.user.adapter.out.persistence.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.hexagonalarchitecture.user.adapter.out.persistence.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserEntityRepositoryCustomImpl implements UserEntityRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<UserEntity> findById(long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(userEntity)
                        .where(userEntity.id.eq(id))
                        .fetchOne()
        );
    }
}
