package talkwith.semogong.feature.search.service;

import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.exception.NotExistsUserByName;

import java.util.List;

public interface SearchService {
    SearchUserResponseDto searchUser(SearchUserRequestDto searchUserRequestDto) throws NotExistsUserByName;

    List<SearchUserResponseDto> searchUsers() throws NotExistsUserByName;

    MetaData getMetaDataFromsearchUserResponseDtos(List<SearchUserResponseDto> searchUserResponseDtos);
}
