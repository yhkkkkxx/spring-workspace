package com.hana.addr;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.service.AddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class UpdateTest {

    @Autowired
    AddrService addrService;
    @Test
    void contextLoads() {
        AddrDto addrDto = AddrDto.builder().addrId(5).addrName("퐁이집").addrDetail("사랑시 고백구 행복동").custId("id777").build();
        try {
            addrService.modify(addrDto);
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
