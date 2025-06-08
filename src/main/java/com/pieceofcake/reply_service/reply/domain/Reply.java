package com.pieceofcake.reply_service.reply.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document(collection = "reply_db")
public class Reply {

    @Id
    private String id;

    private String replyUuid;

    private BoardType boardType;

    private String boardUuid;

    private String replyContent;

    private String memberUuid;

    private String parentReplyUuid;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Reply(String id, String replyUuid, BoardType boardType, String boardUuid,
                 String replyContent, String memberUuid,
                 String parentReplyUuid, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.id = id;
        this.replyUuid = replyUuid;
        this.boardType = boardType;
        this.boardUuid = boardUuid;
        this.replyContent = replyContent;
        this.memberUuid = memberUuid;
        this.parentReplyUuid = parentReplyUuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
