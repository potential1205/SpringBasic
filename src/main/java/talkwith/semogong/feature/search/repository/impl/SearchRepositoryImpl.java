package talkwith.semogong.feature.search.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.search.repository.SearchRepository;
import static talkwith.semogong.domain.QUserEntity.userEntity;
import java.util.List;
import java.util.Optional;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public SearchRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<UserEntity> findUserEntityByName(String name) {
        UserEntity result = jpaQueryFactory
                .selectFrom(userEntity)
                .where(userEntity.name.eq(name))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public Optional<List<UserEntity>> findUserEntityAll(){
        List<UserEntity> result = jpaQueryFactory
                .selectFrom(userEntity)
                .fetch();

        return Optional.ofNullable(result);
    }
}
