package talkwith.semogong.feature.login.repository;

import talkwith.semogong.domain.UserEntity;

import java.util.Optional;

public interface LoginRepository {
    Optional<UserEntity> findUserEntityByEmail(String email);
}
