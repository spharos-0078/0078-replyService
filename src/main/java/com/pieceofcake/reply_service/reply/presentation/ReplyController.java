package com.pieceofcake.reply_service.reply.presentation;

import com.pieceofcake.reply_service.common.entity.BaseResponseEntity;
import com.pieceofcake.reply_service.common.entity.BaseResponseStatus;
import com.pieceofcake.reply_service.reply.application.ReplyService;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyRequestVo;
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
    @Operation(summary = "게시판 UUID별 댓글 전체 조회")
    @GetMapping("/list/{boardUuid}")
    public BaseResponseEntity<List<GetReplyResponseVo>> getReplyList(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @PathVariable String boardUuid
    ) {
        List<GetReplyResponseVo> result = replyService.getReplyListByBoardUuid(boardUuid)
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

    // 대댓글 전체 조회 (부모 댓글 기준으로 대댓글 조회)


}
