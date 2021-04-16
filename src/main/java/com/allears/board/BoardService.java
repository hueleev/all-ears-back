package com.allears.board;

import com.allears.common.domain.ResultVO;
import com.allears.common.pagination.PaginationResponse;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * 게시판 Service
 */
public interface BoardService {

    /** 게시판 목록 조회 */
    PaginationResponse<BoardVO> getBoardList(BoardVO boardVO);
    
    /** 게시판 상세 조회 */
    BoardVO getBoardDtl(int boardSeq);

    /** 게시판 등록 */
    ResultVO insertBoard(MultipartHttpServletRequest request) throws IOException;

    /** update board */
    ResultVO updateBoard(MultipartHttpServletRequest request) throws IOException;

    /** delete board */
    ResultVO deleteBoard(int boardSeq);

}
