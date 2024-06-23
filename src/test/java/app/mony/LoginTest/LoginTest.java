package app.mony.LoginTest;

import app.mony.system.utils.ChiperUtil;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@Slf4j

public class LoginTest {


    @Test
    @DisplayName("sha256 솔트 암호화 테스트")
    void sha256SaltTest(){

        String salt = ChiperUtil.getSalt();
        String password = "123";
        String encPassword = ChiperUtil.sha256Salt(password,salt);

        log.info("SALT = [{}]",salt);
        log.info("PASSWORD = [{}]",password);
        log.info("ENC_ PASSWORD = [{}]",encPassword);
    }

    @Test
    @DisplayName("salt + password 테스트")
    void sha256Test(){
        //SALT = [D0ECCA22918E869D867DBDF233CF8A 8CB646A48]
        //PASSWORD = [@test1234]
        //ENC_ PASSWORD = [D953DA4EDB59925AB49676 68C90D537F477CE91 E756FC7D4CD2BF9C0A555BA]
        String dbPassword = "15CEEF14CBD3BC99CFDAB28919 EBEEED642539821F96E9169 F68377933BF1C";
        String salt = "D0ECCA22918E869D867DBDF233CF8A 8CB646A48";
        String password ="@test1234";
        //82229C7518 97489FE3DFBCD12E1101348EE5DE95FD4DF25962B5F1A545F64D0
        //9D532D44CEBDBB36FAF7 DFD8A7162CA6346FC 9E91A2AC838E1 2F95499574E
        assertThat(dbPassword.equals(ChiperUtil.sha256Salt(password,salt))).isTrue();

    }
}
