package talkwith.semogong.feature.join.service;

import talkwith.semogong.feature.join.dto.JoinRequestDto;

public interface JoinService {

    public void joinUser(JoinRequestDto joinRequestDto) throws Exception;
}
