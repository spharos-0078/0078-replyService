package com.pieceofcake.reply_service.reply.application;

import com.pieceofcake.reply_service.reply.domain.Reply;
import com.pieceofcake.reply_service.reply.dto.in.CreateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.DeleteReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.in.UpdateReplyRequestDto;
import com.pieceofcake.reply_service.reply.dto.out.GetReReplyResponseDto;
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
    public List<GetReplyResponseDto> getReplyListByBoardTypeAndBoardUuid(String BoardType, String boardUuid) {
        List<Reply> replyList = replyRepository.findByBoardUuidAndDeletedFalse(boardUuid);
        return replyList.stream().map(GetReplyResponseDto::from).toList();
    }

    @Override
    public void createReply(CreateReplyRequestDto createReplyRequestDto) {
        replyRepository.save(createReplyRequestDto.toEntity());
    }

    @Override
    public void updateReply(UpdateReplyRequestDto updateReplyRequestDto) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(updateReplyRequestDto.getReplyUuid())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        if (!reply.getMemberUuid().equals(updateReplyRequestDto.getMemberUuid())) {
            throw new IllegalArgumentException("본인만 수정 가능합니다.");
        }

        replyRepository.save(updateReplyRequestDto.toEntity(reply));
    }

    @Override
    public void deleteReply(DeleteReplyRequestDto deleteReplyRequestDto) {
        Reply reply = replyRepository.findByReplyUuidAndDeletedFalse(deleteReplyRequestDto.getReplyUuid())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        if(!reply.getMemberUuid().equals(deleteReplyRequestDto.getMemberUuid())) {
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

}
