package com.allears.board;

import com.allears.common.Constants;
import com.allears.common.domain.ResultVO;
import com.allears.common.pagination.PaginationResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.util.List;

/**
 * 게시판 ServiceImpl
 */
@Service
public class BoardServiceImpl implements BoardService {

    /** bean */
    private final BoardDAO boardDAO;
    public BoardServiceImpl(BoardDAO boardDAO)
    {
        this.boardDAO = boardDAO;
    }

    @Value("${common.defaultrows}")
    private int defaultrows;

    /**
     * 게시판 목록 조회
     * @param boardVO
     * @return
     */
    @Override
    public PaginationResponse<BoardVO> getBoardList(BoardVO boardVO) {
        if (boardVO.getPage() == 0 ) {
            boardVO.setPage(1);
        }
        if (boardVO.getRows() == 0 ){
            boardVO.setRows(defaultrows);
        }
        List<BoardVO> rows = boardDAO.getBoardList(boardVO);
        int totalRecodrs =  boardDAO.getBoardListCnt(boardVO);

        PaginationResponse<BoardVO> result = new PaginationResponse<>(rows,totalRecodrs, boardVO.getPage(), boardVO.getRows(), boardVO.getPageId());
        return result;
    }

    /**
     * 게시판 조회
     * @param boardSeq
     * @return
     */
    @Override
    public BoardVO getBoardDtl(int boardSeq) {
        BoardVO boardVO = boardDAO.getBoardDtl(boardSeq);
        boardVO.setBoardPhotoSbst(Base64.decodeBase64(boardVO.getBoardPhotoSbst()));
        return boardVO;
    }

    /**
     * 게시판 등록
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO insertBoard(MultipartHttpServletRequest request) throws IOException {

       // MultipartFile mFile = request.getFile("file");

        BoardVO boardVO = new BoardVO();
        String boardTitle = request.getParameter("boardTitle");
        String boardCn = request.getParameter("boardCn");

        boardVO.setBoardTitle(boardTitle);
        boardVO.setBoardCn(boardCn);
       // if (mFile != null) { boardVO.setBoardPhotoSbst(Base64.encodeBase64(mFile.getBytes())); }
        boardVO.setCretrId("test");

        ResultVO resultVO = new ResultVO();
        int result = boardDAO.insertBoard(boardVO);
        if (result > 0) {
            resultVO.setValid(true);
            resultVO.setData(boardVO);
            resultVO.setMessage(Constants.Result.SUCCESS);
        }
        return resultVO;
    }

    /**
     * 게시판 수정
     * @param boardVO
     * @return
     */
    @Override
    public ResultVO updateBoard(BoardVO boardVO) {
        return null;
    }

    /**
     * 게시판 삭제
     * @param boardSeq
     * @return
     */
    @Override
    public ResultVO deleteBoard(int boardSeq) {
        ResultVO resultVO = new ResultVO();
        int result = boardDAO.deleteBoard(boardSeq);
        if (result > 0) {
            resultVO.setValid(true);
            resultVO.setData(boardSeq);
            resultVO.setMessage(Constants.Result.SUCCESS);
        }
        return resultVO;
    }
}
