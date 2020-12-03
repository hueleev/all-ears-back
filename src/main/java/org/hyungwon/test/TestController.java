package org.hyungwon.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;
    /*private final TestService testService;
    public TestController(MessageSource messageSource, TestService testService)
    {
        this.messageSource = messageSource;
        this.testService = testService;
    }*/

    @GetMapping("/{boardSeq}")
    public BoardVO test(@PathVariable int boardSeq) {
        logger.info("testt");
        return testService.getBoardDtl(boardSeq);
    }

}
