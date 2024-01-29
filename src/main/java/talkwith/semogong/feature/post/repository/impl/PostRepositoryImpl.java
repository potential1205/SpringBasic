package talkwith.semogong.feature.post.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import talkwith.semogong.domain.PostEntity;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.post.repository.PostRepository;

import static talkwith.semogong.domain.QPostEntity.postEntity;
import static talkwith.semogong.domain.QUserEntity.userEntity;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public PostRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
    @Override
    public void savePost(PostEntity postEntity) {
        entityManager.persist(postEntity);
    }

    @Override
    public Optional<UserEntity> findUserEntityByEmail(String email) {
        UserEntity result = jpaQueryFactory
                .selectFrom(userEntity)
                .where(userEntity.email.eq(email))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public List<PostEntity> findPostEntityByUserEntity(UserEntity userEntity) {
        List<PostEntity> result = jpaQueryFactory
                .selectFrom(postEntity)
                .where(postEntity.userEntity.eq(userEntity))
                .fetch();

        return result;
    }


}
