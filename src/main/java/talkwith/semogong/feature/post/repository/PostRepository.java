package talkwith.semogong.feature.post.repository;

import talkwith.semogong.domain.PostEntity;
import talkwith.semogong.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    void savePost(PostEntity postEntity);

    Optional<UserEntity> findUserEntityByEmail(String email);

    List<PostEntity> findPostEntityByUserEntity(UserEntity userEntity);
}
