package com.pieceofcake.reply_service.reply.domain;

import com.pieceofcake.reply_service.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document(collection = "reply_liked_db")
public class LikedReply{
    @Id
    private String id;

    private String replyUuid;
    private String memberUuid;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public LikedReply(String id, String replyUuid, String memberUuid) {
        this.id = id;
        this.replyUuid = replyUuid;
        this.memberUuid = memberUuid;
    }
}
