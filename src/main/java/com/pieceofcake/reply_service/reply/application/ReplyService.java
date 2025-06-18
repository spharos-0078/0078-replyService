package com.pieceofcake.reply_service.reply.application;


import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;

import java.util.List;

public interface ReplyService {

    List<GetReplyResponseDto> getReplyListByBoardTypeAndBoardUuid(String boardType, String boardUuid);

    void createReply(CreateReplyRequestDto createReplyRequestDto);

    void updateReply(UpdateReplyRequestDto updateReplyRequestDto);

    void deleteReply(String memberUuid, String replyUuid);

    List<GetReReplyResponseDto> getReReplyListByParentReplyUuid(String parentReplyUuid);
}
