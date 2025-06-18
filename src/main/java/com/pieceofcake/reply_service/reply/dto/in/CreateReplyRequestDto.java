package com.pieceofcake.reply_service.reply.dto.in;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CreateReplyRequestDto {

    private String boardUuid;
    private BoardType boardType;
    private String replyUuid;
    private String replyContent;
    private String memberUuid;

    @Builder
    public CreateReplyRequestDto(
            String boardUuid, BoardType boardType, String replyUuid, String replyContent,
            String memberUuid
    ) {
        this.boardUuid = boardUuid;
        this.boardType = boardType;
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
        this.memberUuid = memberUuid;
    }

    public static CreateReplyRequestDto from(String memberUuid, CreateReplyRequestVo createReplyRequestVo) {
        return CreateReplyRequestDto.builder()
                .boardUuid(createReplyRequestVo.getBoardUuid())
                .boardType(createReplyRequestVo.getBoardType())
                .replyContent(createReplyRequestVo.getReplyContent())
                .memberUuid(memberUuid)
                .build();
    }

    public Reply toEntity(String replyUuid) {
        return Reply.builder()
                .boardUuid(boardUuid)
                .boardType(boardType)
                .replyContent(replyContent)
                .replyUuid(replyUuid)
                .memberUuid(memberUuid)
                .build();
    }

}
