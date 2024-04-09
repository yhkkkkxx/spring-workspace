package com.hana.comment;

import com.hana.app.data.dto.CommentDto;
import com.hana.app.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class SelectOneTest {

    @Autowired
    CommentService commentService;
    @Test
    void contextLoads() {
        CommentDto commentDto = CommentDto.builder().custId("id01").commentContent("ㅗ").boardId(5).build();
        try {
            commentService.add(commentDto);
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException) {
                log.info("----------System Trouble EX0001----------------");
            } else if(e instanceof DuplicateKeyException) {
                log.info("----------ID Duplicateed EX0002----------------");
            } else {
                e.printStackTrace();
                log.info("----------Sorry EX0003----------------");
            }
        }
    }

}
