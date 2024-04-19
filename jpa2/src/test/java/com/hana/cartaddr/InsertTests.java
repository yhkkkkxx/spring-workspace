package com.hana.cartaddr;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.data.entity.ItemEntity;
import com.hana.app.service.CartService;
import com.hana.app.service.CustAddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InsertTests {
    @Autowired
    CustAddrService custAddrService;

    @Test
    void contextLoads() {
        CustEntity cust = CustEntity.builder().id("id01").build();
        CustAddrEntity custAddrEntity = CustAddrEntity.builder().cust(cust).addr("서울").build();
        

        custAddrService.insert(custAddrEntity);
        log.info("OK");
    }

}
