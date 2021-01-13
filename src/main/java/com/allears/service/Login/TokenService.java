package com.allears.service.Login;

import com.allears.service.TokenVO;
import com.allears.service.UserVO;

/**
 * 토큰 관련 Service
 */
public interface TokenService {

    /** 토큰 생성 */
    String createToken(UserVO userVO);

    /** 토큰 디코딩 */
    TokenVO decodeToken(String token);
}
