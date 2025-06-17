package com.pieceofcake.reply_service.reply.infrastructure;

import com.pieceofcake.reply_service.reply.domain.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends MongoRepository<Reply, String> {

    List<Reply> findByBoardUuidAndDeletedFalse(String boardUuid);

    List<Reply> findByParentReplyUuidAndDeletedFalse(String parentReplyUuid);

    Optional<Reply> findByReplyUuidAndDeletedFalse(String replyUuid);
}
