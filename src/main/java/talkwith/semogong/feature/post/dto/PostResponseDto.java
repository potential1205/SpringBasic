package talkwith.semogong.feature.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import talkwith.semogong.domain.PostEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;

    public PostResponseDto(PostEntity postEntity) {
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
    }
}
