package com.pieceofcake.reply_service.reply.infrastructure;

import com.pieceofcake.reply_service.reply.domain.LikedReply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReplyLikeRepository  extends MongoRepository<LikedReply, String> {

    Integer countByReplyUuid(String replyUuid);

    Optional<LikedReply> findByReplyUuidAndMemberUuid(String replyUuid, String memberUuid);
}
