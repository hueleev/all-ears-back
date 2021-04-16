package com.allears.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 게시판 DAO
 */
@Mapper
public interface BoardDAO {
    /** 게시판 목록 조회 */
    List<BoardVO> getBoardList(BoardVO boardVO);
    
    /** 게시판 목록 총 개수 조회 */
    int getBoardListCnt(BoardVO boardVO);
    
    /**  게시판 상세 조회 */
    BoardVO getBoardDtl(@Param("boardSeq") int boardSeq);

    /** 게시판 등록 */
    int insertBoard(BoardVO boardVO);

    /** 게시판 수정 */
    int updateBoard(BoardVO boardVO);

    /** 게시판 삭제 */
    int deleteBoard(@Param("boardSeq") int boardSeq);
}
