package talkwith.semogong.feature.search.service;

import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;

public interface SearchService {
    SearchUserResponseDto searchUser(SearchUserRequestDto searchUserRequestDto) throws Exception;
}
