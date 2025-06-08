package com.pieceofcake.reply_service.reply.dto.out;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.out.GetReplyResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetReplyResponseDto {

    private String replyUuid;
    private String memberUuid;
    private String boardUuid;
    private BoardType boardType;
    private String replyContent;
    private String parentReplyUuid;
    private LocalDateTime createdAt;

    @Builder
    public GetReplyResponseDto(
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

    public static GetReplyResponseDto from(Reply reply) {
        return GetReplyResponseDto.builder()
                .replyUuid(reply.getReplyUuid())
                .memberUuid(reply.getMemberUuid())
                .boardUuid(reply.getBoardUuid())
                .boardType(reply.getBoardType())
                .replyContent(reply.getReplyContent())
                .parentReplyUuid(reply.getParentReplyUuid())
                .createdAt(reply.getCreatedAt())
                .build();
    }

    public GetReplyResponseVo toVo() {
        return GetReplyResponseVo.builder()
                .replyUuid(this.replyUuid)
                .memberUuid(this.memberUuid)
                .boardUuid(this.boardUuid)
                .boardType(this.boardType)
                .replyContent(this.replyContent)
                .parentReplyUuid(this.parentReplyUuid)
                .createdAt(this.createdAt)
                .build();

    }
}
