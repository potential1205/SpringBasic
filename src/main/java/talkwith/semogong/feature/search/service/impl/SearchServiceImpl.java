package talkwith.semogong.feature.search.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public SearchUserResponseDto searchUser(SearchUserRequestDto searchUserRequestDto) throws Exception {

        String name = searchUserRequestDto.getName();

        Optional<UserEntity> userByName = searchRepository.findUserEntityByName(name);

        if (userByName.isEmpty()){
            throw new Exception("feature/search/service/searchUser : 회원 이름과 일치하는 회원을 발견하지 못했습니다.");
        }

        UserEntity userEntity = userByName.get();

        SearchUserResponseDto searchUserResponseDto = SearchUserResponseDto.builder()
                .name(userEntity.getName())
                .rank(userEntity.getRank())
                .age(userEntity.getAge())
                .build();

        return searchUserResponseDto;
    }
}
