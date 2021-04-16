package com.allears.board;

import com.allears.common.domain.ResultVO;
import com.allears.common.pagination.PaginationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * 게시판 Controller
 */
@RestController
@RequestMapping("/board")
public class BoardController {

    /** logger */
    private final static Logger logger = LoggerFactory.getLogger(BoardController.class);

    /** bean */
    private final BoardService boardService;
    public BoardController(BoardService boardService)
    {
        this.boardService = boardService;
    }

    /**
     * 게시판 목록 조회
     * @param page
     * @param rows
     * @param sord
     * @param sidx
     * @return
     */
    @GetMapping("")
    public PaginationResponse<BoardVO> getBoardList(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "0") int rows,
                                                @RequestParam(required = false) String sord, @RequestParam(required = false) String sidx) {
        logger.debug(">>> [GET] /board >>> getBoardList >>> page[{}], rows[{}]", page, rows);
        BoardVO boardVO = new BoardVO();
        boardVO.setPage(page);
        boardVO.setRows(rows);
        boardVO.setSord(sord);
        boardVO.setSidx(sidx);
        return boardService.getBoardList(boardVO);
    }

    /**
     * 게시판 상세 조회
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    public BoardVO getBoardDtl(@PathVariable int boardSeq) {
        logger.debug(">>> [GET] /board >>> getBoardDtl >>> boardSeq[{}]", boardSeq);
        return boardService.getBoardDtl(boardSeq);
    }

    /**
     * 게시판 등록
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("")
    public ResultVO insertBoard(MultipartHttpServletRequest request) throws IOException {
        logger.debug(">>> [POST] /board >>> insertBoard");
        return boardService.insertBoard(request);
    }

    /**
     * 게시판 수정
     * @param request
     * @return
     * @throws IOException
     */
    @PutMapping("")
    public ResultVO updateBoard(MultipartHttpServletRequest request) throws IOException {
        logger.debug(">>> [PUT] /board >>> updateBoard");
        return boardService.updateBoard(request);
    }
    
    /**
     * 게시판 삭제
     * @param boardSeq
     * @return
     */
    @DeleteMapping("/{boardSeq}")
    public ResultVO deleteBoard(@PathVariable int boardSeq) {
        logger.debug(">>> [DELETE] /board >>> deleteBoard >>> boardSeq[{}]", boardSeq);
        return boardService.deleteBoard(boardSeq);
    }

}
