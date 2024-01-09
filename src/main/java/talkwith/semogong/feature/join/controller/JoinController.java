package talkwith.semogong.feature.join.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.ResponseDto;
import talkwith.semogong.common.validation.ValidationSequence;
import talkwith.semogong.feature.join.dto.JoinRequestDto;
import talkwith.semogong.feature.join.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<ResponseDto> joinUser(@Validated(value = ValidationSequence.class) JoinRequestDto joinRequestDto) throws Exception {
        joinService.joinUser(joinRequestDto);
        return new ResponseEntity<>(new ResponseDto("정상적으로 회원가입이 완료되었습니다."), new HttpHeaders(), HttpStatus.OK);
    }

}
