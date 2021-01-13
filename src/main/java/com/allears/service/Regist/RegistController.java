package com.allears.service.Regist;

import com.allears.common.domain.ResultVO;
import com.allears.service.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 회원가입 Controller
 */
@RestController
@RequestMapping("/regist")
public class RegistController {

    /** logger */
    private final static Logger logger = LoggerFactory.getLogger(RegistController.class);

    /** bean */
    private final RegistService registService;
    public RegistController(RegistService registService) {
        this.registService = registService;
    }

    /**
     * 중복 ID 체크
     * @param userId
     * @return
     */
    @GetMapping("/duplicated/{userId}")
    public ResultVO duplicatedId(@PathVariable String userId) {
        logger.debug(">>> [GET] /regist/duplicatedId >>> duplicatedId >>> userId[{}]", userId);
        return registService.duplicatedId(userId);
    }

    /**
     * 회원 가입
     * @param userVO
     * @return
     */
    @PostMapping("")
    public ResponseEntity<UserVO> insertUser(@RequestBody UserVO userVO) {
        logger.debug(">>> [POST] /regist >>> insertUser");
        userVO = registService.insertUser(userVO);
        return new ResponseEntity<>(userVO, HttpStatus.CREATED);
    }
}
