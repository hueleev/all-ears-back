package com.allears.service.Regist;

import com.allears.common.domain.ResultVO;
import com.allears.service.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * 회원가입 ServiceImpl
 */
@Service
public class RegistServiceImpl implements RegistService {

    /** logger */
    Logger logger = LoggerFactory.getLogger(RegistServiceImpl.class);

    /** bean */
    private final MessageSource messageSource;
    private final RegistDAO registDAO;
    public RegistServiceImpl(MessageSource messageSource, RegistDAO registDAO) {
        this.messageSource = messageSource;
        this.registDAO = registDAO;
    }

    /**
     * 중복 ID 체크
     * @param userId
     * @return
     */
    @Override
    public ResultVO duplicatedId(String userId) {
        ResultVO resultVO = new ResultVO();
        int result = registDAO.duplicatedId(userId);
        if (result > 0) {
            resultVO.setValid(false);
            resultVO.setData(userId);
            resultVO.setMessage(messageSource.getMessage("duplicated.id.false", null, Locale.getDefault()));
        } else {
            resultVO.setValid(true);
            resultVO.setData(userId);
            resultVO.setMessage(messageSource.getMessage("duplicated.id.true", null, Locale.getDefault()));
        }
        return resultVO;
    }

    /**
     * 회원 가입
     * @param userVO
     * @return
     */
    @Override
    public UserVO insertUser(UserVO userVO) {
        int result = registDAO.insertUser(userVO);
        return userVO;
    }
}
