package talkwith.semogong.feature.join.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.join.repository.JoinRepository;
import java.util.Optional;

import static talkwith.semogong.domain.QUserEntity.userEntity;

@Repository
public class JoinRepositoryImpl implements JoinRepository {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public JoinRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<UserEntity> findUserEntityByName(String name){
        UserEntity result = jpaQueryFactory
                .selectFrom(userEntity)
                .where(userEntity.name.eq(name))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public void saveUser(UserEntity userEntity){
        entityManager.persist(userEntity);
    }

}
