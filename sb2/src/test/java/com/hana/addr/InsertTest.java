package com.hana.addr;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class InsertTest {

    @Autowired
    AddrService addrService;
    @Test
    void contextLoads() {
        AddrDto addrDto = AddrDto.builder().addrName("home").addrDetail("사랑시 고백구 행복동").custId("aaa").build();
        try {
            addrService.add(addrDto);
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
