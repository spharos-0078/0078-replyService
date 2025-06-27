package com.pieceofcake.reply_service.reply.application;


import com.pieceofcake.reply_service.reply.dto.in.CreateChildReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyLikeRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetCommunityReplyUuidResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyDetailResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReplyService {

    Page<GetCommunityReplyUuidResponseDto> getReplyListByBoardTypeAndBoardUuid(String boardType, String boardUuid, Pageable pageable);

    void createReply(CreateReplyRequestDto createReplyRequestDto);

    void updateReply(UpdateReplyRequestDto updateReplyRequestDto);

    void deleteReply(String memberUuid, String replyUuid);

    List<GetReReplyResponseDto> getReReplyListByParentReplyUuid(String parentReplyUuid);

    void createChildReply(CreateChildReplyRequestDto childReplyRequestDto);

    GetReplyDetailResponseDto getReplyDetail(String replyUuid, String memberUuid);

//    GetReplyDetailResponseDto getChildReplyDetail(String memberUuid, String replyUuid);

    void likeReply(CreateReplyLikeRequestDto createReplyLikeRequestDto);

    void cancelLikeReply(String id);
}
