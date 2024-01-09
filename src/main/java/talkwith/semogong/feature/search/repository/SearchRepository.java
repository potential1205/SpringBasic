package talkwith.semogong.feature.search.repository;

import talkwith.semogong.domain.UserEntity;

import java.util.Optional;

public interface SearchRepository {

    Optional<UserEntity> findUserEntityByName(String name);

}
