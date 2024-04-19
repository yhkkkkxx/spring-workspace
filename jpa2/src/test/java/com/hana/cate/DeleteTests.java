package com.hana.cate;

import com.hana.app.service.CateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DeleteTests {
    @Autowired
    CateService cateService;

    @Test
    void contextLoads() {
        cateService.delete(2);
        log.info("ok");
    }

}
