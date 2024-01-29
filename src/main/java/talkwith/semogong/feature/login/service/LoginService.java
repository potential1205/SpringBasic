package talkwith.semogong.feature.login.service;

import jakarta.servlet.http.HttpServletRequest;
import talkwith.semogong.feature.login.dto.LoginRequestDto;

public interface LoginService {
    void loginUser(LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest);

    void loginAdminUser(HttpServletRequest httpServletRequest);
}
