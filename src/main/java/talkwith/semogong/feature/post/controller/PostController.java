package talkwith.semogong.feature.post.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import talkwith.semogong.common.dto.Response.ListResponse;
import talkwith.semogong.common.dto.Response.MetaData;
import talkwith.semogong.common.dto.Response.SuccessResponse;
import talkwith.semogong.feature.post.dto.PostRequestDto;
import talkwith.semogong.feature.post.dto.PostResponseDto;
import talkwith.semogong.feature.post.service.PostService;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/api/v1/post/save")
    public ResponseEntity<SuccessResponse> savePost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest httpServletRequest) {
        postService.savePost(postRequestDto, httpServletRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessResponse.of());
    }

    @PostMapping("/api/v1/post/list")
    public ResponseEntity<ListResponse<?>> showPosts(HttpServletRequest httpServletRequest){
        List<PostResponseDto> searchPostResponseDtos = postService.showPosts(httpServletRequest);
        MetaData metaData = postService.getMetaDataFromsearchPostResponseDtos(searchPostResponseDtos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ListResponse.of(metaData,searchPostResponseDtos));
    }

}
