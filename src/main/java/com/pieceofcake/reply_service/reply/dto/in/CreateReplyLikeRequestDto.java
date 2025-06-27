package com.pieceofcake.reply_service.reply.dto.in;

import com.pieceofcake.reply_service.reply.domain.LikedReply;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyLikeRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateReplyLikeRequestDto {
    private String memberUuid;
    private String replyUuid;

    @Builder
    public CreateReplyLikeRequestDto(String memberUuid, String replyUuid) {
        this.memberUuid = memberUuid;
        this.replyUuid = replyUuid;
    }

    public static CreateReplyLikeRequestDto from(String memberUuid, CreateReplyLikeRequestVo createReplyLikeRequestVo) {
        return CreateReplyLikeRequestDto.builder()
                .memberUuid(memberUuid)
                .replyUuid(createReplyLikeRequestVo.getReplyUuid())
                .build();
    }

    public LikedReply toEntity() {
        return LikedReply.builder()
                .memberUuid(memberUuid)
                .replyUuid(replyUuid)
                .build();
    }
}
