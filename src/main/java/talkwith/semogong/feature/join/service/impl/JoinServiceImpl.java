package talkwith.semogong.feature.join.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.AuthenticationFailException;
import talkwith.semogong.common.exception.ResourceConflictException;
import talkwith.semogong.common.exception.ResourceNotFoundException;
import talkwith.semogong.domain.EmailCodeEntity;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.join.dto.JoinCodeRequestDto;
import talkwith.semogong.feature.join.dto.JoinEmailRequestDto;
import talkwith.semogong.feature.join.dto.JoinFormRequestDto;
import talkwith.semogong.feature.join.repository.JoinRepository;
import talkwith.semogong.feature.join.service.JoinService;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinServiceImpl implements JoinService {

    private final JoinRepository joinRepository;
    private final Random random = new Random();

    private final JavaMailSender javaMailSender;

    @Override
    public void checkDuplicateByJoinFormProcess(JoinFormRequestDto joinFormRequestDto) {
        checkDuplicateEmail(joinFormRequestDto.getEmail());
        checkDuplicateName(joinFormRequestDto.getName());
    }

    public void checkDuplicateEmail(String email) {
        Optional<UserEntity> userEntityByEmail = joinRepository.findUserEntityByEmail(email);

        if (userEntityByEmail.isPresent()) {
            throw new ResourceConflictException(ExceptionInfo.RESOURCE_CONFLICT, "이미 사용 중인 이메일입니다.");
        }
    }

    public void checkDuplicateName(String name) {
        Optional<UserEntity> userEntityByName = joinRepository.findUserEntityByName(name);

        if (userEntityByName.isPresent()) {
            throw new ResourceConflictException(ExceptionInfo.RESOURCE_CONFLICT, "이미 사용 중인 이름입니다.");
        }
    }

    @Override
    public void sendCodeToEmailProcess(JoinEmailRequestDto joinEmailRequestDto){
        String code = Integer.toString(random.nextInt(888888) + 111111);
        String email = joinEmailRequestDto.getEmail();

        Optional<EmailCodeEntity> findEmailCodeEntitiy = joinRepository.findEmailCodeEntitiyByEmail(email);

        if (findEmailCodeEntitiy.isPresent()){
            joinRepository.deleteEmailCodeEntitiy(email);
        }

        EmailCodeEntity emailCodeEntity = EmailCodeEntity.builder()
                .code(code)
                .email(email)
                .build();

        joinRepository.saveEmailCodeEntitiy(emailCodeEntity);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("dlwogns1205@gmail.com");
        simpleMailMessage.setSubject("[세상의 모든 공부] 일반 회원가입 이메일 인증");
        simpleMailMessage.setText("세모공에 방문해주셔서 감사합니다.\n\n" + "인증번호는 " + code + " 입니다." + "\n\n 인증번호를 인증코드란에 기입해주세요.");

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void checkCodeProcess(JoinCodeRequestDto joinCodeRequestDto){
        String email = joinCodeRequestDto.getEmail();

        Optional<EmailCodeEntity> findEmailCodeEntitiy = joinRepository.findEmailCodeEntitiyByEmail(email);

        if (findEmailCodeEntitiy.isEmpty()){
            throw new ResourceNotFoundException(ExceptionInfo.RESOURCE_NOT_FOUND,"인증번호가 생성되지 않았습니다.");
        }

        EmailCodeEntity emailCodeEntity = findEmailCodeEntitiy.get();
        String code = emailCodeEntity.getCode();

        if (!code.equals(joinCodeRequestDto.getCode())){
            throw new AuthenticationFailException(ExceptionInfo.AUTHENTICATION_FAIL, "인증번호가 일치하지 않습니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .email(joinCodeRequestDto.getEmail())
                .password(joinCodeRequestDto.getPassword())
                .name(joinCodeRequestDto.getName())
                .build();

        joinRepository.saveUserEntity(userEntity);
    }
}
