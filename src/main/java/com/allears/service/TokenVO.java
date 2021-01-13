package com.allears.service;

import java.util.Date;

/**
 * 토큰 VO
 */
public class TokenVO {
    private String token; // 토큰
    private String issuer; // 토큰 발급자
    private String audience; // 토큰 사용자 (userId와 동일)
    private String subject; // 토큰의 내용
    private Date expireDate; // 토큰 만료 시간
    private String jwtId; // 토큰에 대한 식별자
    private String message; // 결과 메시지
    private String userId;
    private String userNm; // 사용자명
    private Boolean valid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getJwtId() {
        return jwtId;
    }

    public void setJwtId(String jwtId) {
        this.jwtId = jwtId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
