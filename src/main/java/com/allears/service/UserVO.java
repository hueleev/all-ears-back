package com.allears.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 사용자 VO
 */
public class UserVO {
    Integer userSeq;
    String userId;
    String userPwd;
    String userNm;
    String userEmail;
    String userToken;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+9")
    Date cretDt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+9")
    Date amdDt;

    public Integer getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Integer userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Date getCretDt() {
        return cretDt;
    }

    public void setCretDt(Date cretDt) {
        this.cretDt = cretDt;
    }

    public Date getAmdDt() {
        return amdDt;
    }

    public void setAmdDt(Date amdDt) {
        this.amdDt = amdDt;
    }
}
