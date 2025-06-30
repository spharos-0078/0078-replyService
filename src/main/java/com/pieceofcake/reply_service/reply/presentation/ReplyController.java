package com.pieceofcake.reply_service.reply.presentation;

import com.pieceofcake.reply_service.common.entity.BaseResponseEntity;
import com.pieceofcake.reply_service.common.entity.BaseResponseStatus;
import com.pieceofcake.reply_service.reply.application.ReplyService;
import com.pieceofcake.reply_service.reply.dto.in.CreateChildReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyLikeRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetCommunityReplyUuidResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyDetailResponseDto;
import com.pieceofcake.reply_service.reply.vo.in.CreateChildReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyLikeRequestVo;
import com.pieceofcake.reply_service.reply.vo.in.CreateReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.in.UpdateReplyRequestVo;
import com.pieceofcake.reply_service.reply.vo.out.GetCommunityReplyUuidResponseVo;
import com.pieceofcake.reply_service.reply.vo.out.GetReReplyResponseVo;
import com.pieceofcake.reply_service.reply.vo.out.GetReplyDetailResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyService replyService;

    @Operation(summary = "커뮤니티 댓글 UUID 리스트 조회 (전체 조회)")
    @GetMapping("/list/{boardType}/{boardUuid}")
    public BaseResponseEntity<List<GetCommunityReplyUuidResponseVo>> getCommunityReplyUuidList(
            @PathVariable String boardType,
            @PathVariable String boardUuid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<GetCommunityReplyUuidResponseVo> replyList = replyService.getReplyListByBoardTypeAndBoardUuid(boardType, boardUuid, pageable)
                .stream().map(GetCommunityReplyUuidResponseDto::toVo).toList();
        return new BaseResponseEntity<>(replyList);
    }


    @Operation(summary = "커뮤니티 댓글 생성")
    @PostMapping
    public BaseResponseEntity<Void> createReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateReplyRequestVo createReplyRequestVo
    ) {
        replyService.createReply(CreateReplyRequestDto.from(memberUuid, createReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }


    @Operation(summary = "커뮤니티 댓글 수정")
    @PutMapping
    public BaseResponseEntity<Void> updateReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody UpdateReplyRequestVo updateReplyRequestVo
    ) {
        replyService.updateReply(UpdateReplyRequestDto.from(updateReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }


    @Operation(summary = "커뮤니티 댓글 삭제")
    @DeleteMapping("/{replyUuid}")
    public BaseResponseEntity<Void> deleteReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @PathVariable String replyUuid
    ) {
        replyService.deleteReply(memberUuid, replyUuid);
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }


    @Operation(summary = "커뮤니티 대댓글 전체 조회")
    @GetMapping("/child/{parentReplyUuid}")
    public BaseResponseEntity<List<GetReReplyResponseVo>> getReReplyList(
            @PathVariable String parentReplyUuid
    ) {
        List<GetReReplyResponseVo> result = replyService.getReReplyListByParentReplyUuid(parentReplyUuid)
                .stream().map(GetReReplyResponseDto::toVo).toList();
        return new BaseResponseEntity<>(result);
    }


    @Operation(summary = "커뮤니티 댓글 상세 조회")
    @GetMapping("/community/{replyUuid}")
    public BaseResponseEntity<GetReplyDetailResponseVo> getReplyDetail(
            @RequestHeader(value = "X-Member-Uuid", required = false) String memberUuid,
            @PathVariable String replyUuid
    ) {
        GetReplyDetailResponseDto result = replyService.getReplyDetail(memberUuid, replyUuid);

        return new BaseResponseEntity<>(result.toVo());
    }


    // 문의 댓글 상세 조회


    @Operation(summary = "대댓글 작성")
    @PostMapping("/child/{parentReplyUuid}")
    public BaseResponseEntity<Void> createReReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @PathVariable String parentReplyUuid,
            @RequestBody CreateChildReplyRequestVo createChildReplyRequestVo
    ) {
        replyService.createChildReply(CreateChildReplyRequestDto.from(memberUuid, parentReplyUuid, createChildReplyRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "댓글 찜 토글")
    @PostMapping("/like")
    public BaseResponseEntity<Void> likeReply(
            @RequestHeader("X-Member-Uuid") String memberUuid,
            @RequestBody CreateReplyLikeRequestVo createReplyLikeRequestVo
    ) {
        replyService.likeReply(CreateReplyLikeRequestDto.from(memberUuid, createReplyLikeRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }
}
