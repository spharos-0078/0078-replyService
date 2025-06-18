package com.pieceofcake.reply_service.reply.vo.out;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetReplyDetailResponseVo {

    private String replyUuid;
    private String replyContent;
    private String boardUuid;
    private BoardType boardType;
    private String memberUuid;
    private LocalDateTime createdAt;
    private boolean isMine;

    @Builder
    public GetReplyDetailResponseVo(
            String replyUuid,
            String replyContent,
            String boardUuid,
            BoardType boardType,
            String memberUuid,
            LocalDateTime createdAt,
            boolean isMine
    ) {
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
        this.boardUuid = boardUuid;
        this.boardType = boardType;
        this.memberUuid = memberUuid;
        this.createdAt = createdAt;
        this.isMine = isMine;
    }
}
