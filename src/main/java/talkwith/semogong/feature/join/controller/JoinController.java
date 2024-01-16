package talkwith.semogong.feature.join.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.Response.SuccessResponse;
import talkwith.semogong.feature.join.validation.JoinValidationSequence;
import talkwith.semogong.feature.join.dto.JoinRequestDto;
import talkwith.semogong.feature.join.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<SuccessResponse> joinUser(@Validated(value = JoinValidationSequence.class) JoinRequestDto joinRequestDto) throws Exception {
        joinService.joinUser(joinRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }
}
