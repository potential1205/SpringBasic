package talkwith.semogong.feature.search.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.feature.search.exception.NotExistsUserByName;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.repository.SearchRepository;
import talkwith.semogong.feature.search.service.SearchService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {

    private final SearchRepository searchRepository;

    @Override
    public SearchUserResponseDto searchUser(SearchUserRequestDto searchUserRequestDto) throws NotExistsUserByName {

        String name = searchUserRequestDto.getName();

        Optional<UserEntity> userByName = searchRepository.findUserEntityByName(name);

        if (userByName.isEmpty()){
            throw NotExistsUserByName.builder()
                    .message("이름이 '" + name + "'인 회원을 찾을 수 없습니다.")
                    .build();
        }

        UserEntity userEntity = userByName.get();

        return SearchUserResponseDto.builder()
                .name(userEntity.getName())
                .rank(userEntity.getRank())
                .age(userEntity.getAge())
                .build();
    }
}
