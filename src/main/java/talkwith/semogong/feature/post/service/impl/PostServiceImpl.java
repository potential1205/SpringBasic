package talkwith.semogong.feature.post.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.AuthenticationFailException;
import talkwith.semogong.common.exception.ResourceNotFoundException;
import talkwith.semogong.domain.PostEntity;
import talkwith.semogong.domain.UserEntity;
import talkwith.semogong.feature.post.dto.PostRequestDto;
import talkwith.semogong.feature.post.dto.PostResponseDto;
import talkwith.semogong.feature.post.repository.PostRepository;
import talkwith.semogong.feature.post.service.PostService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void savePost(PostRequestDto postRequestDto, HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (httpSession == null){
            throw new AuthenticationFailException(ExceptionInfo.AUTHENTICATION_FAIL, "게시글 작성은 로그인이 필요합니다.");
        }

        String email = (String) httpSession.getAttribute("email");

        Optional<UserEntity> findUserEntity = postRepository.findUserEntityByEmail(email);

        if (findUserEntity.isEmpty()){
            throw new ResourceNotFoundException(ExceptionInfo.RESOURCE_NOT_FOUND, "게시글 작성이 불가합니다.");
        }

        PostEntity postEntity = PostEntity.builder()
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .userEntity(findUserEntity.get())
                .build();

        postRepository.savePost(postEntity);
    }

    @Override
    public List<PostResponseDto> showPosts(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);

        if (httpSession == null){
            throw new AuthenticationFailException(ExceptionInfo.AUTHENTICATION_FAIL, "권한이 없습니다. 로그인이 필요합니다.");
        }

        String email = (String) httpSession.getAttribute("email");
        Optional<UserEntity> findUserEntity = postRepository.findUserEntityByEmail(email);

        List<PostEntity> posts = postRepository.findPostEntityByUserEntity(findUserEntity.get());

        return posts.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public MetaData getMetaDataFromsearchPostResponseDtos(List<PostResponseDto> postResponseDtos){
        return MetaData.builder()
                .totalCount(postResponseDtos.size())
                .build();
    }

}
