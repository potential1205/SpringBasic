package talkwith.semogong.feature.login.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.login.repository.LoginRepository;

import java.util.Optional;

import static talkwith.semogong.domain.QUserEntity.userEntity;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public LoginRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<UserEntity> findUserEntityByEmail(String email) {
        UserEntity result = jpaQueryFactory
                .selectFrom(userEntity)
                .where(userEntity.email.eq(email))
                .fetchOne();

        return Optional.ofNullable(result);
    }
}
