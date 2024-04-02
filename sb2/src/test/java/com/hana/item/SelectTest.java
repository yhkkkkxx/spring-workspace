package com.hana.item;

import com.hana.app.service.CustService;
import com.hana.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class SelectTest {

    @Autowired
    ItemService itemService;
    @Test
    void contextLoads() {
        try {
            itemService.get();
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException) {
                log.info("----------System Trouble EX0001----------------");
            } else if(e instanceof DuplicateKeyException) {
                log.info("----------ID Duplicateed EX0002----------------");
            }
            e.printStackTrace();
        }
    }

}
