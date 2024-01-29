package talkwith.semogong.feature.join.repository;

import talkwith.semogong.domain.EmailCodeEntity;
import talkwith.semogong.domain.UserEntity;

import java.util.Optional;

public interface JoinRepository {
    Optional<UserEntity> findUserEntityByEmail(String email);
    Optional<UserEntity> findUserEntityByName(String username);
    void saveUserEntity(UserEntity userEntity);

    void saveEmailCodeEntitiy(EmailCodeEntity emailCodeEntity);

    Optional<EmailCodeEntity> findEmailCodeEntitiyByEmail(String email);

    void deleteEmailCodeEntitiy(String email);
}
