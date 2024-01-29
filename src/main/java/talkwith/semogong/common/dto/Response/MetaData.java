package talkwith.semogong.common.dto.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MetaData {

    private int totalCount;

    public MetaData(int totalCount){
        this.totalCount = totalCount;
    }
}
