package com.allears.service.Regist;

import com.allears.service.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 회원가입 DAO
 */
@Mapper
public interface RegistDAO {

    /** 중복 ID 체크 */
    int duplicatedId(@Param("userId") String userId);

    /** 회원 가입 */
    int insertUser(UserVO userVO);
}
