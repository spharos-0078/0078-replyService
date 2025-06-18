package com.pieceofcake.reply_service.reply.dto.out;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.out.GetReplyDetailResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetReplyDetailResponseDto {

    private String replyUuid;
    private String replyContent;
    private String boardUuid;
    private BoardType boardType;
    private String memberUuid;
    private LocalDateTime createdAt;
    private boolean isMine;

    @Builder
    public GetReplyDetailResponseDto(
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

    public static GetReplyDetailResponseDto from(Reply reply, boolean isMine) {
        return GetReplyDetailResponseDto.builder()
                .replyUuid(reply.getReplyUuid())
                .replyContent(reply.getReplyContent())
                .boardUuid(reply.getBoardUuid())
                .boardType(reply.getBoardType())
                .memberUuid(reply.getMemberUuid())
                .createdAt(reply.getCreatedAt())
                .isMine(isMine)
                .build();
    }

    public GetReplyDetailResponseVo toVo() {
        return GetReplyDetailResponseVo.builder()
                .replyUuid(replyUuid)
                .replyContent(replyContent)
                .boardUuid(boardUuid)
                .boardType(boardType)
                .memberUuid(memberUuid)
                .createdAt(createdAt)
                .isMine(isMine)
                .build();
    }

}
