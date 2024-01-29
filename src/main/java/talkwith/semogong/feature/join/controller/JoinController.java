package talkwith.semogong.feature.join.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.Response.SuccessResponse;
import talkwith.semogong.feature.join.dto.JoinCodeRequestDto;
import talkwith.semogong.feature.join.dto.JoinEmailRequestDto;
import talkwith.semogong.feature.join.dto.validation.JoinRequestDtoValidationSequence;
import talkwith.semogong.feature.join.dto.JoinFormRequestDto;
import talkwith.semogong.feature.join.service.JoinService;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/api/v1/join/check-duplicate")
    public ResponseEntity<SuccessResponse> checkDuplicateByJoinFormProcess(@Validated(value = JoinRequestDtoValidationSequence.class) @RequestBody JoinFormRequestDto joinFormRequestDto){
        joinService.checkDuplicateByJoinFormProcess(joinFormRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

    @PostMapping("/api/v1/join/send-code")
    public ResponseEntity<SuccessResponse> sendCodeToEmailProcess(@RequestBody JoinEmailRequestDto joinEmailRequestDto){
        joinService.sendCodeToEmailProcess(joinEmailRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

    @PostMapping("/api/v1/join/check-code")
    public ResponseEntity<SuccessResponse> checkCode(@RequestBody JoinCodeRequestDto joinCodeRequestDto){
        joinService.checkCodeProcess(joinCodeRequestDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

}
