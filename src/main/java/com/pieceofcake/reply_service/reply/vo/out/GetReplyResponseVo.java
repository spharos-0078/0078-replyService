package com.pieceofcake.reply_service.reply.vo.out;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import lombok.Builder;

import java.time.LocalDateTime;

public class GetReplyResponseVo {

    private String replyUuid;
    private String memberUuid;
    private String boardUuid;
    private BoardType boardType;
    private String replyContent;
    private String parentReplyUuid;
    private LocalDateTime createdAt;

    @Builder
    public GetReplyResponseVo(
            String replyUuid, String memberUuid, String boardUuid, BoardType boardType,
            String replyContent, String parentReplyUuid, LocalDateTime createdAt
    ) {
        this.replyUuid = replyUuid;
        this.memberUuid = memberUuid;
        this.boardUuid = boardUuid;
        this.boardType = boardType;
        this.replyContent = replyContent;
        this.parentReplyUuid = parentReplyUuid;
        this.createdAt = createdAt;
    }
}
