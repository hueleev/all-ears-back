package com.allears.service.Regist;

import com.allears.common.domain.ResultVO;
import com.allears.service.UserVO;

/**
 * 회원가입 Service
 */
public interface RegistService {
    /** 중복 ID 체크 */
    ResultVO duplicatedId(String userId);

    /** 회원 가입 */
    UserVO insertUser(UserVO userVO);
}
