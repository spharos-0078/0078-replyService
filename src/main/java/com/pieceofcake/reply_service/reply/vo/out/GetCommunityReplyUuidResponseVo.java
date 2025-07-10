package com.pieceofcake.reply_service.reply.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCommunityReplyUuidResponseVo {

    private String replyUuid;
    private boolean deleted;

    @Builder
    public GetCommunityReplyUuidResponseVo(
            String replyUuid,
            boolean deleted
    ) {
        this.replyUuid = replyUuid;
        this.deleted = deleted;
    }
}
