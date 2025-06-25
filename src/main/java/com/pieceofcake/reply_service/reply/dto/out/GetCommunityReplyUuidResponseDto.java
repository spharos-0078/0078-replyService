package com.pieceofcake.reply_service.reply.dto.out;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.vo.out.GetCommunityReplyUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCommunityReplyUuidResponseDto {

    private String replyUuid;

    @Builder
    public GetCommunityReplyUuidResponseDto(String replyUuid) {
        this.replyUuid = replyUuid;
    }

    public static GetCommunityReplyUuidResponseDto from(Reply reply) {
        return GetCommunityReplyUuidResponseDto.builder()
                .replyUuid(reply.getReplyUuid())
                .build();
    }

    public GetCommunityReplyUuidResponseVo toVo() {
        return GetCommunityReplyUuidResponseVo.builder()
                .replyUuid(this.replyUuid)
                .build();
    }
}
