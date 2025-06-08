package com.pieceofcake.reply_service.reply.presentation;

import com.pieceofcake.reply_service.common.entity.BaseResponseEntity;
import com.pieceofcake.reply_service.reply.application.ReplyService;
import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
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

}
