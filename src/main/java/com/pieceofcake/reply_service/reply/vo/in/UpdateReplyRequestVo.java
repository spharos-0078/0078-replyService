package com.pieceofcake.reply_service.reply.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateReplyRequestVo {

    private String replyUuid;
    private String replyContent;

    @Builder
    public UpdateReplyRequestVo(
            String replyUuid, String replyContent
    ) {
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
    }
}