package com.pieceofcake.reply_service.reply.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetReReplyResponseVo {

    private String memberUuid;
    private String replyUuid;
    private String replyContent;
    private LocalDateTime createdAt;

    @Builder
    public GetReReplyResponseVo(
            String memberUuid,
            String replyUuid,
            String replyContent,
            LocalDateTime createdAt
    ) {
        this.memberUuid = memberUuid;
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
        this.createdAt = createdAt;
    }
}
