package com.pieceofcake.reply_service.reply.dto.in;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.in.UpdateReplyRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateReplyRequestDto {

    private String memberUuid;
    private String replyUuid;
    private String replyContent;

    @Builder
    public UpdateReplyRequestDto(
            String memberUuid,
            String replyUuid,
            String replyContent
    ) {
        this.memberUuid = memberUuid;
        this.replyUuid = replyUuid;
        this.replyContent = replyContent;
    }

    public static UpdateReplyRequestDto from(UpdateReplyRequestVo updateReplyRequestVo) {
        return UpdateReplyRequestDto.builder()
                .replyContent(updateReplyRequestVo.getReplyContent())
                .replyUuid(updateReplyRequestVo.getReplyUuid())
                .build();
    }

    public Reply toEntity(Reply reply) {
        return Reply.builder()
                .replyContent(replyContent)
                .replyUuid(reply.getReplyUuid())
                .build();
    }
}
