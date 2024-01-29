package talkwith.semogong.feature.login.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.AuthenticationFailException;
import talkwith.semogong.common.exception.ResourceNotFoundException;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.join.repository.JoinRepository;
import talkwith.semogong.feature.login.dto.LoginRequestDto;

import talkwith.semogong.feature.login.repository.LoginRepository;
import talkwith.semogong.feature.login.service.LoginService;

import javax.swing.plaf.PanelUI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final JoinRepository joinRepository;

    @Override
    public void loginUser(LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest){
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Optional<UserEntity> findUserEntity = loginRepository.findUserEntityByEmail(email);

        if (findUserEntity.isEmpty()){
            throw new ResourceNotFoundException(ExceptionInfo.RESOURCE_NOT_FOUND, "존재하지 않는 계정입니다.");
        }

        UserEntity user = findUserEntity.get();

        if (!user.getPassword().equals(password)){
            throw new AuthenticationFailException(ExceptionInfo.AUTHENTICATION_FAIL, "비밀번호가 일치하지 않습니다.");
        }

        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("email", email);
        httpSession.setMaxInactiveInterval(60);
        //httpSession.setAttribute("role","ADMIN");
    }

    @Override
    public void loginAdminUser(HttpServletRequest httpServletRequest){
        String email = "dlwogns1205@naver.com";
        String password = "abcd1234";
        String name = "이재훈";

        UserEntity userEntity = UserEntity.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();

        joinRepository.saveUserEntity(userEntity);

        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("email", email);
        httpSession.setMaxInactiveInterval(3600);
    }

}
