package talkwith.semogong.feature.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.ResponseDto;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.service.SearchService;
import talkwith.semogong.feature.search.validation.SearchValidationSequence;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public ResponseEntity<ResponseDto> searchUser(@Validated(value = SearchValidationSequence.class) SearchUserRequestDto searchUserRequestDto) throws Exception {
        SearchUserResponseDto searchUserResponseDto = searchService.searchUser(searchUserRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("회원조회가 정상적으로 완료되었습니다.", searchUserResponseDto));
    }

}
