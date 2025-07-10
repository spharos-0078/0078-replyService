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
    private boolean deleted;

    @Builder
    public GetCommunityReplyUuidResponseDto(String replyUuid, boolean deleted) {
        this.replyUuid = replyUuid;
        this.deleted = deleted;
    }

    public static GetCommunityReplyUuidResponseDto from(Reply reply) {
        return GetCommunityReplyUuidResponseDto.builder()
                .replyUuid(reply.getReplyUuid())
                .deleted(reply.isDeleted())
                .build();
    }

    public GetCommunityReplyUuidResponseVo toVo() {
        return GetCommunityReplyUuidResponseVo.builder()
                .replyUuid(this.replyUuid)
                .deleted(this.deleted)
                .build();
    }
}
