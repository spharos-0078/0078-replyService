package com.pieceofcake.reply_service.reply.infrastructure;

import com.pieceofcake.reply_service.reply.domain.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReplyRepository extends MongoRepository<Reply, String> {

    List<Reply> findByBoardUuid(String boardUuid);

}
