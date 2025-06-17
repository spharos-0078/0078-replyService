package com.pieceofcake.reply_service.reply.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteReplyRequestVo {
    private String replyUuid;

    @Builder
    public DeleteReplyRequestVo(String replyUuid) {
        this.replyUuid = replyUuid;
    }
}