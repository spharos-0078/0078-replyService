package com.pieceofcake.reply_service.reply.vo.in;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateReplyRequestVo {

    private String boardUuid;
    private BoardType boardType;
    private String replyContent;
    private String parentReplyUuid;
    private LocalDateTime createdAt;

}
