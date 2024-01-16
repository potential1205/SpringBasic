package talkwith.semogong.feature.search.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.feature.search.exception.NotExistsUserByName;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.repository.SearchRepository;
import talkwith.semogong.feature.search.service.SearchService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            throw new NotExistsUserByName(ExceptionInfo.RESOURCE_FOUND_FAIL,"존재하지 않는 사용자입니다.");
        }

        UserEntity userEntity = userByName.get();

        return SearchUserResponseDto.builder()
                .name(userEntity.getName())
                .rank(userEntity.getRank())
                .age(userEntity.getAge())
                .build();
    }

    @Override
    public List<SearchUserResponseDto> searchUsers() throws NotExistsUserByName{
        Optional<List<UserEntity>> findUsers = searchRepository.findUserEntityAll();

        if (findUsers.isEmpty()){
            throw new NotExistsUserByName(ExceptionInfo.RESOURCE_FOUND_FAIL,"사용자 목록이 비어있습니다.");
        }

        List<UserEntity> users = findUsers.get();

        return users.stream()
                .map(SearchUserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MetaData getMetaDataFromsearchUserResponseDtos(List<SearchUserResponseDto> searchUserResponseDtos){
        return MetaData.builder()
                .totalCount(searchUserResponseDtos.size())
                .build();
    }
}
