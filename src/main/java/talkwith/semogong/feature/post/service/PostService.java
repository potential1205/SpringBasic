package talkwith.semogong.feature.post.service;

import jakarta.servlet.http.HttpServletRequest;
import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.feature.post.dto.PostRequestDto;
import talkwith.semogong.feature.post.dto.PostResponseDto;

import java.util.List;

public interface PostService {

    void savePost(PostRequestDto postRequestDto, HttpServletRequest httpServletRequest);
    List<PostResponseDto> showPosts(HttpServletRequest httpServletRequest);

    MetaData getMetaDataFromsearchPostResponseDtos(List<PostResponseDto> postResponseDtos);
}
