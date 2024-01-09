package talkwith.semogong.feature.join.repository;

import talkwith.semogong.domain.UserEntity;

import java.util.Optional;

public interface JoinRepository {
    Optional<UserEntity> findUserEntityByName(String username);

    void saveUser(UserEntity userEntity);
}
