package com.pieceofcake.reply_service.reply.application;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
import com.pieceofcake.reply_service.reply.infrastructure.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public List<GetReplyResponseDto> getReplyListByBoardUuid(String boardUuid) {
        List<Reply> replyList = replyRepository.findByBoardUuid(boardUuid);
        return replyList.stream().map(GetReplyResponseDto::from).toList();
    }

}
