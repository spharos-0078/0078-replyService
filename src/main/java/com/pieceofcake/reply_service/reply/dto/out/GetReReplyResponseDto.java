package com.pieceofcake.reply_service.reply.dto.out;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.out.GetReReplyResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetReReplyResponseDto {

    private String memberUuid;
    private String replyUuid;
    private String replyContent;
    private LocalDateTime createdAt;

    @Builder
    public GetReReplyResponseDto(
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

    public static GetReReplyResponseDto from(Reply reply) {
        return GetReReplyResponseDto.builder()
                .memberUuid(reply.getMemberUuid())
                .replyUuid(reply.getReplyUuid())
                .replyContent(reply.getReplyContent())
                .createdAt(reply.getCreatedAt())
                .build();
    }

    public GetReReplyResponseVo toVo() {
        return GetReReplyResponseVo.builder()
                .memberUuid(memberUuid)
                .replyUuid(replyUuid)
                .replyContent(replyContent)
                .createdAt(createdAt)
                .build();
    }
}
