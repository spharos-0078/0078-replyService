package com.pieceofcake.reply_service.reply.dto.in;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.in.CreateChildReplyRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateChildReplyRequestDto {

    private String memberUuid;
    private String parentReplyUuid;
    private String replyUuid;
    private String replyContent;

    private BoardType boardType;
    private String boardUuid;

    @Builder
    public CreateChildReplyRequestDto(
            String memberUuid,
            String parentReplyUuid,
            String replyUuid,
            String replyContent,
            BoardType boardType,
            String boardUuid
    ) {
        this.memberUuid = memberUuid;
        this.parentReplyUuid = parentReplyUuid;
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
        this.boardType = boardType;
        this.boardUuid = boardUuid;
    }

    public static CreateChildReplyRequestDto from(String memberUuid, String parentReplyUuid, CreateChildReplyRequestVo createChildReplyRequestVo) {
        return CreateChildReplyRequestDto.builder()
                .memberUuid(memberUuid)
                .parentReplyUuid(parentReplyUuid)
                .replyContent(createChildReplyRequestVo.getReplyContent())
                .build();
    }

    public Reply toEntity(String replyUuid) {
        return Reply.builder()
                .memberUuid(memberUuid)
                .parentReplyUuid(parentReplyUuid)
                .replyUuid(replyUuid)
                .replyContent(replyContent)
                .boardType(boardType)
                .boardUuid(boardUuid)
                .build();
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public void setBoardUuid(String boardUuid) {
        this.boardUuid = boardUuid;
    }
}
