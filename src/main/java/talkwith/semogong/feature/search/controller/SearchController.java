package talkwith.semogong.feature.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.Response.ListResponse;
import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.service.SearchService;
import talkwith.semogong.feature.search.validation.SearchValidationSequence;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public ResponseEntity<SearchUserResponseDto> searchUser(@Validated(value = SearchValidationSequence.class) SearchUserRequestDto searchUserRequestDto) {
        SearchUserResponseDto searchUserResponseDto = searchService.searchUser(searchUserRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(searchUserResponseDto);
    }

    @PostMapping("/search-all")
    public ResponseEntity<ListResponse<?>> searchUsers() {
        List<SearchUserResponseDto> searchUserResponseDtos = searchService.searchUsers();
        MetaData metaData = searchService.getMetaDataFromsearchUserResponseDtos(searchUserResponseDtos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ListResponse.of(metaData,searchUserResponseDtos));
    }
}
