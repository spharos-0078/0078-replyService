package com.pieceofcake.reply_service.reply.presentation;

import com.pieceofcake.reply_service.common.entity.BaseResponseEntity;
import com.pieceofcake.reply_service.common.entity.BaseResponseStatus;
import com.pieceofcake.reply_service.reply.application.ReplyService;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.DeleteReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.in.DeleteReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.in.UpdateReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.out.GetReReplyResponseVo;
import com.pieceofcake.reply_service.reply.vo.out.GetReplyResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyService replyService;

    // 페이지네이션 적용할 것
    @Operation(summary = "게시판 타입 + UUID별 댓글 전체 조회")
    @GetMapping("/list/{boardType}/{boardUuid}")
    public BaseResponseEntity<List<GetReplyResponseVo>> getReplyList(
            @PathVariable String boardType,
            @PathVariable String boardUuid
    ) {
        List<GetReplyResponseVo> result = replyService.getReplyListByBoardTypeAndBoardUuid(boardType, boardUuid)
                .stream().map(GetReplyResponseDto::toVo).toList();
        return new BaseResponseEntity<>(result);
    }

    // 댓글 생성
    @Operation(summary = "댓글 생성")
    @PostMapping
    public BaseResponseEntity<Void> createReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateReplyRequestVo createReplyRequestVo
    ) {
        replyService.createReply(CreateReplyRequestDto.from(memberUuid, createReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // 댓글 수정
    @Operation(summary = "댓글 수정")
    @PutMapping
    public BaseResponseEntity<Void> updateReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody UpdateReplyRequestVo updateReplyRequestVo
    ) {
        replyService.updateReply(UpdateReplyRequestDto.from(updateReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // 댓글 삭제
    @Operation(summary = "댓글 삭제")
    @DeleteMapping
    public BaseResponseEntity<Void> deleteReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody DeleteReplyRequestVo deleteReplyRequestVo
    ) {
        replyService.deleteReply(DeleteReplyRequestDto.from(memberUuid, deleteReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    // 대댓글 전체 조회 (부모 댓글 기준으로 대댓글 조회)
    @Operation(summary = "댓글별 대댓글 전체 조회")
    @GetMapping("/child/{parentReplyUuid}")
    public BaseResponseEntity<List<GetReReplyResponseVo>> getReReplyList(
            @PathVariable String parentReplyUuid
    ) {
        List<GetReReplyResponseVo> result = replyService.getReReplyListByParentReplyUuid(parentReplyUuid)
                .stream().map(GetReReplyResponseDto::toVo).toList();
        return new BaseResponseEntity<>(result);
    }

}
