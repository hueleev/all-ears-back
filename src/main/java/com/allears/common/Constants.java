package com.allears.common;

public class Constants {
    /**
     * token 관련 상수
     */
    public static class Token {
        public static final String ISSUER = "allEars"; // 토큰 발급자
        public static final String SUBJECT = "subject"; // 토큰에 담길 내용
        public static final String SECRET_KEY = "allEars_secretKey_!"; // 암호화를 위한 비밀키
        public static final String REMOVED_TOKEN_VALUE = "removed"; // 로그아웃 등으로 삭제된 토큰값
    }

    public static class Result {
        public static final String SUCCESS = "success";
        public static final String FAIL = "fail";
    }
}
