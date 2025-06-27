package com.pieceofcake.reply_service.reply.infrastructure;

import com.pieceofcake.reply_service.reply.domain.LikedReply;
import com.pieceofcake.reply_service.reply.domain.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReplyLikeRepository  extends MongoRepository<LikedReply, String> {

    Integer countByReplyUuid(String replyUuid);
}
