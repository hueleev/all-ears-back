package com.allears.service.Login;

import com.allears.common.Constants;
import com.allears.service.TokenVO;
import com.allears.service.UserVO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 토큰 관련 ServiceImpl
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Value("${common.auth.sessionmin}")
    private int sessionMin;

    /**
     * 토큰 생성
     * @param userVO
     * @return
     */
    @Override
    public String createToken(UserVO userVO) {
        String token = "";
        Date expireDate = new Date(System.currentTimeMillis() + (60 * 1000 * sessionMin));

        Algorithm algorithm = Algorithm.HMAC256(Constants.Token.SECRET_KEY);
        token = JWT.create()
                .withIssuer(Constants.Token.ISSUER)
                .withSubject(Constants.Token.SUBJECT)
                .withAudience(userVO.getUserId())
                .withClaim("userNm", userVO.getUserNm())
                .withExpiresAt(expireDate)
                .sign(algorithm);
        return token;
    }

    /**
     * 토큰 디코딩
     * @param token
     * @return
     */
    @Override
    public TokenVO decodeToken(String token) {
        // bearer 삭제
        token = removeBearer(token);
        
        TokenVO tokenVO = new TokenVO();

        DecodedJWT jwt = JWT.decode(token);
        tokenVO.setToken(token);
        tokenVO.setAudience(jwt.getAudience().get(0));
        tokenVO.setIssuer(jwt.getIssuer());
        tokenVO.setSubject(jwt.getSubject());
        tokenVO.setUserId(jwt.getClaim("userId").asString());
        tokenVO.setUserNm(jwt.getClaim("userNm").asString());
        tokenVO.setExpireDate(jwt.getExpiresAt());

        return tokenVO;
    }

    /**
     * 토큰에 붙은 bearer 삭제
      * @param token
     * @return
     */
    private String removeBearer(String token) {
        if (token == null) {
            return null;
        }

        if (token != null && "".equals(token)) {
            token = token.trim();
        }

        if (StringUtils.hasText(token) && token.toLowerCase().startsWith("bearer ")) {
            token = token.substring(7, token.length());
        }
        return token;
    }
}
