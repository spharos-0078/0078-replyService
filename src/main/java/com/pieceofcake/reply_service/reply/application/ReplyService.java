package com.pieceofcake.reply_service.reply.application;


import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.DeleteReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
import com.pieceofcake.reply_service.reply.vo.out.GetReReplyResponseVo;

import java.util.List;

public interface ReplyService {

    List<GetReplyResponseDto> getReplyListByBoardTypeAndBoardUuid(String boardType, String boardUuid);

    void createReply(CreateReplyRequestDto createReplyRequestDto);

    void updateReply(UpdateReplyRequestDto updateReplyRequestDto);

    void deleteReply(DeleteReplyRequestDto deleteReplyRequestDto);

    List<GetReReplyResponseDto> getReReplyListByParentReplyUuid(String parentReplyUuid);
}
