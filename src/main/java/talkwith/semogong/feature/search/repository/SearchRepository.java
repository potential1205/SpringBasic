package talkwith.semogong.feature.search.repository;

import talkwith.semogong.domain.UserEntity;
import java.util.List;
import java.util.Optional;

public interface SearchRepository {

    Optional<UserEntity> findUserEntityByName(String name);

    Optional<List<UserEntity>> findUserEntityAll();

}
