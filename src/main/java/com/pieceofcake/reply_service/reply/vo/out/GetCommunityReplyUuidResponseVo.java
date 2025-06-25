package com.pieceofcake.reply_service.reply.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCommunityReplyUuidResponseVo {

    private String replyUuid;

    @Builder
    public GetCommunityReplyUuidResponseVo(String replyUuid) {
        this.replyUuid = replyUuid;
    }
}
