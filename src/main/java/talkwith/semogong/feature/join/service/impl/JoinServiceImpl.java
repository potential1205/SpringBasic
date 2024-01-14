package talkwith.semogong.feature.join.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.common.enums.Rank;
import talkwith.semogong.feature.join.exception.DuplicateNameException;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.join.dto.JoinRequestDto;
import talkwith.semogong.feature.join.exception.ErrorCode;
import talkwith.semogong.feature.join.repository.JoinRepository;
import talkwith.semogong.feature.join.service.JoinService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinServiceImpl implements JoinService {

    private final JoinRepository joinRepository;

    @Override
    @Transactional
    public void joinUser(JoinRequestDto joinRequestDto) throws DuplicateNameException {
        String name = joinRequestDto.getName();
        String password = joinRequestDto.getPassword();
        int age = joinRequestDto.getAge();

        Optional<UserEntity> userEntityByName = joinRepository.findUserEntityByName(name);

        if (userEntityByName.isPresent()) {
            throw new DuplicateNameException(ErrorCode.USER_COMMON_FAIL, "이미 존재한 회원 이름입니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .password(password)
                .age(age)
                .rank(Rank.SILVER)
                .build();

        joinRepository.saveUser(userEntity);
    }
}
