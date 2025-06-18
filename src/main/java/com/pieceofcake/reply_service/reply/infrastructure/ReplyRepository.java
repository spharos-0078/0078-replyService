package com.pieceofcake.reply_service.reply.infrastructure;

import com.pieceofcake.reply_service.reply.domain.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends MongoRepository<Reply, String> {

    List<Reply> findByBoardUuidAndDeletedFalse(String boardUuid);

    List<Reply> findByParentReplyUuidAndDeletedFalse(String parentReplyUuid);

    @Query("{ 'replyUuid': ?0, 'deleted': false }")
    Optional<Reply> findByReplyUuidAndDeletedFalse(String replyUuid);
}
