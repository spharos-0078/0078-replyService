package com.pieceofcake.reply_service.reply.application;


import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;

import java.util.List;

public interface ReplyService {

    List<GetReplyResponseDto> getReplyListByBoardUuid(String boardUuid);

}
