package com.pieceofcake.reply_service.reply.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardType {
    REPORT,
    EVENT,
    FAQ,
    NORMAL_REQUEST,
    SALE_REQUEST,
    FUNDING,
    PIECE
}
