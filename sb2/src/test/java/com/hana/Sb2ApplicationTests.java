package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;

@SpringBootTest
@Slf4j
class Sb2ApplicationTests {

    @Test
    void contextLoads() {
        String text="abc";

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("mykey");
        String atext = standardPBEStringEncryptor.encrypt(text);
        String aatext = standardPBEStringEncryptor.decrypt(atext);
        log.info("-----------------------LOG-----------------------"+atext);
        log.info("-----------------------LOG-----------------------"+aatext);
    }

}
