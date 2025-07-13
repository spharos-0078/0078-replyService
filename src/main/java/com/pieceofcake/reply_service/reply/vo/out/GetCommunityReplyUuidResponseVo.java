package com.pieceofcake.reply_service.reply.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetCommunityReplyUuidResponseVo {

    private String replyUuid;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public GetCommunityReplyUuidResponseVo(
            String replyUuid,
            boolean deleted,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.replyUuid = replyUuid;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
