package com.pieceofcake.reply_service.reply.application;

import com.pieceofcake.reply_service.reply.domain.BoardType;
import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.dto.in.CreateChildReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetCommunityReplyUuidResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyDetailResponseDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReplyResponseDto;
import com.pieceofcake.reply_service.reply.infrastructure.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Page<GetCommunityReplyUuidResponseDto> getReplyListByBoardTypeAndBoardUuid(String boardType, String boardUuid, Pageable pageable) {
        Page<GetCommunityReplyUuidResponseDto> replyList = replyRepository.findByBoardTypeAndBoardUuidAndDeletedFalse(BoardType.valueOf(boardType), boardUuid, pageable)
                .map(GetCommunityReplyUuidResponseDto::from);
        return replyList;
    }

    @Transactional
    @Override
    public void createReply(CreateReplyRequestDto createReplyRequestDto) {
        replyRepository.save(createReplyRequestDto.toEntity(UUID.randomUUID().toString().substring(0, 32)));
    }

    @Transactional
    @Override
    public void updateReply(UpdateReplyRequestDto updateReplyRequestDto) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(updateReplyRequestDto.getReplyUuid())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        if (!reply.getMemberUuid().equals(updateReplyRequestDto.getMemberUuid())) {
            throw new IllegalArgumentException("본인만 수정 가능합니다.");
        }

        replyRepository.save(updateReplyRequestDto.toEntity(reply));
    }

    @Transactional
    @Override
    public void deleteReply(String memberUuid, String replyUuid) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(replyUuid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        if(!reply.getMemberUuid().equals(memberUuid)) {
            throw new IllegalArgumentException("본인이 작성한 댓글만 삭제할 수 있습니다.");
        }
        reply.softDelete();
        replyRepository.save(reply);
    }

    @Override
    public List<GetReReplyResponseDto> getReReplyListByParentReplyUuid(String parentReplyUuid) {
        List<Reply> reReplyList = replyRepository.findByParentReplyUuidAndDeletedFalse(parentReplyUuid);
        return reReplyList.stream().map(GetReReplyResponseDto::from).toList();
    }

    @Transactional
    @Override
    public void createChildReply(CreateChildReplyRequestDto childReplyRequestDto) {
        Reply parentReply = replyRepository.findByReplyUuidAndDeletedFalse(childReplyRequestDto.getParentReplyUuid())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부모 댓글입니다."));

        if(parentReply.getParentReplyUuid() != null) {
            throw new IllegalArgumentException("댓글에는 또 다른 대댓글을 작성할 수 없습니다.");
        }

        childReplyRequestDto.setBoardType(parentReply.getBoardType());
        childReplyRequestDto.setBoardUuid(parentReply.getBoardUuid());

        replyRepository.save(childReplyRequestDto.toEntity(UUID.randomUUID().toString().substring(0, 32)));
    }

    @Override
    public GetReplyDetailResponseDto getReplyDetail(String memberUuid, String replyUuid) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(replyUuid)
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));

        boolean isMine = memberUuid != null && reply.getMemberUuid().equals(memberUuid);

        return GetReplyDetailResponseDto.from(reply, isMine);
    }

    @Override
    public GetReplyDetailResponseDto getChildReplyDetail(String memberUuid, String replyUuid) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(replyUuid)
                .orElseThrow(() -> new IllegalArgumentException("대댓글을 찾을 수 없습니다."));

        if(reply.getParentReplyUuid() != null) {
            throw new IllegalArgumentException("해당 댓글은 대댓글이 아닙니다.");
        }

        boolean isMine = memberUuid != null && reply.getMemberUuid().equals(memberUuid);

        return GetReplyDetailResponseDto.from(reply, isMine);
    }
}
