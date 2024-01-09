package talkwith.semogong.feature.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.ResponseDto;
import talkwith.semogong.feature.search.dto.SearchUserRequestDto;
import talkwith.semogong.feature.search.dto.SearchUserResponseDto;
import talkwith.semogong.feature.search.service.SearchService;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search")
    public ResponseEntity<ResponseDto> searchUser(SearchUserRequestDto searchUserRequestDto) throws Exception {
        SearchUserResponseDto searchUserResponseDto = searchService.searchUser(searchUserRequestDto);
        return new ResponseEntity<>(new ResponseDto("정상적으로 회원 조회가 완료되었습니다.", searchUserResponseDto), new HttpHeaders(), HttpStatus.OK);
    }

}
