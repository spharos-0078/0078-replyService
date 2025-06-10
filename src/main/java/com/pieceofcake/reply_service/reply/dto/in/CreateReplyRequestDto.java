package com.pieceofcake.reply_service.reply.dto.in;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateReplyRequestDto {

    private String boardUuid;
    private BoardType boardType;
    private String replyUuid;
    private String replyContent;
    private String memberUuid;
    private String parentReplyUuid;
    private LocalDateTime createdAt;

    @Builder
    public CreateReplyRequestDto(
            String boardUuid, BoardType boardType, String replyUuid, String replyContent,
            String memberUuid, String parentReplyUuid, LocalDateTime createdAt
    ) {
        this.boardUuid = boardUuid;
        this.boardType = boardType;
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
        this.memberUuid = memberUuid;
        this.parentReplyUuid = parentReplyUuid;
        this.createdAt = createdAt;
    }

    public static CreateReplyRequestDto from(String memberUuid, CreateReplyRequestVo createReplyRequestVo) {
        return CreateReplyRequestDto.builder()
                .boardUuid(createReplyRequestVo.getBoardUuid())
                .boardType(createReplyRequestVo.getBoardType())
                .replyUuid(UUID.randomUUID().toString().substring(0, 32))
                .replyContent(createReplyRequestVo.getReplyContent())
                .memberUuid(memberUuid)
                .parentReplyUuid(createReplyRequestVo.getParentReplyUuid())
                .createdAt(createReplyRequestVo.getCreatedAt())
                .build();
    }

    public Reply toEntity() {
        return Reply.builder()
                .boardUuid(boardUuid)
                .boardType(boardType)
                .replyContent(replyContent)
                .memberUuid(memberUuid)
                .parentReplyUuid(parentReplyUuid)
                .createdAt(createdAt)
                .build();
    }

}
