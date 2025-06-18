package com.pieceofcake.reply_service.reply.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateChildReplyRequestVo {

    private String replyContent;

    @Builder
    public CreateChildReplyRequestVo(String replyContent) {
        this.replyContent = replyContent;
    }
}
