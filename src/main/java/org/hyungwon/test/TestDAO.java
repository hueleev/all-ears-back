package org.hyungwon.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestDAO {
    BoardVO getBoardDtl(@Param("boardSeq") int boardSeq);
}
