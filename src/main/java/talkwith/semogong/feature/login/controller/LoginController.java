package talkwith.semogong.feature.login.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.Response.SuccessResponse;
import talkwith.semogong.feature.login.dto.LoginRequestDto;
import talkwith.semogong.feature.login.service.LoginService;
import talkwith.semogong.feature.login.dto.validation.LoginValidationSequence;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<SuccessResponse> loginUser(@Validated(value = LoginValidationSequence.class)@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) {
        loginService.loginUser(loginRequestDto, httpServletRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

    @PostMapping("/api/v1/admin-login")
    public ResponseEntity<SuccessResponse> loginAdminUser(HttpServletRequest httpServletRequest){
        loginService.loginAdminUser(httpServletRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

}
