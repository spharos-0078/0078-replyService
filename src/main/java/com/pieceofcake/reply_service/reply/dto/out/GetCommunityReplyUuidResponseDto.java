package com.pieceofcake.reply_service.reply.dto.out;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.out.GetCommunityReplyUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetCommunityReplyUuidResponseDto {

    private String replyUuid;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public GetCommunityReplyUuidResponseDto(
            String replyUuid, boolean deleted,
            LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.replyUuid = replyUuid;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static GetCommunityReplyUuidResponseDto from(Reply reply) {
        return GetCommunityReplyUuidResponseDto.builder()
                .replyUuid(reply.getReplyUuid())
                .deleted(reply.isDeleted())
                .createdAt(reply.getCreatedAt())
                .updatedAt(reply.getUpdatedAt())
                .build();
    }

    public GetCommunityReplyUuidResponseVo toVo() {
        return GetCommunityReplyUuidResponseVo.builder()
                .replyUuid(this.replyUuid)
                .deleted(this.deleted)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }
}
