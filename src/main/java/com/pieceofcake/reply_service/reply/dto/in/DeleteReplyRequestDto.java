package com.pieceofcake.reply_service.reply.dto.in;

import com.pieceofcake.reply_service.reply.vo.in.DeleteReplyRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteReplyRequestDto {
    private String memberUuid;
    private String replyUuid;

    @Builder
    public DeleteReplyRequestDto(
            String memberUuid,
            String replyUuid
    ) {
        this.memberUuid = memberUuid;
        this.replyUuid = replyUuid;
    }

    public static DeleteReplyRequestDto from(String memberUuid, DeleteReplyRequestVo deleteReplyRequestVo) {
        return DeleteReplyRequestDto.builder()
                .memberUuid(memberUuid)
                .replyUuid(deleteReplyRequestVo.getReplyUuid())
                .build();
    }
}
