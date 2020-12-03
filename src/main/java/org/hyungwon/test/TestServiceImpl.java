package org.hyungwon.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDAO testDAO;

    @Override
    public BoardVO getBoardDtl(int boardSeq) {
        return testDAO.getBoardDtl(boardSeq);
    }
}
